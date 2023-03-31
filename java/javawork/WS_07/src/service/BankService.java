package service;

import java.util.ArrayList;

import dto.AccountDto;
import dto.UserDto;
import exception.BalanceLackException;
import exception.UserAccountNotFoundException;

// WS_06 대비
// - getUserAccount, withdraw
public interface BankService {

	ArrayList<AccountDto> getAccountList(int userSeq );	
	UserDto getUserDetail(int userSeq);
	ArrayList<AccountDto> getAccountList( );
	ArrayList<AccountDto> getAccountListSortByBalance();
	ArrayList<AccountDto> getAccountListSortByUserSeq();
	
	AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException;
	int withdraw(int userSeq, int accountSeq, int amount) throws BalanceLackException, UserAccountNotFoundException;
}
