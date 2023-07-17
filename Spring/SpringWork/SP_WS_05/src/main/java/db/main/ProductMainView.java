package db.main;

import java.util.HashMap;
import java.util.Map;

import db.dao.ProductDAO;
import db.dto.ProductDTO;

public class ProductMainView {
  public static void main(String[] args) {
	  
	  ProductDAO dao = new ProductDAO();
	  /**
	   * [1]. 레코드 삽입
	   * */
	  System.out.println("********** [1] 상품 등록하기 ******************");
//	  dao.insert(new ProductDTO("A06","꼬북칩",20,2500,"꼬북칩은 초코맛이 진리"));
	  
	  /**
	   * [2]. 전체레코드 검색 
	     ex) select * from productList
	     *        
	   * */
	   System.out.println("********** [2] 모든 게시물 검색 ******************");
	   dao.selectAll();

      /**
	   * [3]. 검색필드 , 검색단어에 해당하는 레코드 검색
	     ex) select * from productList where 검색필드 like  검색단어
	     *        
	   * */
	   System.out.println("********** [3] 검색필드 , 검색단어에 해당하는 레코드 검색 ******************");
//	   Map<String, String> map = new HashMap();
//	   map.put("field", "code");
//	   map.put("word", "A06");
//	   
//	   dao.selectByField(map);

	    /**
	   * [4]. 전달된 컬럼을 기반으로 정렬하기 
	     ex)  ex) select *from productList order by 정렬대상
	     *        
	   * */
       System.out.println("********** [4] 전달된 컬럼을 기반으로 정렬하기  ******************");
//       dao.selectByOrder("price");
      
	 
	  /**
	   * [5].  parameter 정보에 따라 레코드 수정한다.
	   *     상품코드에 해당하는 상품의 
	   *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정한다.
	   * 
	   * */
	  System.out.println("********** [5] 상품 수정하기 ******************");
//	  dao.updateByCode(new ProductDTO("A06","꼬북칩(인절미)",10,1500,"꼬북칩은 인절미맛이 진리"));
	  
	  /**
	   * [6].상품코드에 해당하는 레코드 삭제
	   * */
	  System.out.println("********** [6] 상품 삭제하기 ******************");
//	  dao.deleteByCode("A06");
	 /**
	  * [7]. 모든 상품의 개수를 출력한다.

		  select sum(p_qty) from product -- 모든상품의 qty의총합계
	  * */
	  System.out.println("********** [7] 등록된 총 상품 개수 ******************");
//	  dao.selectSumQty();


	
	  

}
}







