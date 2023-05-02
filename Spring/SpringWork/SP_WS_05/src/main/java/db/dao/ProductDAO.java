package db.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import db.common.DBManager;
import db.dto.ProductDTO;

public class ProductDAO {
	
	/**
	 * 1. 레코드 삽입
	 */
	public void insert(ProductDTO productDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.insert("productMapper.insert", productDTO) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	/**
	 * 2. 전체레코드 검색 
	 */
	public void selectAll() {
		SqlSession session= null;
		try {
			session = DBManager.getSession();
			List<ProductDTO> list = session.selectList("productMapper.selectAll");
			System.out.println("List = " + list);
		}finally {
			DBManager.sessionClose(session);
		}
	}
	
	/**
	 * 3. 검색필드 , 검색단어에 해당하는 레코드 검색
	 */
	public void selectByField(Map<String, String> map) {
		SqlSession session= null;
		try {
			session = DBManager.getSession();
			List<ProductDTO> list = session.selectList("productMapper.selectByField", map);
			System.out.println("List = " + list);
		}finally {
			DBManager.sessionClose(session);
		}
	}

	/**
	 * 4. 전달된 컬럼을 기반으로 정렬하기
	 */
	public void selectByOrder(String columnName) {
		SqlSession session= null;
		try {
			session = DBManager.getSession();
			List<ProductDTO> list = session.selectList("productMapper.selectByOrder", columnName);
			System.out.println("List = " + list);
		}finally {
			DBManager.sessionClose(session);
		}
	}
	
	/**
	 * 5. parameter 정보에 따라 레코드 수정한다.
	 */
	public void updateByCode(ProductDTO productDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.insert("productMapper.updateByCode", productDTO) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	/**
	 * 6. 상품코드에 해당하는 레코드 삭제
	 */
	public void deleteByCode(String codeName) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.insert("productMapper.deleteByCode", codeName) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	/**
	 * 7. 모든 상품의 개수를 출력한다.
	 */
	public void selectSumQty() {
		SqlSession session = null;
		try {
			session = DBManager.getSession();
			int result = session.selectOne("productMapper.selectSumQty");
			System.out.println("result = " + result);
		}finally {
			DBManager.sessionClose(session);
		}
	}
}
