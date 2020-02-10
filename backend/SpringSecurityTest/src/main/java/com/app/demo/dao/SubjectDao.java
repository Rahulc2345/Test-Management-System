package com.app.demo.dao;

import java.util.Set;

import com.app.demo.pojos.Subject;
import com.app.demo.pojos.TestPaper;



public interface SubjectDao {

	Set<TestPaper> getTestPaperList(int subjectId);
	TestPaper getPaperById(int testId);
	String savePaper(int subjectId, TestPaper paper);
	String updatePaper(int subjectId, TestPaper paper);
	String deletePaper(int subjectId, int testId);
	Subject getSubjectById(int subjectId);
	Set<Subject> getAllSubjects();
}
