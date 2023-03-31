package com.itskb.ws03;

import com.itskb.ws03.AccountDto;
import com.itskb.ws03.UserDto;

//고객과 계좌에 관련된 서비스
//(Business Logic을 처리하는 객체)
public class BankService {
	//고정값은 final -> 값변경 불가(초기화 필수)
	final int ACCOUNT_SIZE= 10 ; // 최대 계좌 개수 
	final int USER_SIZE= 5; // 최대 고객 개수
	
	// 동그라미는 public 그냥은 세모?
	int ACCOUNT_CURRENT_SIZE; //현재 계좌 개수
	int USER_CURRENT_SIZE; // 현재 고객 수
	
	AccountDto [] accountList;
	UserDto [] userList;
	
	public BankService() {
		//배열 생성
		userList=new UserDto[USER_SIZE]; //5
		accountList=new AccountDto[ACCOUNT_SIZE]; //10
		//각배열방에 고객과 계좌를 생성한다.
		//고객 3명
		userList[USER_CURRENT_SIZE++]=new UserDto(100,"장희정","8253jang@daum.net","010-8875-8253",false);
		userList[USER_CURRENT_SIZE++]=new UserDto(200,"이효리","lee@daum.net","010-6583-5714",false);
		userList[USER_CURRENT_SIZE++]=new UserDto(300,"송중기","song@naver.com","010-5554-1853",false);
		userList[USER_CURRENT_SIZE++]=new UserDto(400,"삼순이","sam@naver.com","010-2222-2222",false);
		
		//계좌는 6개 정도
		accountList[ACCOUNT_CURRENT_SIZE++]= new AccountDto(1,"1111-11111", 1000000, 100);
		accountList[ACCOUNT_CURRENT_SIZE++]= new AccountDto(2,"2222-22222", 2500000, 100);
		accountList[ACCOUNT_CURRENT_SIZE++]= new AccountDto(3,"3333-33333", 350000, 100);
		
		accountList[ACCOUNT_CURRENT_SIZE++]= new AccountDto(4,"4444-44444", 150000, 200);
		accountList[ACCOUNT_CURRENT_SIZE++]= new AccountDto(5,"5555-55555", 750000, 200);

		accountList[ACCOUNT_CURRENT_SIZE++]= new AccountDto(6,"6666-66666", 500000, 300);
		
		
	}// 생성자 끝

	//특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다.
	public AccountDto[] getAccountList(int userSeq) {
		int searchAccountCount=0;
		for (int i=0;i<ACCOUNT_CURRENT_SIZE;i++) {
			if(accountList[i].userSeq==userSeq) {
				//찾았다
				searchAccountCount++;
			}
		}
		// 위에서 찾은 정보를 바탕으로 AccountDto배열에서 계좌정보를 찾아서 리턴해준다.
		//찾은 고객의 계좌의 수만큼 배열을 생성해서 그 배열을 리턴
		if(searchAccountCount==0) {
			return null;
		}
		
		AccountDto [] searchAccountDtoList=new AccountDto [searchAccountCount];
		int count=0;
		for (int i=0;i<ACCOUNT_CURRENT_SIZE;i++) {
			if(accountList[i].userSeq==userSeq) {
				searchAccountDtoList[count++]=accountList[i];
			}
		}
		return searchAccountDtoList;
		
	}
	// 특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다.
	/** @param : 고객의 sequence
	 @return : null이면 고객의 정보 없다.**/
	public UserDto getUserDetail(int userSeq) {
		for(int i=0;i<USER_CURRENT_SIZE; i++) {
			if(userList[i].userSeq==userSeq) {
				return userList[i];
			}
		}
		return null;
	}
}