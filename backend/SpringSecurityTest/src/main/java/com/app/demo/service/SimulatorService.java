package com.app.demo.service;

import java.util.Set;

import com.app.demo.pojos.Question;
import com.app.demo.pojos.TestPaper;



public interface SimulatorService {

	Set<Question> getQuestions(int testId);
	String addQuestion(Question question, int testId);
	String editQuestion(int testId, Question question);
	String deleteQuestion(int testId, int questionId);
	Question getQuestionById(int questionId);
	TestPaper getPaperById(int testId);
	
}
