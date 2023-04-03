package kb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kb.common.DBManager;
import kb.dto.EmpDTO;

public class EmpDAO {

	/**
	 * emp테이블의 사원 정보 검색하기
	 * select empno, ename, job, sal, hiredate from emp
	 * */
	public void selectAll() {
		// 필요한 지역변수 먼저 선언
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp";
		
		try {
			// 연결
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 ?의 개수만큼 순서대로 setXxx 설정한다.
			rs = ps.executeQuery();
			while(rs.next()) {// 앞으로 행을 내린다.
				// 열을 조회한다.
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt(4);
				String hiredate = rs.getString(5);
				System.out.println(empno + " | " + ename + " | " + job + " | " + sal + " | " + hiredate );
			}
			System.out.println("--------- 완료 ----------");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
	}// selectAllEnd
	
	/**
	 * 사원 등록하기
	 * insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?,sysdate)
	 * */
	
	public int insert(EmpDTO emp) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?,sysdate)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}
}//classEnd
