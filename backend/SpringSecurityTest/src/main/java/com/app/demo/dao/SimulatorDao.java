package com.app.demo.dao;

import java.util.Set;

import com.app.demo.pojos.Question;
import com.app.demo.pojos.TestPaper;

public interface SimulatorDao{
	Set<Question> getQuestions(int testId);
	String addQuestion(Question question, TestPaper paper);
	String editQuestion(TestPaper paper, Question question);
	String deleteQuestion(TestPaper paper, int questionId);
	Question getQuestionById(int questionId);
	}
