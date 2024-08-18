package com.telusko.SpringBootWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringBootWeb.model.User;
import com.telusko.SpringBootWeb.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("register")
	public String register (@RequestBody User user) {
		//TODO: process POST request
		userService.register(user);
		
		return "User created";
	}
	
	
}
