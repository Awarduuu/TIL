package sample07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // id="boardServiceImpl"
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardMyBatisDAOImpl;
	
	@Autowired //byType -> byName
	@Qualifier("oracleDAO")
	private BoardDAO boardOracleDAOImpl;

	@Override
	public void select() {
		boardOracleDAOImpl.select();
		System.out.println("------------------");
		boardMyBatisDAOImpl.select();
	}

}
