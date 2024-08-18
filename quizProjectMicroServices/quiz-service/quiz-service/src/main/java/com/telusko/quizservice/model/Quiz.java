package com.telusko.quizservice.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ElementCollection
	private List<Integer> questionIds;

	public Quiz() {
		super();
	}

	public Quiz(Integer id, String title, List<Integer> questionIds) {
		super();
		this.id = id;
		this.title = title;
		this.questionIds = questionIds;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

}
