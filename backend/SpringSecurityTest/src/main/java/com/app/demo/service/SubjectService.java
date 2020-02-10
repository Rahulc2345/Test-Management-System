package com.app.demo.service;

import java.util.Set;

import com.app.demo.pojos.Subject;
import com.app.demo.pojos.TestPaper;


public interface SubjectService {

	Set<TestPaper> getTestPaperList(int subjectId);
	String savePaper(int subjectId, TestPaper paper);
	String updatePaper(int subjectId, TestPaper paper);
	String deletePaper(int subjectId, int testId);
	//Subject getSubjectById(int subjectId);
	TestPaper getPaperById(int testId);
	Set<Subject> getAllSubjects();
}
