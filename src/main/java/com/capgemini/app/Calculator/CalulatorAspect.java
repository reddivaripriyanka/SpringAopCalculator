package com.capgemini.app.Calculator;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalulatorAspect {
	Logger logger = Logger.getLogger(CalulatorAspect.class.getName());

	@Before("execution(* com.capgemini.app..*(..))")
	public void logOne() {
		logger.info("login Before");
	}

	@After("execution(* com.capgemini.app..*(..))")
	public void logTwo() {
		logger.info("login After");
	}

	@Around("execution(* com.capgemini.app..*(..))")
	public int logThree(ProceedingJoinPoint pjp) throws Throwable {
		int retVal=0;
		logger.info("Before-logging the method");
		logger.info("Function name is:" + pjp.getSignature());
		logger.info("parameters are:");
		Object[] param = pjp.getArgs();
		for (int i = 0; i < param.length; i++) {
			logger.info("parameter value at index " + i + "is " + param[i]);

		}
		if(((Integer)param[0])==0 || ((Integer)param[1])==0)
		{
			logger.info("We could not add");
		}
		else
		{
		retVal=(int) pjp.proceed();
		logger.info("After-logging the method");

		}
		return retVal;
		
	}

	@AfterReturning(pointcut = "execution(* com.capgemini.app..*(..))", returning = "retVal")
	public void logFour(Integer retVal) {
		logger.info("SUCCESS" + retVal);
	}

}
