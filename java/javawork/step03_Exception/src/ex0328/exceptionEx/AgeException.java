package ex0328.exceptionEx;

public class AgeException extends Exception {

	private static int count = 0;
	
	
	public static int getCount() {
		return count;
	}

	public AgeException(String message) {
		super(message);
		count++;
	}
}
