package web.mvc.service;

import web.mvc.dto.TransferDTO;
import web.mvc.exception.MyException;

public interface TransferService {
  /**
   * ������ü�ϱ�
   * */
   int transfer(TransferDTO transferDTO) throws MyException;
   
    void test();
}
