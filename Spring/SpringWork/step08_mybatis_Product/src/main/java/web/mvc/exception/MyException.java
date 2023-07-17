package web.mvc.exception;

public class MyException extends RuntimeException {
	public MyException() {}
	public MyException(String message) {
		super(message);
	}

}
