package kb.view;

import kb.dao.EmpDAO;
import kb.dto.EmpDTO;

public class Test {

	public static void main(String[] args) {
		//1. 전체 사원 검색
		System.out.println("********** 1. 전체 사원 검색 ***********");
		EmpDAO dao = new EmpDAO();
//		dao.selectAll();
		
		//2. 사원 등록
		int result = dao.insert(new EmpDTO(7102, "KEPA", "SALESMAN", 2000));
		if(result > 0) {
			System.out.println("등록되었습니다.");
		}else {
			System.out.println("등록되지 않았습니다.");
		}
	}

}
