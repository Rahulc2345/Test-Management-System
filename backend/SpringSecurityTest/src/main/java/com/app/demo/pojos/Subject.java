package com.app.demo.pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subject {

	private int subjectId;
	private String subjectName;
	@JsonManagedReference
	private Set<TestPaper> testPaper;
	
	public Subject() {
		super();
	}
	
	public Subject(int subjectId, String subjectName, Set<TestPaper> testPaper) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.testPaper = testPaper;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_id")
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@OneToMany(mappedBy="subject", fetch=FetchType.EAGER)
	public Set<TestPaper> getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(Set<TestPaper> testPaper) {
		this.testPaper = testPaper;
	}
	
	public void addTestPaper(TestPaper paper){
		testPaper.add(paper);
		paper.setSubject(this);
	}
	
	public void removeTestPaper(TestPaper paper){
		testPaper.remove(paper);
		paper.setSubject(null);
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName +"]";
	}

	
}
