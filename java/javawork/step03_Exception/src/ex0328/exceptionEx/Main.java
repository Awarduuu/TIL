package ex0328.exceptionEx;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingMall shop = new ShoppingMall();
		Random rd = new Random();
		
		for(int i=0; i<10; i++) {
			try {
				int age = rd.nextInt(55)+1;
				shop.come(age);
				System.out.println(age + "살 입장하신걸 환영합니다.");
			}catch(AgeException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		System.out.println("총 예외 발생 수 : " + AgeException.getCount());
	}

}
