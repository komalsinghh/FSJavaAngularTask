import { Component,OnInit } from '@angular/core';
import {StudentService} from '../student.service';


@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})

export class ViewStudentComponent implements OnInit {
  constructor(private student: StudentService) { }
  collection: any = []
  ngOnInit(): void {
    this.student.viewStudent().subscribe((result: any) => {
      console.warn("result", result)
      this.collection = result
    })
  }


}
