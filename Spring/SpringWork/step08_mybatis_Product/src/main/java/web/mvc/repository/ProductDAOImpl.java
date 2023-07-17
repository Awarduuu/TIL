package web.mvc.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.mvc.dto.ProductDTO;


@Repository
public class ProductDAOImpl implements ProductDAO {
    public static final String NS="ns.sql.productMapper.";
    
    @Autowired
    private SqlSession session; // mybatis-spring의 SqlSessionTemplate 구현체가 주입 
	
	
	
	@Override
	public int insert(ProductDTO productDTO) {
		return session.insert(NS+"insert", productDTO);
	}

	@Override
	public List<ProductDTO> selectAll() {
		return session.selectList(NS+"selectAll");
	}

	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("field", keyField);
		map.put("keyword", keyWord);
		return session.selectList(NS+"selectByKeyWord", map);
	}
	

	@Override
	public List<ProductDTO> selectOrder(String columnName) {
		return session.selectList(NS+"selectByOrder", columnName);
	}

	@Override
	public int update(ProductDTO productDTO) {
		return session.update(NS+"update", productDTO);
	}

	@Override
	public int delete(String code) {
		return session.delete(NS+"delete", code);
	}

	@Override
	public int selectSumQty() {
		return session.selectOne(NS+"selectSumQty");
	}

}
