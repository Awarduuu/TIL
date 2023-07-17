package web.mvc.dao;

import web.mvc.dto.TransferDTO;

public interface TransferDAO {
  /**
   * 출금하기
   * */
	int widthDraw(TransferDTO transferDTO);
	
	/**
     * 입금하기
   	* */
	int deposit(TransferDTO transferDTO);
	
}
