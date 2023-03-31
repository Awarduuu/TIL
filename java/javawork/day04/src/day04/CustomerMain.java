package day04;

public class CustomerMain {

	public static void main(String[] args) {
		Customer [] cuArr = new Customer [3];
		
 		cuArr[0] = new Customer(); // 기본값 초기화
 		cuArr[1] = new Customer("jang", 20, "서울"); // 모든 필드 초기화
 		cuArr[2] = new Customer("hee", 30);
 		
 		//출력
 		for(Customer c : cuArr) {
 			System.out.println("아이디 : " + c.getId());
 			System.out.println("나이 : " + c.getAge());
 			System.out.println("주소 : " + c.getAddr());
 		}
 		
 		//나이 변경
 		cuArr[0].setAge(25);
 		System.out.println("------------변경 후 출력--------------");
 		
 		//출력
 		for(Customer c : cuArr) {
 			System.out.println("아이디 : " + c.getId());
 			System.out.println("나이 : " + c.getAge());
 			System.out.println("주소 : " + c.getAddr());
 		}
	}

}
