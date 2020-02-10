package com.app.demo.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Subject;
import com.app.demo.pojos.TestPaper;


@Repository
public class SubjectDaoImpl implements SubjectDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static Subject subject;
	
	@Override
	public Set<TestPaper> getTestPaperList(int subjectId) {
		String jpql="select t from TestPaper t where t.subject.subjectId=:subjectId";
		Collection<TestPaper> testCollection=sessionFactory.getCurrentSession().createQuery(jpql)
								.setParameter("subjectId", subjectId).list();
		
		Set<TestPaper> paperSet=new HashSet<>(testCollection);
		return paperSet;
	}

	@Override
	public TestPaper getPaperById(int testId) {
		return (TestPaper) sessionFactory.getCurrentSession().load(TestPaper.class, testId);
	}

	

	@Override
	public Subject getSubjectById(int subjectId) {
		return (Subject) sessionFactory.getCurrentSession().load(Subject.class, subjectId);
	}

	@Override
	public String savePaper(int subjectId, TestPaper paper) {
		subject=getSubjectById(subjectId);
		subject.addTestPaper(paper);
		sessionFactory.getCurrentSession().save(paper);
		return "Test Paper with Id " + paper.getTestId() + " is Saved";
	}

	@Override
	public String updatePaper(int subjectId, TestPaper paper) {
		subject=getSubjectById(subjectId);
		sessionFactory.getCurrentSession().update(paper);
		subject.addTestPaper(paper);
		return "Test Paper with Id " + paper.getTestId()+ " has been updated";
	}

	@Override
	public String deletePaper(int subjectId, int testId) {
		subject=getSubjectById(subjectId);
		TestPaper paper=getPaperById(testId);
		subject.removeTestPaper(paper);
		sessionFactory.getCurrentSession().delete(paper);
		return "Test Paper with Id " + paper.getTestId()+ " has been deleted";
	}

	@Override
	public Set<Subject> getAllSubjects() {
		Collection<Subject> subjectCollection = sessionFactory.getCurrentSession().createQuery("select s from Subject s").list();
		Set<Subject> subjectSet=new HashSet<>(subjectCollection);
		return subjectSet;
	}
	
	

}
