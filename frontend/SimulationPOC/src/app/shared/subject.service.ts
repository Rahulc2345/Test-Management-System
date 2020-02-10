import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/index';
import { TestPaper } from './test-paper';
import { Subject } from './subject';
@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  
  constructor(private http: HttpClient) { }
  baseUrl = "http://localhost:8080";
  getPapers(subjectId: number): Observable<TestPaper[]> {
   
    const headers = new HttpHeaders({ Authorization: sessionStorage.getItem('token')});

    return this.http.get<TestPaper[]>(this.baseUrl + "/subject/" + subjectId, {headers})

  }

  getSubjects(): Observable<Subject[]> {
    
   const headers = new HttpHeaders({ Authorization: sessionStorage.getItem('token')});
    console.log(headers);
    return this.http.get<Subject[]>(this.baseUrl + "/subject",  {headers})
  }

}
