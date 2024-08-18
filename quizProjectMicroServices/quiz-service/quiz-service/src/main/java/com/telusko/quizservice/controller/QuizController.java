package com.telusko.quizservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quizservice.model.QuestionWrapper;
import com.telusko.quizservice.model.QuizDto;
import com.telusko.quizservice.model.Response;
import com.telusko.quizservice.service.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@GetMapping("greet")
	public String greet() {
		// TODO Auto-generated method stub
		return quizService.greet();
	}
	
@PostMapping("create")
public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
    //TODO: process POST request
    
    return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
}

@PostMapping("get/{id}")
public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
    return quizService.getQuizQuestions(id);
}

@PostMapping("submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id ,@RequestBody List<Response> responses) {
    //TODO: process POST request
     return quizService.submitQuiz(id,responses);
}
        
}

