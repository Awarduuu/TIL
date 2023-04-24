package com.itskb.myapp.calculator;


public class InterestCalculatorService {
	
	InterestCalculator loanCalcator;
	InterestCalculator savingCalcator;
	
	public InterestCalculatorService(InterestCalculator loanCalcator) { //생성자를 이용한 주입 
		this.loanCalcator=loanCalcator;
	}
	
	public void setSavingCalcator(InterestCalculator savingCalcator) { //setter를 이용한 주입 
		this.savingCalcator = savingCalcator;
	}
	
	
	public double calculateLoanInterest(int amount) {
		return loanCalcator.calculate(amount);
	}
	
	public double calculateSavingInterest(int amount) {
		return savingCalcator.calculate(amount);
	}
}
