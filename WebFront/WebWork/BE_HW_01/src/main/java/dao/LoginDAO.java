package dao;

import dto.UserDto;

public interface LoginDAO {
	UserDto login(String email);
}
