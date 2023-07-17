package web.mvc.dao;

import web.mvc.dto.UserDto;

public interface UserDao {
	int register(UserDto userDto);
	
	int confirmPassword(UserDto userDto);
	int changePassword(int userSeq,  String newPass);
}
