package com.training.employeedemo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {
	final static Logger logger = LoggerFactory.getLogger(AspectConfig.class);

	@Before("execution(public * com.training.employeedemo.service.*.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint) {
		logger.info("{} Started :@Before Advice", joinPoint.getSignature().getName());
	}

	@Before("execution(public * com.training.employeedemo.controller.*.*(..))")
	public void logBeforeAllMethodsController(JoinPoint joinPoint) {
		logger.info("{} Started :@Before Advice for Controller", joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(public * com.training.employeedemo.controller.*.*(..))")
	public void logAfterReturningAllController(JoinPoint joinPoint) {
		logger.info("{} Ended :@After Returning Controller Advice", joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.training.employeedemo.service.*.*(..))")
	public void logAfterReturningAll(JoinPoint joinPoint) {
		logger.info("{} Ended :@After Returning Advice", joinPoint.getSignature().getName());
	}

	@After("execution(* com.training.employeedemo.service.*.*(..))")
	public void endAll(JoinPoint joinPoint) {
		logger.info("{} Finished :@After Advice", joinPoint.getSignature().getName());
	}

	@After("execution(public * com.training.employeedemo.controller.*.*(..))")
	public void endAllController(JoinPoint joinPoint) {
		logger.info("{} Finished :@After Controller Advice", joinPoint.getSignature().getName());

	}
}