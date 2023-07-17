package web.mvc.service;

import java.util.List;

import web.mvc.dto.ProductDTO;

public interface ProductService {
	/**
	 * 1.레코드 삽입
	 * */
	 int insert(ProductDTO productDTO) ;
	
	/**
	 * 2. 전체검색
	 * */
	List<ProductDTO> selectAll() ;
	
	/**
	 * 3. 검색필드 , 검색단어에 해당하는 레코드 검색
	 * */
	List<ProductDTO> selectByKeyWord(String keyField, String keyWord) ;
	
	/**
	 * 4. 정렬대상 컬럼을 인수로 받아 정렬
	 * */
	List<ProductDTO> selectOrder(String columnName) ;
	/**
	 * 5. 파라미터 값을 받아 업데이트하기
	 * */
	int update(ProductDTO productDTO);
	/**
	 * 6.삭제하기
	 * */
	int delete(String code) ;
		
	/**
	 * 7. qty 전체 개수 구하기
	 * */
	int selectSumQty() ;

}
