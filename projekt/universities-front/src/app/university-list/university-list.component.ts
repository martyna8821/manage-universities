import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../services/university.service';
import { University } from '../models/University';

@Component({
  selector: 'app-university-list',
  templateUrl: './university-list.component.html',
  styleUrls: ['./university-list.component.css']
})
export class UniversityListComponent implements OnInit {

  universities: University[];

  constructor(private universityService: UniversityService) { }

  getUniversities(){
    this.universityService.getUniversities().subscribe(u => this.universities = u);
  }

  ngOnInit() {
  
    this.universityService.getUniversities().subscribe(u => this.universities = u);
  }


  updateUniveristy(university: University){
    
  }

  deleteUniversity(universityId: string){
    this.universityService.deleteUniversity(universityId).subscribe();
    this.universityService.getUniversities().subscribe(u => this.universities = u);
  }

  

}
