package com.app.demo.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dao.SimulatorDao;
import com.app.demo.dao.SubjectDao;
import com.app.demo.pojos.Question;
import com.app.demo.pojos.TestPaper;




@Service
@Transactional
public class SimulatorServiceImpl implements SimulatorService {

	@Autowired
	SimulatorDao dao;
	
	@Autowired
	SubjectDao subjectDao;
	
	static TestPaper paper=null;
	
	@Override
	public Set<Question> getQuestions(int testId) {
		return dao.getQuestions(testId);
	}

	@Override
	public String addQuestion(Question question, int testId) {
		 paper=getPaperById(testId);
		return dao.addQuestion(question, paper);
	}

	@Override
	public String editQuestion(int testId, Question question) {
		paper=getPaperById(testId);
		return dao.editQuestion(paper, question);
	}

	@Override
	public String deleteQuestion(int testId, int questionId) {
		paper=getPaperById(testId);
		return dao.deleteQuestion(paper, questionId);
	}

	@Override
	public Question getQuestionById(int questionId) {
		return dao.getQuestionById(questionId);
	}
	@Override
	public TestPaper getPaperById(int testId) {
		return subjectDao.getPaperById(testId);
	}
}
