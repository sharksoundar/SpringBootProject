package com.telusko.springsecdemo.model;

public class Student {
	
	private int id;
	private String name;
	private String tech;
	public Student() {
		super();
	}
	public Student(int id, String name, String tech) {
		super();
		this.id = id;
		this.name = name;
		this.tech = tech;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTech() {
		return tech;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}

}
