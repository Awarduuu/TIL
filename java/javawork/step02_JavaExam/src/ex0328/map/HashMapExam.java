package ex0328.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapExam {
	
//	Map<Integer, String> map = new HashMap<>();
	Map<Integer, String> map = new TreeMap<>(); // key를 정렬
	
	public HashMapExam() {
		map.put(10, "상우");
		map.put(50, "용준");
		map.put(40, "진성");
		map.put(30, "진운");
		map.put(10, "김부장");
		map.put(220, "상우");
		
		System.out.println("개수 : " + map.size());
		System.out.println(map);
		
		map.remove(10);
		System.out.println("\n-------- 제거 후 ---------");
		System.out.println("개수 : " + map.size());
		System.out.println(map);
		
		System.out.println("\n-------- 조회하기 ---------");
		// 모든 key의 정보를 가져온다.
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}
		
		System.out.println("\n-------- 개선된 for 변경 ---------");
		for(Integer key : map.keySet()) {
			System.out.println(key + " = " + map.get(key));
		}
		
		System.out.println("\n-------- Map.Entry<K, V> 가져오기 ---------");
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> iter = set.iterator();
		
		while(iter.hasNext()) {
			Map.Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		System.out.println("\n-------- 개선된 for 변경 ---------");
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		new HashMapExam();
	}

}
