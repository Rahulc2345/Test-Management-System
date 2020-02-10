package com.app.demo.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Question")
public class Question {

	private int question_id;
	private String question;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String correct_answer;
	@JsonBackReference
	private TestPaper paper;
	public Question() {
		System.out.println("in ques def");
	}
	public Question(int question_id, String question, String option_1, String option_2, String option_3, String option_4,
			String correct_answer, TestPaper paper) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.correct_answer = correct_answer;
		this.paper = paper;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="test_id")
	public TestPaper getPaper() {
		return paper;
	}
	public void setPaper(TestPaper paper) {
		this.paper = paper;
	}
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", option_1=" + option_1
				+ ", option_2=" + option_2 + ", option_3=" + option_3 + ", option_4=" + option_4 + ", correct_answer="
				+ correct_answer + "]";
	}
	
	
	
	
}
