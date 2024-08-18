package com.telusko.SpringBootWeb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	public  static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution (* com.telusko.SpringBootWeb.service.JobService.*(..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method Called :"+jp.getSignature().getName());
	}
	
	@After("execution (* com.telusko.SpringBootWeb.service.JobService.*(..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method Executed :"+jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.telusko.SpringBootWeb.service.JobService.*(..))")
	public void LogMethodCrashed(JoinPoint jp) {
		LOGGER.info("Method having some issue :"+jp.getSignature().getName());
		
	}
	@AfterReturning("execution(* com.telusko.SpringBootWeb.service.JobService.*(..))")
	public void LogMethodExecutedSuccess(JoinPoint jp) {
		LOGGER.info("Method Executed Successfully :"+jp.getSignature().getName());
		
	}
	
}
