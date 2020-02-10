import { TestPaper } from './test-paper';

export class Question {
	public  question_id:number;
	public  question:string;
	public  option_1:string;
	public  option_2:string;
	public  option_3:string;
	public  option_4:string;
	public  correct_answer:string;
	public  paper:TestPaper;

	// Constructor(question_id:number, question:string, option_1:string, option_2:string, option_3:string, 
	// 						option_4:string, correct_answer:string, TestPaper:TestPaper)
	// {
	// 	this.question_id=question_id;
	// 	this.question=question;
	// 	this.option_1=option_1;
	// 	this.option_2=option_2;
	// 	this.option_3=option_3;
	// 	this.option_4=option_4;
	// 	this.correct_answer=correct_answer;
	// }
}
