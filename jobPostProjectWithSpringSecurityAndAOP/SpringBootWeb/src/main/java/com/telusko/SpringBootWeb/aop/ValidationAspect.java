package com.telusko.SpringBootWeb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(ValidationAspect.class);

	@Around("execution(* com.telusko.SpringBootWeb.service.JobService.getJob(..)) && args(postId)")
	public Object validationAndUpdate(ProceedingJoinPoint jp, int postId) {
		
		LOGGER.info("PostId :"+postId);
		Object obj = null;
		try {
			 obj=jp.proceed(new Object[] {postId});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		}
}
