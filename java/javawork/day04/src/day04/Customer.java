package day04;

public class Customer {
	private String id;
	private int age;
	private String addr; // 선택
	
	public Customer() {}
	public Customer(String id, int age, String addr) {
		//생성자 호출 방법 : 반드시 생성자 구현부 첫번째 줄에서만... => this(값); 활용
		this(id, age); // Customer(String id, int age) 호출
		
		this.addr = addr;
	}
	// 상황에 따라 선택적인 값을 받아들이기 위해 오버로딩을 한다!
	public Customer(String id, int age) {
		this.id = id;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age > 18) 
			this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
