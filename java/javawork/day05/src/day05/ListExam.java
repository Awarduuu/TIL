package day05;

import java.util.ArrayList;

public class ListExam extends ArrayList<Integer> {
	public ListExam() {
		super(6);
		// 추가
		super.add(3);
		this.add(5);
		add(1);
		super.add(7);
		
		// 출력
		System.out.println("저장된 개수 : " + super.size()); // 저장된 개수 : 4
		
		for(int i=0; i<super.size(); i++) {
			// 저장된 데이터 조회
			int num = super.get(i);
			System.out.print(num + " ,"); // 3 ,5 ,1 ,7 ,
		}
		
		// 제거
		super.remove(2); // index가 2번지, 즉 3번째 객체를 제거
		
		System.out.println("\n제거 후 저장된 개수 : " + super.size()); // 제거 후 저장된 개수 : 3
		
		// Collection은 Object의 toString을 Overriding해서 주소값이 아닌 내용물이 출력한다.
		System.out.println(this); // [3,5,7]
	}
	
	public static void main(String[] args) {
		new ListExam();
	}
}
