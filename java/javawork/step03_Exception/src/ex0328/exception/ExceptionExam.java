package ex0328.exception;

public class ExceptionExam {

	public void aa(String[] args) {
		System.out.println("aa 메소드 시작...");
		try {
			String str = args[0];
			System.out.println("전달된 값 = " + str);
			
			int no = Integer.parseInt(str);
			System.out.println("변환된 값 = " + no);
			
			this.bb(no);
			int result = 100 / no;
			System.out.println("나눈 결과 = " + result);
			
			// catch 작성할 때 반드시 서브클래스부터 작성한다.
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("e = " + e); // e.toString() -> 예외클래스 : 예외메시지
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력하세요 = " + e.getMessage());
		}catch(Exception e) {
			
			// 개발할 때 예외가 발생하면 예외에 대한 정보를 정확하게 추적할 수 있는 정보를 제공한다.
			// secure code 가이드라인에 의거하여 배포할 때 (운영환경 - production) 반드시 제거해야 한다. - 보안을 위해서
			e.printStackTrace(); // 	
			System.out.println("예외가 발생했어요");
		}
		System.out.println("aa 메소드 끝...");
	}
	
	public void bb(int i) throws Exception{
		try {
			System.out.println("bb 메소드 시작...");
			if(i > 10) {
				// 강제로 예외를 발생시킨다.
				throw new Exception("10보다 작아야한다.");
			}
			int re = 200/i;
			System.out.println("bb안에서 나눈 결과 : " + re);
		}finally {
			System.out.println("bb 메소드 끝...");
		}
	}
	public static void main(String[] args) {
		System.out.println("******** 메인 시작 ********");
		
		ExceptionExam exam = new ExceptionExam();
		exam.aa(args);
		
		System.out.println("******** 메인 끝 *********");
	}

}
