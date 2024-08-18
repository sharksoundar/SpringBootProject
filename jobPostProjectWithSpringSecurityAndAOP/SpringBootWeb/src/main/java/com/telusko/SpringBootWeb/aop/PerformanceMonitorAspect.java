package com.telusko.SpringBootWeb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

	public static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	
	
	@Around("execution(* com.telusko.SpringBootWeb.service.JobService.*(..))")
	public Object monitorTime(ProceedingJoinPoint jp) {
		LOGGER.info("Method Executed Successfully :"+jp.getSignature().getName());
		
		long start=System.currentTimeMillis();
		Object obj = null;
		try {
			obj = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end =System.currentTimeMillis();
		
		LOGGER.info("Time taken by :"+jp.getSignature().getName()+" "+(start-end)+" ms");
		
		return obj;
		
	}
	
}
