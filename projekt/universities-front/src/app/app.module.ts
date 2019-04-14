import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UniversityListComponent } from './university-list/university-list.component';
import { StudentListComponent } from './student-list/student-list.component';
import { FieldOfStudyListComponent } from './field-of-study-list/field-of-study-list.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'; 

const appRoutes: Routes = [
  { path: 'student', component: StudentListComponent },
  { path: 'university', component: UniversityListComponent },
  { path: 'field', component: FieldOfStudyListComponent },
  { path: '',
    redirectTo: '/student',
    pathMatch: 'full'
  },
  { path: '**', component: StudentListComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UniversityListComponent,
    StudentListComponent,
    FieldOfStudyListComponent
    
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule.forRoot(
      appRoutes),
      HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
