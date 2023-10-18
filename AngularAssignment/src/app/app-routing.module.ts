import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './add-student/add-student.component';
import { HomeComponent } from './home/home.component';
import { ListStudentComponent } from './list-student/list-student.component';
import { StudentComponent } from './student/student.component';
import { TeacherComponent } from './teacher/teacher.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentComponent } from './view-student/view-student.component';

const routes: Routes = [
  {
    path:'',
    redirectTo:'home',pathMatch:'full'
  },
  {
    component:StudentComponent,
    path:'student'
  },
  {
    component:HomeComponent,
    path:''
  },
  {
    component:TeacherComponent,
    path:'teacher'
  },
  {
    component:AddStudentComponent,
    path:'teacher/add'
  },
  {
    component:ListStudentComponent,
    path:'teacher/list'
  },
  {
    component:UpdateStudentComponent,
    path:'update'
  },
  {
    component:ViewStudentComponent,
    path:'view'
    },
    {
      component:UpdateStudentComponent,
      path:'update/:id'
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
