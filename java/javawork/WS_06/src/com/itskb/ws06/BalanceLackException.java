package com.itskb.ws06;

public class BalanceLackException extends Exception {

	/**
	 * 잔액 부족일 때 발생하는 예외
	 */
	private static final long serialVersionUID = 1L;
	
	public BalanceLackException() {
		super("잔액이 부족합니다.");
	}
	public BalanceLackException(String message){
		super(message);
	}
}
