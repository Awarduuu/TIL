package ex0324;

public class SpiderMan extends Person { // SpiderMan is a Person
	private boolean spider;

	public SpiderMan() {}
	public SpiderMan(String name, int age, boolean spider) {
		super(name, age);
		this.spider = spider;
	}
	
	public boolean isSpider() { // boolean형의 조회는 isXxx로 된다.
		return spider;
	}

	public void setSpider(boolean spider) {
		this.spider = spider;
	} 
	
	@Override
	public String toString() {
		return super.toString()+ " | " + spider;
	}
	
	public void jump() {
		System.out.println("SpiderMan만 가지고 있는 jump() call...");
	}
	
	@Override
	public void walk() {
		// 부모쪽에 있는 walk() 호출하고 싶다.
		super.walk();
		System.out.println("SpiderMan의 walk() call - 걷는거 싫다.");
	}
	@Override
	public void sleep() {
		System.out.println("SpiderMan의 sleep call");
	}
}
