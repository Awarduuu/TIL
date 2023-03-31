package exception;

// WS_06 대비
// 새로운 클래스
public class BalanceLackException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BalanceLackException() {
		super("잔액이 부족합니다.");
	}
	public BalanceLackException(String message) {
		super(message);
	}
}
