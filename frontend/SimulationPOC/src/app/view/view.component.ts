import { Component, OnInit, ViewChild } from '@angular/core';
import { SubjectService } from "../shared/subject.service";
import { TestService } from "../shared/test.service";
import { TestPaper } from "../shared/test-paper";
import { Question } from "../shared/question";
import { Subject } from "../shared/subject";
import { Observable } from 'rxjs';
import { FormControl, FormGroup, Validators, NgForm } from '@angular/forms';


@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  constructor(private subjectService: SubjectService, private testService: TestService) { }

  subjects: Subject[] = [];
  tests: TestPaper[] = [];
  questions: Question[] = [];
  question: Question;
  ques: Question = new Question();
  submitted: boolean = false;
  paperFlag: boolean = false;
  questionFlag: boolean = false;
  addQuestionFlag: boolean = false;
  addFlag: boolean = false;
  enableEdit: boolean = false;
  enableEditIndex: number=null;
  testId: number;
  disabled: boolean=false;
  // editMode: boolean = false;


  // @ViewChild('f', {static: false}) slForm: NgForm;

  ngOnInit() {
    this.submitted = false;
    this.getSubjects();
    //this.getPapers();
    // this.getQuestions();
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

  getQuestions(testId: number) {
    if (testId > 0) {
      this.testId=testId;
      this.questionFlag = true;
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
  }

  addQuestionForm = new FormGroup({
    question: new FormControl(''),
    option_1: new FormControl(''),
    option_2: new FormControl(''),
    option_3: new FormControl(''),
    option_4: new FormControl(''),
    correct_answer: new FormControl(''),
  });

  saveQuestion(saveQuestion) {
    //this.addFlag=true;
    this.ques = new Question();
    this.ques.question = this.Question.value;
    this.ques.option_1 = this.Option_1.value;
    this.ques.option_2 = this.Option_2.value;
    this.ques.option_3 = this.Option_3.value;
    this.ques.option_4 = this.Option_4.value;
    this.ques.correct_answer = this.CorrectAnswer.value;
    // this.ques.question=this.addQuestionForm.get('question'); 
    // this.ques.option_1=this.addQuestionForm.get('option_1'); 
    this.submitted = true;
    this.save();
  }

  get Question() {
    return this.addQuestionForm.get('question');
  }
  get Option_1() {
    return this.addQuestionForm.get('option_1');
  }
  get Option_2() {
    return this.addQuestionForm.get('option_2');
  }
  get Option_3() {
    return this.addQuestionForm.get('option_3');
  }
  get Option_4() {
    return this.addQuestionForm.get('option_4');
  }
  get CorrectAnswer() {
    return this.addQuestionForm.get('correct_answer');
  }

  save() {
    this.testService.addQuestion(this.ques, this.testId).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
    this.ques = new Question();
  }

  saveQuestionForm() {
    this.addFlag = true;
    this.submitted = false;
    this.addQuestionForm.reset();
  }

  cancelQuestionForm() {
    this.addFlag = false;
  }

  ondeleteQuestion(questionId:number) { 
    this.testService.deleteQuestion(this.testId, questionId)
        .subscribe(
          data=>{
            console.log(data);
          },
          error=>{
            console.log(error);
          }
        );
  }

  enableEditMethod(i:number) {
    this.enableEdit = true;
    this.enableEditIndex = i;
    //console.log(i);
  }

  cancel() {
    console.log('cancel');
    this.enableEditIndex = null;
  }

  saveSegment(question:Question) {
     this.testService.updateQuestion(this.testId, question)
        .subscribe(
          data=>{
            console.log(data);
          },
          error=>{
            console.log(error);
          }
        );
        this.enableEditIndex = null;
  }

// getTestId(){
//   return this.testId;
// }

}
