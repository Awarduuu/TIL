package web.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.mvc.dao.UserDao;
import web.mvc.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
   @Autowired
   private UserDao userDao;
	
	@Override
	public int register(UserDto userDto) {
		return userDao.register(userDto);
	}
	
	@Override
	public int changePassword(UserDto userDto, String passwordNew) {
	
		if( userDao.confirmPassword(userDto) > 0) {
			return userDao.changePassword(userDto.getUserSeq() , passwordNew);
		}
		return 0;
	}


}
