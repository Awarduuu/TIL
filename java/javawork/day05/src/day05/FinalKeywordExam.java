package day05;

public class FinalKeywordExam {
	final int i; // 반드시 초기화 필수, 생성자에서 초기화 가능
	static final int J = 10; // 반드시 초기화 필수, 생성자에서 초기화 불가능
	int k; 
	
	public FinalKeywordExam() {
		i = 50; // final 필드를 생성자를 이용해서 초기화 할 수 있다.
	}
	public FinalKeywordExam(int value) {
		i = value; // final 필드를 생성자를 이용해서 초기화 할 수 있다.
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
