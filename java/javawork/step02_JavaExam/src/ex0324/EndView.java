package ex0324;

import java.util.List;

public class EndView {
	/**
	 * 모든 리스트의 정보를 출력
	 */
	
	public static void printList(List<Person> list) {
		System.out.println("----------list 정보(" + list.size() + "명)----------");
		for(Person p : list) System.out.println(p);
	}
	
	/**
	 * 이름에 해당하는 정보 출력하기
	 * */
	public static void printPerson(Person person) {
		System.out.println("----" + person.getName() + "님의 정보입니다.----");
		System.out.println(person);
	}
	
	/**
	 * 성공 또는 실패 메시지 출력하기
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
