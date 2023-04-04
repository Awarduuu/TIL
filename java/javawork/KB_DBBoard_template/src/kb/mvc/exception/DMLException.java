package kb.mvc.exception;
/**
 * insert, update, delete에 결과가 오류났을 때
 */
public class DMLException  extends RuntimeException{
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}

}
