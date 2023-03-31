package ex0324;

public abstract class Person implements Comparable<Person>{ // extends Object
	// 은닉(외부에서 사용자 마음대로 조회, 변경 막는다.)
	private String name;
	private int age;
	
	public Person() {} // 기본생성자
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, int age) {
		this(name); // String 인수 하나 받는 생성자 호출 (반드시 생성자 구현부 첫줄에서만)
		this.age = age;
	}
		
	/* setXxx() - 수정
	 * : 제한자 - public
	 *   리턴타입 - void
	 *   메소드이름 - set + 필드이름 첫글자 대문자()
	 *   인수 - 필수
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	/* getXxx() - 조회
	 * : 제한자 - public
	 *   리턴타입 - 필수
	 *   메소드이름 - get + 필드이름 첫글자 대문자()
	 *   인수 - x
	 * 
	 */
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	/*
	 * 부모의 정의되어 있는 메소드를 자식클래스에서 새롭게 재정의하는 것을 Overriding이라 한다.
	 * : 규칙 - 제한자만 다를 수 있고, 접근제한자는 부모제한자보다 같거나 커야한다.
	 * 		   리턴타입, 메소드이름, 인수는 모두 같다. 단, 기능은 다르게 한다.
	 */
	
	@Override
	public String toString() {
		return name + " | " + age;
	}
	
	public void eat() {
		System.out.println("Person의 eat() call");
	}
	
	public void walk() {
		System.out.println("Person의 walk() call");
	}
	
	// 추상메소드 선언 - 선언문만 있고 body=기능은 없다.
	public abstract void sleep();
	
	@Override
	public int compareTo(Person o) {
		return age - o.getAge();
	}
}
