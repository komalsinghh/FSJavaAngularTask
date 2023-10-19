import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  public getTransactionData(transactionData:any): Observable<any> {
    return this.http.post("https://f6d6270a-e1ab-4665-9360-e00ee2320327.mock.pstmn.io/api/transactions/analyze",transactionData);
  }
}
