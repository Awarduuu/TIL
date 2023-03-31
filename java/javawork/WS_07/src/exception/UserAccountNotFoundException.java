package exception;

// WS_06 대비
// 새로운 클래스
public class UserAccountNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserAccountNotFoundException() {
		super("사용자 또는 계좌를 찾을 수 없습니다.");
	}
	public UserAccountNotFoundException(String message) {
		super(message);
	}
}
