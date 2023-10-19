<<<<<<< HEAD
import { Component } from '@angular/core';
import { Router } from '@angular/router';
=======
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { TransactionService } from 'src/app/services/transaction/transaction.service';
>>>>>>> feature/initial_setup

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
<<<<<<< HEAD
export class TransactionComponent {
  constructor(private router: Router) { }
  transactions = [
    {
      "user_id": "123456789",
      "transaction_id": "txn123",
      "date": "2023-07-24",
      "amount": 50.25,
      "description": "Online Purchase - Books",
      "category": "Shopping",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn124",
      "date": "2023-07-25",
      "amount": 20.10,
      "description": "Coffee Shop",
      "category": "Food & Drinks",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn125",
      "date": "2023-07-25",
      "amount": 10000.00,
      "description": "Gasoline",
      "category": "Transportation",
      "fraud_alert": true
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn126",
      "date": "2023-07-26",
      "amount": 70.80,
      "description": "Movie Tickets",
      "category": "Entertainment",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn123",
      "date": "2023-07-24",
      "amount": 50.25,
      "description": "Online Purchase - Books",
      "category": "Shopping",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn124",
      "date": "2023-07-25",
      "amount": 20.10,
      "description": "Coffee Shop",
      "category": "Food & Drinks",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn125",
      "date": "2023-07-25",
      "amount": 10000.00,
      "description": "Gasoline",
      "category": "Transportation",
      "fraud_alert": true
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn126",
      "date": "2023-07-26",
      "amount": 70.80,
      "description": "Movie Tickets",
      "category": "Entertainment",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn123",
      "date": "2023-07-24",
      "amount": 50.25,
      "description": "Online Purchase - Books",
      "category": "Shopping",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn124",
      "date": "2023-07-25",
      "amount": 20.10,
      "description": "Coffee Shop",
      "category": "Food & Drinks",
      "fraud_alert": false
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn125",
      "date": "2023-07-25",
      "amount": 10000.00,
      "description": "Gasoline",
      "category": "Transportation",
      "fraud_alert": true
    },
    {
      "user_id": "123456789",
      "transaction_id": "txn126",
      "date": "2023-07-26",
      "amount": 70.80,
      "description": "Movie Tickets",
      "category": "Entertainment",
      "fraud_alert": false
    }
  ];
    
  displayedColumns: string[] = ['user_id', 'transaction_id', 'date', 'amount', 'description', 'category', 'fraud_alert'];

  showFraudAlertColumn:boolean= false;

  toggleFraudulentColumn(){
    this.showFraudAlertColumn=!this.showFraudAlertColumn;
    }

  showCategoryColumn:boolean= false;
    
  toggleCategoryColumn(){
    this.showCategoryColumn=!this.showCategoryColumn;
    }

   categoryIcons:{[category:string]: string}={
      'Shopping':'shopping_cart',
      'Entertainment': 'theaters',
      'Food & Drinks': 'restaurant',
      'Transportation':'commute'
   }

   getCategoryIcon(category:string):string{
      const defaultIcon='category';
      return this.categoryIcons[category] || defaultIcon;
   }
=======
export class TransactionComponent implements OnInit {
  transactionData = {
    "categorize": false,
    "fraudDetection": false,
    "fromDate": "09-08-2023",
    "toDate": "10-08-2023"
  }
  data: any = [];
  constructor(private router: Router, private service: TransactionService) { }
  ngOnInit() {
    this.service.getTransactionData(this.transactionData).subscribe(
      (data: any) => {
        this.data = data;
        console.log(data);

      }
    )
    this.transactions.valueChanges.subscribe(selectedOption => {
      this.updateTransaction(selectedOption);
      console.log(selectedOption);

    });
  }
  updateTransaction(selectedOption: string[]): void {
    this.transactionData.categorize = selectedOption.includes('Categorize');
    this.transactionData.fraudDetection = selectedOption.includes('Possible Fraudulent');
  }

  transactions = new FormControl();

  transactionList = ['Categorize', 'Possible Fraudulent'];

  displayedColumns: string[] = ['userId', 'transactionId', 'date', 'amount', 'description', 'category', 'possibleFraudulent'];

  categoryIcons: { [category: string]: string } = {
    'Shopping': 'shopping_cart',
    'Entertainment': 'theaters',
    'Food & Drinks': 'restaurant',
    'Transportation': 'commute'
  }

  getCategoryIcon(category: string): string {
    const defaultIcon = 'category';
    return this.categoryIcons[category] || defaultIcon;
  }
>>>>>>> feature/initial_setup
}
