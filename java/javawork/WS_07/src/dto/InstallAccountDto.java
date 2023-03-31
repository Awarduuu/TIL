package dto;

// WS_04 대비
// 새로운 클래스, extends AccountDto, period, amount , setter & getter toString, , private
public class InstallAccountDto extends AccountDto{
	private int period;
	private int amount;
	
	public InstallAccountDto(){}
	public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int period, int amount){
		super(accountSeq, accountNumber, balance, userSeq);
		this.period = period;
		this.amount = amount;
	}
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "InstallAccountDto [period=" + period + ", amount=" + amount + ", getAccountSeq()=" + getAccountSeq()
				+ ", getAccountNumber()=" + getAccountNumber() + ", getBalance()=" + getBalance() + ", getUserSeq()="
				+ getUserSeq() + "]";
	}

}
