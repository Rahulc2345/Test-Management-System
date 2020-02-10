package com.app.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Question;
import com.app.demo.pojos.Subject;
import com.app.demo.pojos.TestPaper;
import com.app.demo.service.SimulatorService;
import com.app.demo.service.SubjectService;


@CrossOrigin(value="http://localhost:4200")
@RestController
public class SimulationController {

	@Autowired
	SimulatorService service;
	
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("/test/{testId}")
	public Set<Question> getQuestion(@PathVariable int testId){
		return service.getQuestions(testId);
	}
	
	@PostMapping("/test/{testId}/question/addQuestion")
	public String addQuestion(@RequestBody Question question, @PathVariable int testId){
		return service.addQuestion(question, testId);
	}
	
	@PutMapping("/test/{testId}/question/{questionId}")
	public String editdQuestion(@PathVariable int testId, @PathVariable int questionId, @RequestBody Question question){
		question.setQuestion_id(questionId);
		return service.editQuestion(testId, question);
	}
	
	@DeleteMapping("/test/{testId}/question/{questionId}")
	public String deleteQuestion(@PathVariable int testId, @PathVariable int questionId){
		return service.deleteQuestion(testId, questionId);
	}
	
	//------------------------------------------------------------------------------------------
	
	@GetMapping("/subject")
	public Set<Subject> getAllSubject(){
		return subjectService.getAllSubjects();
	}
	
	@GetMapping("/subject/{subjectId}")
	public Set<TestPaper> getTestPapers(@PathVariable int subjectId){
		return subjectService.getTestPaperList(subjectId);
	}
	
	@PostMapping("/subject/{subjectId}/test/addPaper")
	public String addPaper(@PathVariable int subjectId,@RequestBody TestPaper paper){
		return subjectService.savePaper(subjectId, paper);
	}
	
	@PutMapping("/subject/{subjectId}/test/{testId}")
	public String editPaper(@PathVariable int subjectId,@PathVariable int testId,@RequestBody TestPaper paper){
		paper.setTestId(testId);
		return subjectService.updatePaper(subjectId, paper);
	}
	
	@DeleteMapping("/subject/{subjectId}/test/{testId}")
	public String deletePaper(@PathVariable int subjectId, @PathVariable int testId){
		return subjectService.deletePaper(subjectId, testId);
	}
}
