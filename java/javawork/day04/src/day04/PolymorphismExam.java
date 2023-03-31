package day04;

class CarCenter{
	// 매개변수를 이용한 다형성
	public void engineer(Car cd){
//		System.out.println(cd.a);; => error!!! 부모타입으로는 자식부분 접근 불가이기 때문
//		접근이 가능하도록 하기 위해서는 ObjectDownCasting을 한다.
		if(cd instanceof Carnival) { // 상속관계일때만 사용가능 
			Carnival car = (Carnival) cd; // 부모 > 자식이기 때문에 Down
			System.out.println("car = " + car);
			System.out.println("car.a = " + car.a);
		}
 		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		
		
		Car c= new Car();
		
		System.out.println("ca = " + ca);
		System.out.println("ca.a = " + ca.a);
		
//		
//		cc.engineer(c);//
//		cc.engineer(ef);//
//		cc.engineer(ca);//
//		cc.engineer(ex);//
		
		
	
	}
}
