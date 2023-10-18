import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  collection:any = []
  url = "http://localhost:3000"
  constructor(private http:HttpClient) { }
  getList(){
    return this.http.get<any>("http://localhost:3000/posts").pipe(map((res:any)=>{
      console.log("list working komal");
      return res;
    }))
  }
  saveStudent(data:any){
    console.log(this.url,data)
   return this.http.post<any>("http://localhost:3000/posts",data).pipe(map((res:any)=>{
    return res;
   }))
  }
  deleteStudent(id:any){
    return this.http.delete<any>("http://localhost:3000/posts/"+id).pipe(map((res:any)=>{
      return res;
    }))
  }
  getStudent(id:any){
    return this.http.get<any>("http://localhost:3000/posts/"+id).pipe(map((res:any)=>{
      return res;
    }))
  }
  updateStudent(id:any,data:any){
    return this.http.put<any>("http://localhost:3000/posts/"+id,data).pipe(map((res:any)=>{
      return res;
    }))

  }
  fetchStudent(roll:any,dob:any){
    this.collection =  this.http.get(`http://localhost:3000/posts?roll=${roll}&dob=${dob}`)
    return this.http.get(`http://localhost:3000/posts?roll=${roll}&dob=${dob}`)
  }
  viewStudent(){
    return this.collection
  }
}
