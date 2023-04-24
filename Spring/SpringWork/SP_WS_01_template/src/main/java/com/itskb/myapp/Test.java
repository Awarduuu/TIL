package com.itskb.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itskb.myapp.calculator.InterestCalculatorService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/itskb/myapp/interest-calculator.xml");

		InterestCalculatorService interestCalculatorService =context.getBean("interestCalculatorService", InterestCalculatorService.class);
		int amount = 100_000_000;
		double loanInterest = interestCalculatorService.calculateLoanInterest(amount);
		System.out.printf("Amount : %10d loanInterest is %.2f", amount, loanInterest);
		
		System.out.println("\n-------------------------------- ");
		
		double savingInterest = interestCalculatorService.calculateSavingInterest(amount);
		System.out.printf("Amount : %10d savingInterest is %.2f", amount, savingInterest);
		
		
	}

}
