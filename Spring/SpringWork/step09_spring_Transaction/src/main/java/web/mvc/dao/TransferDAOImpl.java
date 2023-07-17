package web.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.TransferDTO;

@Repository
@RequiredArgsConstructor
public class TransferDAOImpl  implements TransferDAO{
	
	private final SqlSession session;

	@Override
	public int widthDraw(TransferDTO transferDTO) {
		return session.update("TransferMapper.withDraw", transferDTO);
	}

	@Override
	public int deposit(TransferDTO transferDTO) {
		return session.update("TransferMapper.deposit", transferDTO);
	}

}




