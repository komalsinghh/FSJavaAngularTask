import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpeechRecognitionService {
  private recognition: any;
  private observer!: Observer<string>;
  private timeout: any;
  private isListening: boolean = false;

  constructor() {
    this.recognition = new ((window as any).SpeechRecognition || (window as any).webkitSpeechRecognition)();
    this.recognition.interimResults = true;
    this.recognition.addEventListener('result', (event: any) => {
      const transcript = Array.from(event.results)
        .map((result: any) => result[0])
        .map((result: any) => result.transcript)
        .join('');

      if (event.results[0].isFinal) {
        if (this.observer) {
          this.observer.next(transcript);
        }
      }
    });
  }

  start(): void {
    this.isListening = true;
    this.recognition.start();
    this.timeout = setTimeout(() => {
      this.stop();
    }, 9000);
  }

  stop(): void {
    this.isListening = false;
    this.recognition.stop();
    clearTimeout(this.timeout);
  }

  listen(): Observable<string> {
    return new Observable<string>((observer: Observer<string>) => {
      this.observer = observer;
    });
  }
}

