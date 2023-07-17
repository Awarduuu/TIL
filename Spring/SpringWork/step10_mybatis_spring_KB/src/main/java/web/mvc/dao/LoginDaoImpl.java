package web.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.mvc.dto.UserDto;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	 public static final String NS="ns.sql.loginMapper.";
		
	 @Autowired
	 private SqlSession session;
		
	@Override
	public UserDto login(String email) {
		return session.selectOne(NS+"login", email);
	}

}
