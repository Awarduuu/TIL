package service;

import dto.UserDto;

public interface UserService {
	int register(UserDto userDto);
	int changePassword(int userSeq, String password, String passwordNew);
}
