package web.mvc.dao;

import web.mvc.dto.TransferDTO;

public interface TransferDAO {
  /**
   * ����ϱ�
   * */
	int widthDraw(TransferDTO transferDTO);
	
	/**
     * �Ա��ϱ�
   	* */
	int deposit(TransferDTO transferDTO);
	
}
