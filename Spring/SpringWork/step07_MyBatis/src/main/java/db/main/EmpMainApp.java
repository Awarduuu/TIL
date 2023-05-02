package db.main;

import db.dao.EmpDAO;
import db.dto.EmpDTO;

public class EmpMainApp {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		
		System.out.println("1. 사원 이름 검색 ---------------------");
//		dao.selectByEname();
		
		System.out.println("\n2. 등록하기 ---------------------");
//		dao.insert(new EmpDTO(9899, "장희정", "강사2", 2500, null));
//		dao.insert(new EmpDTO(7878, null, "강사2", 2500, null));
		
		
		System.out.println("\n3. 삭제하기 ---------------------");
//		dao.delete(9899);
		
		System.out.println("\n4. 수정하기 ---------------------");
		//dao.update(new EmpDTO(2500, "얼짱", "백조", 1000, null));
		
		System.out.println("\n5. 전체검색하기 ---------------------");
       //dao.selectAll();
		System.out.println("\n6. 사원번호 검색하기 ---------------------");
		//dao.selectByEmpno(2000);
		
		System.out.println("\n7. sal 적게받는 사원 검색하기 ---------------------");
	    //dao.selectLessthanSal(2000);
		
		System.out.println("\n8.Min ~ Max 검색 ---------------------");
		//dao.selectMinMax(2000, 3000);
	   
		System.out.println("\n9.정렬하기 --------------------");
		dao.selectOrder("empno");
		
		System.out.println("\n10.검색필드와 검색단어 또는 사원번호 또는 급여 해당하는 레코드 검색 ");
		//dao.selectWhereMix("ename", "a", 9898, 3500);
		
		System.out.println("\n11.job 검색...------------------------- ");
		//dao.selectByJob("manager");
		
		System.out.println("\n12.Member 검색...------------------------- ");
	}

}