package com.telusko.questionservice.model;

public class Response {
	private Integer id;
    private String response;
	public Integer getId() {
		return id;
	}
	public String getResponse() {
		return response;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
}
