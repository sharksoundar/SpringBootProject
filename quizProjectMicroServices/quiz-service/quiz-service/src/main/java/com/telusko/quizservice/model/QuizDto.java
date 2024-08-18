package com.telusko.quizservice.model;

public class QuizDto {
	private String categoryName;
    private Integer numQuestions;
    private String title;

	public QuizDto() {
		super();
	}
	public QuizDto(String categoryName, Integer numQuestions, String title) {
		super();
		this.categoryName = categoryName;
		this.numQuestions = numQuestions;
		this.title = title;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
