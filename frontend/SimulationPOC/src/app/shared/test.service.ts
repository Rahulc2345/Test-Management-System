import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestOptions } from '@angular/http';
import {  Observable } from 'rxjs/index';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class TestService {
    getTestId: number;

  constructor(public http:HttpClient) { }
  baseUrl="http://localhost:8080";
   
   getQuestions(testId:number):Observable<Question[]>{
     this.getTestId=testId;
     const headers = new HttpHeaders({ Authorization: sessionStorage.getItem('token')});
    return this.http.get<Question[]>(this.baseUrl+"/test/"+testId, {headers})
   }

  //  addQuestion(question:Question,testId:number){
  //    let body=JSON.stringify(question);
  //    let headers:Headers=new Headers({'Content-Type': 'application/json'});
  //    let options=new RequestOptions({headers : headers});
     
  //    return this.http.post(this.baseUrl+"/test/"+testId+"/question/addQuestion", body, options)
  //  }

  addQuestion(question:object, testId:number){
    const headers = new HttpHeaders({ Authorization: sessionStorage.getItem('token')});
    return this.http.post(this.baseUrl+"/test/"+testId+"/question/addQuestion", question, {headers})
  }

  deleteQuestion(testId:number, questionId:number){
    const headers = new HttpHeaders({ Authorization: sessionStorage.getItem('token')});
    return this.http.delete(this.baseUrl+"/test/"+testId+"/question/"+questionId, {headers})
  }

  updateQuestion(testId:number, question: Question){
    const headers = new HttpHeaders({ Authorization: sessionStorage.getItem('token')});
    return this.http.put(this.baseUrl+"/test/"+testId+"/question/"+question.question_id, question, {headers})
  }

  testId(){
    return this.getTestId;
  }
}
