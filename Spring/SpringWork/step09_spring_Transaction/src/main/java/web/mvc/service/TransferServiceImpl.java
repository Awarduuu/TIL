package web.mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import web.mvc.dao.TransferDAO;
import web.mvc.dto.TransferDTO;
import web.mvc.exception.MyException;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = MyException.class )
public class TransferServiceImpl implements TransferService {
	
	private final TransferDAO transferDAO;
	
	@Override
//	@Transactional(isolation = Isolation.DEFAULT, 
//	propagation = Propagation.REQUIRED, 
//	noRollbackFor = MyException.class)
	public int transfer(TransferDTO transferDTO) throws MyException {
		
		//����ϱ�
		int result = transferDAO.widthDraw(transferDTO);
		
		//�Ա��ϱ�
		int result2 = transferDAO.deposit(transferDTO);
		
		if(result==0 || result2==0)
		   //throw new RuntimeException("������ü �����ϼ̽��ϴ�.");
			throw new MyException("������ü �ȵſ�~~~");
		
		return result;
	}
	
//	@Transactional
	public void test() {
		
	}

}










