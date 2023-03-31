package com.itskb.ws04;
import java.util.List;

import com.itskb.ws04.AccountDto;


public class TestView {

	public static void main(String[] args) {
//		System.out.println("***1. 고객seq에 해당하는 계좌정보 검색하기 ***");
		BankService service= new BankService();

		List<AccountDto> accountList = service.getAccountList();
		System.out.println(accountList);
		System.out.println(service.getAccountList(100));
		System.out.println(service.getAccountListByBalance(accountList));
		System.out.println(service.getAccountListByUserSeq(accountList));
		
	}

}//메인 끝
