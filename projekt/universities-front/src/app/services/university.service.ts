import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { University } from '../models/University';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UniversityService {
  baseUrl = 'http://localhost:8080/';
  
  constructor(private http:HttpClient) { }

  getUniversities(): Observable<any> {
    return this.http.get('//localhost:8080/university');
  //  return this.http.get<University[]>(this.baseUrl + 'university', httpOptions);
  }

//   addOpinion(opinion: Opinion): Observable<Opinion> {
//     return this.http.post<Opinion>(this.baseUrl + opinion.ratedUserId + '/' + opinion.ratingUserId + '/opinions',
//             opinion, httpOptions);
//   }

//   getUserReceivedOpinions(userId: string): Observable<Opinion[]> {
    
//     return this.http.get<Opinion[]>(this.baseUrl + userId + '/opinions',httpOptions);
// }

}
