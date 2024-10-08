package com.telusko.questionservice.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.questionservice.dao.QuestionDao;
import com.telusko.questionservice.model.Question;
import com.telusko.questionservice.model.QuestionWrapper;
import com.telusko.questionservice.model.Response;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	/*List<Question> questions=new ArrayList<>(List.of(
			new Question(1,
					"What is a class in Java?",
					"A function",
					"An object",
					"A data structure",
					"A loop",
					"An object",
					"Easy",
					"java")
			));*/
	
	//List<Question> questions=new ArrayList<>(List.of(new Question()));

	 public ResponseEntity<List<Question>> getAllQuestions() {
	        try {
	            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	    }

	    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
	        try {
	            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	    }

	    public ResponseEntity<String> addQuestion(Question question) {
	        questionDao.save(question);
	        return new ResponseEntity<>("success",HttpStatus.CREATED);
	    }

	    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
	        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
	        return new ResponseEntity<>(questions, HttpStatus.OK);
	    }

	    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
	        List<QuestionWrapper> wrappers = new ArrayList<>();
	        List<Question> questions = new ArrayList<>();

	        for(Integer id : questionIds){
	            questions.add(questionDao.findById(id).get());
	        }

	        for(Question question : questions){
	            QuestionWrapper wrapper = new QuestionWrapper();
	            wrapper.setId(question.getId());
	            wrapper.setQuestiontitle(question.getQuestiontitle());
	            wrapper.setOption1(question.getOption1());
	            wrapper.setOption2(question.getOption2());
	            wrapper.setOption3(question.getOption3());
	            wrapper.setOption4(question.getOption4());
	            wrappers.add(wrapper);
	        }

	        return new ResponseEntity<>(wrappers, HttpStatus.OK);
	    }

	    public ResponseEntity<Integer> getScore(List<Response> responses) {


	        int right = 0;

	        for(Response response : responses){
	            Question question = questionDao.findById(response.getId()).get();
	            if(response.getResponse().equals(question.getRightanswer()))
	                right++;
	        }
	        return new ResponseEntity<>(right, HttpStatus.OK);
	    }


		public ResponseEntity<Optional<Question>> getQuestionsById(int id) {
			// TODO Auto-generated method stub
			return new ResponseEntity<>(questionDao.findById(id),HttpStatus.OK);
		}

		public ResponseEntity<String> addQuesaddListOfQuestiontion(List<Question> questions) {
			// TODO Auto-generated method stub
			for(Question quest:questions) {
				if(quest !=null) {
					questionDao.save(quest);
				}
			}
	        return new ResponseEntity<>("Questions added successfully",HttpStatus.CREATED);
		}
}
