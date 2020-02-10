package com.app.demo.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Question;
import com.app.demo.pojos.TestPaper;



@Repository
public class SimulatorDaoImpl implements SimulatorDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public Set<Question> getQuestions(int testId) {
		String jpql="select q from Question q where q.paper.testId=:testId";
		
		 Collection<Question> ques =sf.getCurrentSession().createQuery(jpql).setParameter("testId", testId).list();
		 Set<Question> quesSet=new HashSet<>(ques);
		return quesSet;
	}

	@Override
	public String addQuestion(Question question, TestPaper paper) {
		paper.addQuestion(question);
		sf.getCurrentSession().save(question);
		return "Question Saved";
	}

	@Override
	public String editQuestion(TestPaper paper, Question question) {
		
		/*question.setCorrect_answer(question.getCorrect_answer());
		question.setOption_1(question.getOption_1());
		question.setOption_2(question.getOption_2());
		question.setOption_3(question.getOption_3());
		question.setOption_4(question.getOption_4());
		question.setQuestion(question.getQuestion());
		question.setQuestion_id(question.getQuestion_id());*/
		
		
		sf.getCurrentSession().update(question);
		paper.addQuestion(question);
		//sf.getCurrentSession().merge(question);
		
		return "Question Updated";
	}
	
	public Question getQuestionById(int questionId){
		return (Question) sf.getCurrentSession().get(Question.class, questionId);
	}

	@Override
	public String deleteQuestion(TestPaper paper, int questionId) {
		Question question=getQuestionById(questionId);
		paper.removeQuestion(question);
		sf.getCurrentSession().delete(question);
		return "Question deleted";
	}

}
