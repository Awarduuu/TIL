package ex0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SpiderMan or Person 객체를 관리(CRUD = 등록, 수정, 삭제, 조회)하는 클래스
 * */
public class Service {

	List<Person> list = new ArrayList<>();
	
	
	/**
	 * 샘플데이터 추가 기능
	 * */
	public Service () {
		list.add(new SpiderMan("peter", 19, true));
		list.add(new SpiderMan("parker", 17, true));
		list.add(new SpiderMan("mj", 17, false));
		list.add(new Student("peter", 18, 1));
		list.add(new Student("mj", 14, 5));
		list.add(new Student("strange", 38, 3));
	}
	
	/**
	 * 전체조회(등록된 순으로...)
	 */
	public List<Person> selectAll(){
		return this.list;
	}
	
	/**
	 * 등록하기
	 **/
	public void insert(Person person) {
		list.add(person);
	}
	
	/**
	 * 인수로 전달된 name에 해당하는 사람의 정보 조회하기 (name은 중복 안됨)
	 * @return : null이면 없다, 아니면 찾았다 
	 * */
	public Person selectByName(String name) {
		for(Person p : this.list) {
			if(p.getName().equals(name)) return p;
		}
		return null;
	}
	
	/**
	 * 인수로 전달된 name에 해당하는 정보 삭제하기 
	 * @return : true이면 삭제 성공, false이면 삭제 실패
	 **/
	public boolean deleteByName(String name) {
		Person p = this.selectByName(name);
		boolean result = list.remove(p);
		return result;
	}
	
	/**
	 * 나이를 기준으로 정렬해서 조회하기
	 * */
	
	public List<Person> sortByAge() {
		ArrayList<Person> temp = (ArrayList<Person>)list;
		temp = (ArrayList<Person>) temp.clone();
		
		Collections.sort(temp, (o1, o2) -> (o1.getAge() - o2.getAge()));
		return temp;
	}
}
