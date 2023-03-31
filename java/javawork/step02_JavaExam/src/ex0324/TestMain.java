package ex0324;

import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("--------SpiderMan 3명 + Student 3명 관리하고 싶다.--------");
		
		Service service = new Service();
		List<Person> list = service.selectAll();
		/**
		 * 파커 찾기
		 * */
		Person p = service.selectByName("parker");
		System.out.println(p);
		
		service.deleteByName("parker");
		
		System.out.println("-----------정렬 전------------");
//		리스트에 저장된 모든 정보를 출력해보자
		EndView.printList(list);
		
		System.out.println("-----------정렬 호출------------");
		List<Person> sortedList = service.sortByAge();
		EndView.printList(sortedList);
		
		System.out.println("-----------정렬 후------------");
		EndView.printList(list);
		
		System.out.println("\n-----------1.등록------------");
		service.insert(new Student("상우", 26, 10));
		service.insert(new SpiderMan("SW", 26, true));
		EndView.printList(list);
		
		System.out.println("\n-----------2. 이름으로 찾기------------");
		Person ps = service.selectByName("상우");
		if(ps == null) {
			EndView.printMessage("정보가 없습니다.");
		}else {
			EndView.printPerson(ps);
		}
		System.out.println("\n-----------3. 삭제하기 ------------");
		
		if(service.deleteByName("상우")) {
			EndView.printMessage("삭제 성공하였습니다.");
		}else {
			EndView.printMessage("삭제 실패하였습니다.");
		}

	}

}
