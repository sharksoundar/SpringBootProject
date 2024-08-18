package com.telusko.quizservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizservice.dao.QuizDao;
import com.telusko.quizservice.fein.QuizInterface;
import com.telusko.quizservice.model.QuestionWrapper;
import com.telusko.quizservice.model.Quiz;
import com.telusko.quizservice.model.Response;


@Service
public class QuizService {

	@Autowired
    QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	
	public String greet() {
		// TODO Auto-generated method stub
		return "Welcome to quiz module";
	}

	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		// TODO Auto-generated method stub
		List<Integer> questions= quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		
		Quiz quiz= new Quiz();
		
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Quiz created",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub\	
		Quiz quiz=quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		
		ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);
		
		return questions;
	}

	public ResponseEntity<Integer> submitQuiz(int id, List<Response> responses) {
		// TODO Auto-generated method stub

		ResponseEntity<Integer> right=quizInterface.getScore(responses);
		
		return right;
	}
	
	

}
