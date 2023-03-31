package day05;

interface A {
	// 필드 public static final
	int i = 0; // 반드시 초기화 필수
	
	// 메소드 public abstract
	void aa(); // {body}가 없어야 함
	abstract void bb();
}

interface B {
	int cc();
	String dd(int i);
}

class C {
	public void test() {};
}

class Test extends C implements A, B { // Test is a A, B, C 성립

	// A의 abstract void Override
	@Override
	public void aa() {
		
	}

	@Override
	public void bb() {
		
	}
	
	// B의 abstract void Override
	@Override
	public int cc() {
		return 0;
	}

	@Override
	public String dd(int i) {
		return null;
	}
	
}

public class InterfaceExam {

	public static void main(String[] args) {
//		A a = new A(); 인터페이스는 생성 불가
 		// 다형성
		A a = new Test();
		B b = new Test();
		C c = new Test();
	}

}
