package com.telusko.SpringBootWeb.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class JobPost {

	@Id
	private int postId;
	private String postProfile;
	private String postDesc;
	private Integer reqExperience;
	private List<String> postTechStack;
	public JobPost() {
		super();
	}
	public JobPost(int postId, String postProfile, String postDesc, int reqExperience, List<String> postTechStack) {
		super();
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}
	public int getPostId() {
		return postId;
	}
	public String getPostProfile() {
		return postProfile;
	}
	public String getPostDesc() {
		return postDesc;
	}

	public List<String> getPostTechStack() {
		return postTechStack;
	}
	public Integer getReqExperience() {
		return reqExperience;
	}
	public void setReqExperience(Integer reqExperience) {
		this.reqExperience = reqExperience;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}

	
}
