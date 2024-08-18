package com.telusko.SpringBootWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.telusko.SpringBootWeb.model.JobPost;
import com.telusko.SpringBootWeb.service.JobService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRestController {
	
	@Autowired
	private JobService service;

	
	@GetMapping("greet")
	public String greet() {
		return "Welcome to job portal";
	}
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> getJobByKeyword(@PathVariable String keyword) {
		return service.getJobByKeyword(keyword);
	}
	
	@GetMapping("/jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJob(postId);
	}

   @PostMapping("jobPost")
   public String addJob(@RequestBody JobPost job) {
		
		service.addJob(job);
		
		return "Added";
	}
   
   @PutMapping("jobPost")
   public JobPost updateJob(@RequestBody JobPost jobPost) {
	   
	   service.updateJob(jobPost);
	   
	return service.getJob(jobPost.getPostId());
	   
   }
   
   @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
	   
	   service.deleteJob(postId);
	   
	return "Deleted";
	   
   }
   @GetMapping("loadData")
	public String loadData() {
		 service.loadData();
		 return "Success";
	}
   

}
