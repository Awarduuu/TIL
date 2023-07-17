package web.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.mvc.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{
	 public static final String NS="ns.sql.userMapper.";
		
	 @Autowired
	 private SqlSession session;
	
	@Override
	public int register(UserDto userDto) {
		return session.insert(NS+"insert", userDto);
	}

	@Override
	public int confirmPassword(UserDto userDto) {
		return session.selectOne(NS+"selectCountByUserSeq", userDto);
	}

	@Override
	public int changePassword(int userSeq,  String newPass) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("userSeq", userSeq);
		map.put("newPass", newPass);
		return session.update(NS+"update", map); 
	}
}
