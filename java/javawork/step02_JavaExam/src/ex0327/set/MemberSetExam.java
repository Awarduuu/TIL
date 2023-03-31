package ex0327.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	private Set<Member> set = new HashSet<>();
	
	public MemberSetExam() {
		/**
		 * Set의 중복 체크
		 * : 먼저 hashCode()메소드를 호출해서 다르면 다른객체로 인식을 하고
		 *   만약 hashCode()가 같으면 equals() 메소드를 호출해서 
		 *   true이면 같은 객체 / false이면 다른 객체로 인식*/
		
		// 3개 저장
		set.add(new Member("윤상우", 26, "서울"));
		System.out.println("\n---------------------");
		set.add(new Member("윤상우", 26, "인천"));
		System.out.println("\n---------------------");
		set.add(new Member("장세호", 27, "계룡"));
		
		System.out.println("저장된 객체의 개수 : " + set.size());
	}
	
	public static void main(String[] args) {
		new MemberSetExam();
	}
}
