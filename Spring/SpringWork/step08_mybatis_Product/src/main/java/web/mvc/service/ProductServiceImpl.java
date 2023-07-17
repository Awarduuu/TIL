package web.mvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyException;
import web.mvc.repository.ProductDAO;


@Service
//@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO; 
	
	//@Transactional
	@Override
	public int insert(ProductDTO productDTO) {
		int result = 0;
		try {
		  result=productDAO.insert(productDTO);
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("등록에 예외가 발생했습니다.");
		}
		
		return result;
	}

	@Override
	public List<ProductDTO> selectAll() {
		// TODO Auto-generated method stub
		return productDAO.selectAll();
	}

	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		// TODO Auto-generated method stub
		return productDAO.selectByKeyWord(keyField, keyWord);
	}

	@Override
	public List<ProductDTO> selectOrder(String columnName) {
		// TODO Auto-generated method stub
		return productDAO.selectOrder(columnName);
	}

	//@Transactional
	@Override
	public int update(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return productDAO.update(productDTO);
	}

	//@Transactional
	@Override
	public int delete(String code) {
		int result = productDAO.delete(code);
		if (result==0)throw new MyException(code+"에 해당하는 정보를 삭제 할수 없습니다.");
		return result;
	}

	@Override
	public int selectSumQty() {
		// TODO Auto-generated method stub
		return productDAO.selectSumQty();
	}

}
