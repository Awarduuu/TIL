package web.mvc.service;

import web.mvc.dto.TransferDTO;
import web.mvc.exception.MyException;

public interface TransferService {
  /**
   * 계좌이체하기
   * */
   int transfer(TransferDTO transferDTO) throws MyException;
   
    void test();
}
