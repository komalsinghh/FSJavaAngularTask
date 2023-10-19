import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseApiUrl from './helper';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatresponseService {

  constructor(private http: HttpClient) { }

  getChatResponse(chat:any):Observable<any>{
        return this.http.get<any>(`${baseApiUrl}/api/ChatGPT/chat?message=${chat}`);
  }
  
}
