package sample07;

import org.springframework.stereotype.Repository;

@Repository("oracleDAO") //id="oracleDAO"
public class BoardOracleDAOImpl implements BoardDAO {
	
	@Override
	public void select() {
		System.out.println("BoardOracleDAOImpl");
	}

}
