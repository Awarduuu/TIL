package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam2{
	List<Integer> list = new ArrayList<Integer>(6);
	
	public ListExam2() {
		// 추가
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(7);
		list.add(1);
		list.add(2);
		
		// 출력
		System.out.println("저장된 개수 : " + list.size()); // 저장된 개수 : 4
		
		for(int i=0; i<list.size(); i++) {
			// 저장된 데이터 조회
			int num = list.get(i);
			System.out.print(num + " ,"); // 3 ,5 ,1 ,7 ,
		}
		
		// 제거
		list.remove(2); // index가 2번지, 즉 3번째 객체를 제거
		
		System.out.println("\n제거 후 저장된 개수 : " + list.size()); // 제거 후 저장된 개수 : 3
		
		System.out.println(list); // 주소
		
		// 정렬
		Collections.sort(list);
		Collections.sort(list, null);
		
		System.out.println("정렬 후 : " + list); // 오름차순 정렬
	}
	
	public static void main(String[] args) {
		new ListExam2();
	}
}
