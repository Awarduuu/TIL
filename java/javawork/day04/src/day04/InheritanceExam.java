package day04;


class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당

class EfSonata extends Car {
	// 생성자의 접근제한자는 class의 접근제한자를 따라간다 ex) 생략 -> 생략
	EfSonata(){
		super.carname = "EfSonata";
		super.cost = 50_000_000;
	}
}

class Excel extends Car {
	Excel(){
		super.carname = "Excel";
		super.cost = 30_000_000;
	}
}

class Carnival extends Car {
	int a = 100;
	Carnival(){
		super.carname = "Carnival";
		super.cost = 40_000_000;
	}
}
	

public class InheritanceExam{
	//메인메소드에서 
	
		//Car, EfSonata, Excel, Canival 네개의 객체를 생성
		// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
		public static void main(String[] args) {
			Car car = new Car();
			car.carname = "ferrari";
			car.cost = 100_000_000;
			EfSonata efSonata = new EfSonata();
			Excel excel = new Excel();
			Carnival carnival = new Carnival();
			
			car.printAttributes();
			efSonata.printAttributes();
			excel.printAttributes();
			carnival.printAttributes();
		}
	
}


