import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms'
import {StudentService} from '../student.service'

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  addStudent = new FormGroup({
    name : new FormControl(''),
    roll : new FormControl(''),
    dob : new FormControl(''),
    score : new FormControl('')
  })
  constructor(private student:StudentService) { }

  ngOnInit(): void {
  }
  savingStudent(data:any){
      this.student.saveStudent(data).subscribe((ans)=>{
      })
      this.addStudent.reset();
  }
}
