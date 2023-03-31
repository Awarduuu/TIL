package com.itskb.ws06;

public class UserAccountNotFoundException extends Exception {

	/**
	 * 고객의 일련번호와 계좌의 일련번호가 일치하는 대상이 없을 때 발생하는 예외
	 */
	private static final long serialVersionUID = 1L;

	public UserAccountNotFoundException() {
		super("사용자 또는 계좌를 찾을 수 없습니다.");
	}
	
	public UserAccountNotFoundException(String message) {
		super(message);
	}
}
