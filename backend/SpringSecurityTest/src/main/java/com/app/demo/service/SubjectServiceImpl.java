package com.app.demo.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dao.SubjectDao;
import com.app.demo.pojos.Subject;
import com.app.demo.pojos.TestPaper;

@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public Set<TestPaper> getTestPaperList(int subjectId) {
		return subjectDao.getTestPaperList(subjectId);
	}

	@Override
	public String savePaper(int subjectId, TestPaper paper) {
		return subjectDao.savePaper(subjectId, paper);
	}

	@Override
	public String updatePaper(int subjectId, TestPaper paper) {
		return subjectDao.updatePaper(subjectId, paper);
	}

	@Override
	public String deletePaper(int subjectId, int testId) {
		return subjectDao.deletePaper(subjectId, testId);
	}

	@Override
	public TestPaper getPaperById(int testId) {
		return subjectDao.getPaperById(testId);
	}

	@Override
	public Set<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

	/*@Override
	public Subject getSubjectById(int subjectId) {
		return subjectDao.getSubjectById(subjectId);
	}*/

}
