package com.itskb.ws06;

import java.util.List;

public interface BankService {
	/**
	 * 특정 유저의 계좌 목록을 조회하는 메소드
	 * @param 조회할 유저번호(userSeq)
	 * @return 조회된 유저의 계좌 목록 리스트 */
	List<AccountDto> getAccountList(int userSeq);
	
	/**
	 * 특정 유저의 정보를 조회하는 메소드
	 * @param userSeq 유저 일련번호
	 * @return 조회된 유저 객체 */
	UserDto getUserDetail(int userSeq);
	
	/**
	 * 전쳬 계좌 목록을 조회하는 메소드
	 * @return 전체 계좌 목록 리스트 */
	List<AccountDto> getAccountList();
	
	/**
	 * 전체 계좌 목록을 잔고(balance) 기준으로 오름차순 정렬하는 메소드
	 * @return balance기준 오름차순 정렬된 계좌 목록 리스트 */
	List<AccountDto> getAccountListByBalance();
	
	/**
	 * 전체 계좌 목록을 유저번호(userSeq) 기준으로 오름차순 정렬하는 메소드
	 * @return userSeq기준 오름차순 정렬된 계좌 목록 리스트 */
	List<AccountDto> getAccountListByUserSeq();
	
	/**
	 * @param userSeq 유저 일련번호
	 * @param accountSeq 계좌 일련번호
	 * @return 조회된 유저의 AccountDto
	 */
	AccountDto getUserAccount (int userSeq, int accountSeq) 
	throws UserAccountNotFoundException;
	/**
	 * 
	 * @param userSeq 유저 일련번호
	 * @param accountSeq 계좌 일련번호
	 * @param amount 출금 금액
	 * @return 실패하면 0, 성공하면 amount
	 */
	int withdraw(int userSeq, int accountSeq, int amount)
	throws BalanceLackException, UserAccountNotFoundException;
	
}
