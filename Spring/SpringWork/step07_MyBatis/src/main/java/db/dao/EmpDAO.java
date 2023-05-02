package db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.common.DBManager;
import db.dto.EmpDTO;

public class EmpDAO {

	
	/**
	 * ename 검색 
	 */
	public void selectByEname() {
		SqlSession session= null;
		try {
			session = DBManager.getSession();
			List<String> list = session.selectList("empMapper.selectName");
			System.out.println("List = " + list);
		}finally {
			DBManager.sessionClose(session);
		}
	}
	
	/**
	 * 등록하기
	 */
	public void insert(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.insert("empMapper.insert", empDTO) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제하기
	 */
	public void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.delete("empMapper.delete", empno) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	public void selectOrder(String columnName) {
		SqlSession session= null;
		try {
			session = DBManager.getSession();
			List<EmpDTO> list = session.selectList("empMapper.selectByOrder", columnName);
			System.out.println("List = " + list);
		}finally {
			DBManager.sessionClose(session);
		}
	}
	
	
	
}
