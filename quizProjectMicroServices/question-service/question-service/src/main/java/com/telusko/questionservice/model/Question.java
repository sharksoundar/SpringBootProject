package com.telusko.questionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String questiontitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightanswer;
    private String difficultylevel;
    private String category;
	public Question() {
		super();
	}
	public Question(Integer id, String questiontitle, String option1, String option2, String option3, String option4,
			String rightanswer, String difficultylevel, String category) {
		super();
		this.id = id;
		this.questiontitle = questiontitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightanswer = rightanswer;
		this.difficultylevel = difficultylevel;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public String getQuestiontitle() {
		return questiontitle;
	}
	public String getOption1() {
		return option1;
	}
	public String getOption2() {
		return option2;
	}
	public String getOption3() {
		return option3;
	}
	public String getOption4() {
		return option4;
	}
	public String getRightanswer() {
		return rightanswer;
	}
	public String getDifficultylevel() {
		return difficultylevel;
	}
	public String getCategory() {
		return category;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setQuestiontitle(String questiontitle) {
		this.questiontitle = questiontitle;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public void setRightanswer(String rightanswer) {
		this.rightanswer = rightanswer;
	}
	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
