package com.telusko.SpringBootWeb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.SpringBootWeb.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String PostProfile,String PostDesc);
	
}
