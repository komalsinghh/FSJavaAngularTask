import { AfterViewInit, Component, ElementRef, EventEmitter, OnDestroy, OnInit, Output } from '@angular/core';
import { ViewChild } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ChatresponseService } from 'src/app/services/chatresponse.service';
import { SpeechRecognitionService } from 'src/app/services/speech-recognition.service';
import { Observable, Subscription, timer } from 'rxjs';
import { take } from 'rxjs/operators';

interface Message {
  content: string;
  incoming: boolean;
}

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements AfterViewInit, OnDestroy, OnInit {
  messages: Message[] = [];
  newMessage: string = '';
  isListening: boolean = false;
  micActive: boolean = false;
  micActiveDuration: number = 8000;
  private micActiveTimerSubscription: Subscription | undefined;


  @ViewChild('chatContainer', { static: false }) chatContainer!: ElementRef;

  private scrollContainer!: HTMLElement;
  private mutationObserver!: MutationObserver | null;

  ngAfterViewInit() {
    this.scrollContainer = this.chatContainer.nativeElement;
    this.scrollToBottom();
    this.observeNewMessages();
  }

  scrollToBottom() {
    this.scrollContainer.scrollTop = this.scrollContainer.scrollHeight;
  }

  observeNewMessages() {
    this.mutationObserver = new MutationObserver(() => {
      this.scrollToBottom();
    });

    this.mutationObserver.observe(this.scrollContainer, { childList: true });
  }
  ngOnDestroy() {
    if (this.mutationObserver) {
      this.mutationObserver.disconnect();
    }
    this.stopMicActiveTimer();
  }

  constructor(private chatResponse: ChatresponseService, private snackBar: MatSnackBar, private speechRecognitionService: SpeechRecognitionService) { }

  ngOnInit(): void {
    this.speechRecognitionService.listen().subscribe((text: string) => {
      this.newMessage = text;
      this.sendMessage();
    });
  }
  sendMessage(): void {
    if (this.newMessage) {
      const message: Message = {
        content: this.newMessage,
        incoming: false
      };
      this.messages.push(message);
      // this.sendMessageToBackend(this.newMessage);
      this.newMessage = '';
    }
  }

  private sendMessageToBackend(message: string): void {
    this.chatResponse.getChatResponse(message).subscribe({
      next: (data) => {
        if (data.hasFollowUp) {
          const msg: Message = {
            content: data.followUp,
            incoming: true
          };
          this.messages.push(msg);
        } else {
          const msg: Message = {
            content: data.response,
            incoming: true
          };
          this.messages.push(msg);
        }
      },

      error: (response) => {
        console.log(response);
        this.snackBar.open('Something went wrong!', '', {
          duration: 5000,
        });
      }
    })

  }

  toggleListen(): void {
    if (!this.isListening) {
      this.startMicActiveTimer();
      this.speechRecognitionService.start();
    } else {
      this.stopMicActiveTimer();
      this.speechRecognitionService.stop();
    }
    this.isListening = !this.isListening;
  }

  private startMicActiveTimer(): void {
    this.micActive = true;
    this.micActiveTimerSubscription = timer(this.micActiveDuration).pipe(take(1)).subscribe(() => {
      this.stopMicActiveTimer();
      this.isListening = false;
    });
  }

  private stopMicActiveTimer(): void {
    this.micActive = false;
    if (this.micActiveTimerSubscription) {
      this.micActiveTimerSubscription.unsubscribe();
    }
  }
  @Output() menuItemClicked = new EventEmitter<string>();

  handleMenuItemClick(option: string): void {
    this.menuItemClicked.emit(option);
  }
}
