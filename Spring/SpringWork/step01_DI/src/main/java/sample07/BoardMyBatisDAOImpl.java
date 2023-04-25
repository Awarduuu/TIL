package sample07;

import org.springframework.stereotype.Repository;

//xml에서 <bean class="BoardMyBatisDAOImpl" id="??"/>
@Repository //기본 id는 클래스이름의 첫글자만 소문자, 나머지는 동일 = boardMyBatisDAOImpl 
public class BoardMyBatisDAOImpl implements BoardDAO {

	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl");
	}

}
