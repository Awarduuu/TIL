package com.itskb.ws06;

public class TestView {
	
	BankService service;
	
	public TestView (){
		service= new BankServiceImpl();
//		System.out.println("\n--------- 전체 계좌 조회 ----------");
//		System.out.println(service.getAccountList());
//		System.out.println("\n--------- 유저번호 100의 계좌 조회 ----------");
//		System.out.println(service.getAccountList(100));
//		System.out.println("\n--------- 잔고 기준 정렬된 계좌 조회 ----------");
//		System.out.println(service.getAccountListByBalance());
//		System.out.println("\n--------- 유저번호 기준 정렬된 계좌 조회 ----------");
//		System.out.println(service.getAccountListByUserSeq());
		
		try {
			service.getUserAccount(500, 1);
			
		}catch(UserAccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			service.withdraw(200, 5, 75000000);
		}catch(UserAccountNotFoundException | BalanceLackException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new TestView();
		
	}

}//메인 끝
