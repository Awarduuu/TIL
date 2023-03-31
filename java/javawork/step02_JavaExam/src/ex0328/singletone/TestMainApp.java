package ex0328.singletone;

class Test {
	private static Test instance = new Test();
	private Test(){}
	
	/**
	 * 현재 객체 내에서 자신을 생성해서 리턴해주는 메소드 제공
	 * */
	
	public static Test getInstance() {
		return instance;
	}
}

public class TestMainApp {
	public static void main(String[] args) {
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		System.out.println(t1);
		System.out.println(t2);
	}
}
