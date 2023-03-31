package ex0327.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
//	Set<Integer> set = new HashSet<>(); // 중복 안됨
	Set<Integer> set = new TreeSet<>(); // 중복 안됨 + 요소 정
	public SetExam(String [] args) {
		// set 숫자를 추가
		for(String s : args) {
			boolean result = set.add(Integer.parseInt(s));
			System.out.println(s+" 추가 결과 = "+ result);
		}
		
		System.out.println("저장된 개수 : " + set.size());
		
		//Iterator interface는 모든 자료구조 안에 저장된 데이터를 추출(꺼내기) 할 때 사용하는
		//표준화된 interface이다.
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			// 요소가 존재한다면
			int no = it.next();
			System.out.println(no);
		}
		
		System.out.println("---------- 개선된 for -----------");
		for(int no : set) {
			System.out.println(no);
		}
		
		// 제거
		boolean result = set.remove(30);
		System.out.println("---------- 제거 후 -----------");
		System.out.println("제거 결과 = " +result);
		System.out.println(set);
		
	}
	public static void main(String[] args) {// 실행 : java SetExam 값 값 값 ...
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);
		new SetExam(args);
	}

}
