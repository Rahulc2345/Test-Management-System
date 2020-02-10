package com.app.demo.pojos;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javassist.CtPrimitiveType;

@Entity
public class TestPaper {

	private int testId;
	private String testName;
	@JsonBackReference
	private Subject subject;
	@JsonManagedReference
	private Set<Question> questions;
	public TestPaper() {
		super();
	}
	public TestPaper(int testId, String testName, Subject subject, Set<Question> questions) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.subject = subject;
		this.questions = questions;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="test_id")
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="subject_id")
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@OneToMany(mappedBy="paper", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question ques){
		questions.add(ques);
		ques.setPaper(this);
	}
	
	public void removeQuestion(Question ques){
		questions.remove(ques);
		ques.setPaper(null);
	}
	
	@Override
	public String toString() {
		return "TestPaper [testId=" + testId + ", testName=" + testName + ", subject=" + subject + ", questions="
				+ questions + "]";
	}
	
	
}
