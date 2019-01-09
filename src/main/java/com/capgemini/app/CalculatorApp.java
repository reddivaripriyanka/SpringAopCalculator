package com.capgemini.app;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.capgemini.app.Calculator.CalulatorAspect;

@Service
public class CalculatorApp {
	public Integer add(int num1,int num2)
	{
		Logger logger=Logger.getLogger(CalulatorAspect.class.getName());
		int sum=num1+num2;
		logger.info(""+sum);
		return sum;
	}
}



