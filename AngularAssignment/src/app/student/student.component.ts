import { Component } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms'
import { Router} from '@angular/router';
import {StudentService} from '../student.service'

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  viewStudent = new FormGroup({
    roll : new FormControl(''),
    dob : new FormControl('')
  })
  constructor(private student:StudentService,private router:Router) { }
  collection:any = []
  ngOnInit(): void {
  }
  result(){
    this.student.fetchStudent(this.viewStudent.value['roll'],this.viewStudent.value['dob']).subscribe((result)=>{
      this.collection=result
      this.router.navigate(['/view'])
    })
  }
 
}
