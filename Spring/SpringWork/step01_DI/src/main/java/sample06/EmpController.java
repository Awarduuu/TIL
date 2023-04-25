package sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {
	@Autowired // byType에 의해서 주입 -> byName을 주입 
	@Qualifier("emp2") //@Autowired 쓸 때 동일한 타입 객체 여러개이고 id와 property명이 일치하는게 없을 때 설정이 필요하다.
	private EmpDTO empDTO; //주입(생성자 또는 setter 만들었다.)
	
	@Autowired
	private EmpDTO emp;
	
	@Autowired // byType에 의해서 주입 -> byName을 주입 
	private EmpService service; //주입 
	
	public EmpController() {
		System.out.println("EmpController 생성자 호출");
	}
	
	public void test() {
		System.out.println("empDTO = " + empDTO + ", empno = " + empDTO.getEmpno());
		System.out.println("emp = " + emp + ", empno = " + emp.getEmpno());
		System.out.println("service = " + service);
		
		service.test();
	}
}
