package  web.mvc.service;

import web.mvc.dto.UserDto;

public interface UserService {
	int register(UserDto userDto);
	
	int changePassword(UserDto userDto, String passwordNew);
}
