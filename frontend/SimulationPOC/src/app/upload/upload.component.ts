import { Component, OnInit } from '@angular/core';
import { Subject } from '../shared/subject';
import { SubjectService } from '../shared/subject.service';
import { TestPaper } from '../shared/test-paper';
import { Question } from '../shared/question';
import { TestService } from '../shared/test.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  subjects:Subject[]=[];
  tests:TestPaper[]=[];
  questions:Question[]=[];
  subjectFlag:boolean=true;
  questionFlag:boolean=false;
  paperFlag:boolean=false;
  test:TestPaper;
  testId:any;
  constructor(private subjectService:SubjectService, private testService:TestService) { }

  ngOnInit() {
   // this.getSubjects();
   this.testId=this.testService.testId();
     this.getQuestions(this.testId);
  }

getSubjects() {
    this.subjectService.getSubjects().subscribe(
      data => {
        this.subjects = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  getPapers(subjectId: number) {
    if (subjectId > 0) {
      this.paperFlag = true;
      this.subjectService.getPapers(subjectId).subscribe(
        data => {
          this.tests = data;
          console.log(data);
        },
        error => {
          console.log(error);
        }
      );
    }

  }

  getQuestions(testId) {
    //this.testId=this.testService.testId;
    if (testId > 0) {
      //this.testId=testId;
      this.questionFlag = true;
     // this.paperFlag=false;
      this.subjectFlag=false;
      this.testService.getQuestions(testId).subscribe(
        data => {
          this.questions = data;
          console.log(data + " ");
        },
        error => {
          console.log(error);
        }
      );
    }
    else{
      this.subjectFlag=true;
      this.questionFlag=false;
      this.getSubjects();
    }
  }
}
