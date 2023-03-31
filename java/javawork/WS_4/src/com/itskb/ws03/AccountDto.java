package com.itskb.ws03;

public class AccountDto {
	public int accountSeq;
	public String accountNumber;
	public int balance;
	public int userSeq;
	
	public AccountDto() {}
	public AccountDto(int accountSeq,
					 String accountNumber,
					 int balance,
					 int userSeq) {
		
		this.accountSeq=accountSeq;
		this.accountNumber=accountNumber;
		this.balance=balance;
		this.userSeq=userSeq;
	}
}

