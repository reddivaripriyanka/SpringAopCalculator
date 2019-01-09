package com.capgemini.app.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.app.CalculatorApp;
public class CalculatorServie {
		public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
		CalculatorApp calculator=context.getBean(CalculatorApp.class);
		calculator.add(100,200);
	}
}
