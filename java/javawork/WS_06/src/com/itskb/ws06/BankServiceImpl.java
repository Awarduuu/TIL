package com.itskb.ws06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//고객과 계좌에 관련된 서비스
//(Business Logic을 처리하는 객체)
public class BankServiceImpl implements BankService{
	//고정값은 final -> 값변경 불가(초기화 필수)
	final int ACCOUNT_SIZE= 10 ; // 최대 계좌 개수 
	final int USER_SIZE= 5; // 최대 고객 개수
	
	// 동그라미는 public 그냥은 세모?
	int ACCOUNT_CURRENT_SIZE; //현재 계좌 개수
	int USER_CURRENT_SIZE; // 현재 고객 수
	
	List<AccountDto> accountList;
	List<UserDto> userList;
	
	public BankServiceImpl() {
		//배열 생성
		userList=new ArrayList<UserDto>(USER_SIZE); //5
		accountList=new ArrayList<AccountDto>(ACCOUNT_SIZE); //10
		//각배열방에 고객과 계좌를 생성한다.
		//고객 4명
		insertUser(new UserDto(100,"장희정","8253jang@daum.net","010-8875-8253",false));
		insertUser(new UserDto(200,"이효리","lee@daum.net","010-6583-5714",false));
		insertUser(new UserDto(300,"송중기","song@naver.com","010-5554-1853",false));
		insertUser(new UserDto(400,"삼순이","sam@naver.com","010-2222-2222",false));
		
		//계좌는 6개 정도
		insertAccount(new AccountDto(1,"1111-11111", 1000000, 100));
		insertAccount(new InstallAccountDto(2, "2222-22222", 2500000, 100, 50, 100000));
		insertAccount(new LoanAccountDto(3, "3333-33333", 350000, 100, "서울 논현"));
		insertAccount(new SavingAccountDto(4,"4444-44444", 150000, 200, 500000));
		insertAccount(new AccountDto(5,"5555-55555", 750000, 200));
		insertAccount(new AccountDto(6,"6666-66666", 500000, 300));
		
		ACCOUNT_CURRENT_SIZE = accountList.size();
		USER_CURRENT_SIZE = userList.size();
		
	}// 생성자 끝
	
	@Override
	//특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다.
	public List<AccountDto> getAccountList(int userSeq) {
		List<AccountDto> searchAccountDtoList= new ArrayList<AccountDto>();
		for (int i=0;i<ACCOUNT_CURRENT_SIZE;i++) {
			if(accountList.get(i).getUserSeq()==userSeq) {
				//찾았다
				searchAccountDtoList.add(accountList.get(i));
			}
		}
		return searchAccountDtoList;
	}
	
	public void insertUser(UserDto user) {
		userList.add(user);
	}
	
	public void insertAccount(AccountDto account) {
		accountList.add(account);
	}
	
	@Override
	// 특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다.
	/** @param : 고객의 sequence
	 @return : null이면 고객의 정보 없다.**/
	public UserDto getUserDetail(int userSeq) {
		for(int i=0;i<USER_CURRENT_SIZE; i++) {
			if(userList.get(i).userSeq==userSeq) {
				return userList.get(i);
			}
		}
		return null;
	}
	
	@Override
	public List<AccountDto> getAccountList(){
		return this.accountList;
	}
	
	@Override
	public List<AccountDto> getAccountListByBalance(){
		List<AccountDto> accountListByBalance = new ArrayList<AccountDto>();
		
		for(AccountDto acc : accountList) {
			accountListByBalance.add(acc);
		}
		
		Collections.sort(accountListByBalance, (o1, o2) -> (o1.getBalance() - o2.getBalance()));
		
		return accountListByBalance;
	}
	
	@Override
	public List<AccountDto> getAccountListByUserSeq(){
		List<AccountDto> accountListByUserSeq = new ArrayList<AccountDto>();
		for(AccountDto acc : accountList) {
			accountListByUserSeq.add(acc);
		}
		
		Collections.sort(accountListByUserSeq, new Comparator<AccountDto>() {

			@Override
			public int compare(AccountDto o1, AccountDto o2) {
				// TODO Auto-generated method stub
				return o1.getUserSeq() - o2.getUserSeq();
			}
			
		});
		
		return accountListByUserSeq;
	}

	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq)
	throws UserAccountNotFoundException{
		
		for(AccountDto a : accountList) {
			if(a.getUserSeq() == userSeq && a.getAccountSeq() == accountSeq) {
				return a;
			}
		}
		
		throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다.");
	}

	@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
	throws BalanceLackException, UserAccountNotFoundException{
		
		AccountDto a = getUserAccount(userSeq, accountSeq);
		
		if(a.getBalance() < amount) throw new BalanceLackException("잔액이 부족합니다.");
		
		a.setBalance(a.getBalance() - amount);
		return amount;
	}
}