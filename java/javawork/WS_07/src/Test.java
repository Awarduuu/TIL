import dto.AccountDto;
import exception.BalanceLackException;
import exception.UserAccountNotFoundException;
import service.BankService;
import service.BankServiceImpl;
// WS06 대비 추가
// - BankService 에 getUserAccount, withdraw 추가
// - exception package
public class Test {

	public static void main(String[] args) {

		BankService bankService = new BankServiceImpl();
		
		System.out.println(bankService.getAccountList());
		System.out.println(bankService.getAccountListSortByBalance());
		System.out.println(bankService.getAccountListSortByUserSeq());
		
		for (AccountDto accountDto : bankService.getAccountList()) {
			System.out.println(accountDto);
		}
		
		
		try {
			int withdrawAmount = bankService.withdraw(111, 10, 5000);
			System.out.println(withdrawAmount);
			
			System.out.println(bankService.getUserAccount(111, 10));
			
		}catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
