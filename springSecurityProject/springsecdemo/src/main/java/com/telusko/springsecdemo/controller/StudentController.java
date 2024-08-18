package com.telusko.springsecdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.telusko.springsecdemo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
	
	List<Student> students=new ArrayList<>(List.of(
			new Student(1,"Navin","Java"),
			new Student(2,"Kiran","Blockchain")
			));

	@GetMapping("csrf-token")
	public Object getMethodName(HttpServletRequest request) {
		return request.getAttribute("_csrf");
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return students;
	}
	@PostMapping("students")
	public void addStudent(@RequestBody Student student) {
		students.add(student);
	}
	

}
