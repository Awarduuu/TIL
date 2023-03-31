package day04.superEx;

class Animal {
	int legs = 4;
	String name ="name";
	Animal(){
		System.out.println("Aniaml() 1...");
	}
	
	Animal(int i){
		System.out.println("Animal(int i) 2...");
	}
	
	Animal(String s){
		System.out.println("Animal(String s) 3....");
	}
	
	/*
	 * 소리낸다.
	 * */
	public void sound() {
		System.out.println("Rrrrrrr");
	}
	
	/*
	 * 달린다
	 * */
	public void run() {
		System.out.println("호다닥");
	}
}

class Pig extends Animal {
	int legs = 2;
	int age = 5;
	Pig(){
		this(4); // super가 없어졌다. Pig(int i)를 호출했기 때문
		System.out.println("Pig() 3...");
		
//		//변수 접근!
//		System.out.println(legs); //2
//		System.out.println(this.legs); //2
//		System.out.println(super.legs); //4
//		
//		//변수 접근!
//		System.out.println(name); //name
//		System.out.println(this.name); //name
//		System.out.println(super.name); //name
//		
//		//변수 접근!
//		System.out.println(age); //5
//		System.out.println(this.age); //5
////		System.out.println(super.age); //error
	}
	
	Pig(int i){
		super(i); // Animal(int i)를 호출
		System.out.println("Pig(int i) 4...");
	}
	
	Pig(boolean b){
		super(b+"안녕"); // Animal(String s)를 호출
		System.out.println("Pig(boolean b) 5...");
	}
	
	//재정의
	@Override
	public void sound() {
		System.out.println("꿀꿀");
	}
	
	
	@Override
	public void run() {
		System.out.println("터벅");
	}
	
	public void eat() {
		System.out.println("너무 많이 먹는다~");
	}
}



public class SuperConstructorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig = new Pig();
		// 모든 자식 생성자 구현부 첫번째 줄에는 super(); 가 생략되어있다.
		// 반드시 부모의 기본 생성자가 필요하다.
		// 부모의 생성자가 하나도 없으면 기본 생성자가 자동 삽입되므로 문제 없다.
		
		pig.sound(); // 재정의
		pig.run(); // 재정의 안함
		
		System.out.println("-----다형성------");
		Animal animal = new Pig();
		System.out.println(animal.legs);
		System.out.println(animal.name);
		
		animal.sound(); // **중요** Rrrr가 아닌 꿀꿀이 나온다
//		animal.eat(); // 자식 부분에만 있는 메소드는 접근이 불가능하다.
		
		if(animal instanceof Pig) {
			Pig p = (Pig) animal;
			System.out.println(p.age);
			p.eat();
		}
		
	}

}
