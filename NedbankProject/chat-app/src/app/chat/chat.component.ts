import { Component, OnInit } from '@angular/core';
import { io } from 'socket.io-client';

interface Message {
  content: string;
  incoming: boolean;
}

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  messages: Message[] = [];
  newMessage: string = '';
  private socket: any;

  ngOnInit() {
    this.socket = io('http://localhost:3000'); // Replace with your Socket.IO server URL
    this.socket.on('message', (message: any) => {
      this.receiveMessage(message);
    });
  }

  sendMessage() {
    if (this.newMessage) {
      const message: Message = {
        content: this.newMessage,
        incoming: false
      };
      this.messages.push(message);
      this.socket.emit('message', message);
      this.newMessage = '';
    }
  }

  receiveMessage(message: Message) {
    message.incoming = true;
    this.messages.push(message);
  }
}
