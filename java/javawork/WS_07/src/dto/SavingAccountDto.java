package dto;

// WS_04 대비
// 새로운 클래스, extends AccountDto, transferFee, setter & getter toString, private, toString
public class SavingAccountDto extends AccountDto{
	private int transferFee;
	
	public SavingAccountDto(){}
	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee){
		super(accountSeq, accountNumber, balance, userSeq);
		this.transferFee = transferFee;
	}
	
	public int getTransferFee() {
		return transferFee;
	}
	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}
	
	@Override
	public String toString() {
		return "SavingAccountDto [transferFee=" + transferFee + ", getAccountSeq()=" + getAccountSeq()
				+ ", getAccountNumber()=" + getAccountNumber() + ", getBalance()=" + getBalance() + ", getUserSeq()="
				+ getUserSeq() + "]";
	}

}
