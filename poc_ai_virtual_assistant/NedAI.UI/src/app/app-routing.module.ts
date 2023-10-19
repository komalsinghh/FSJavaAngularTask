import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionComponent } from './components/transaction/transaction.component';
import { ChatBoxComponent } from './components/chat-box/chat-box.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {path:'transaction', component: TransactionComponent, canActivate:[AuthGuard], pathMatch:'full'},
  {path:'', component:ChatBoxComponent, pathMatch:'full'},
  {path:'chatbot', component:ChatBoxComponent, pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
