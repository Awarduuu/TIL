package web.mvc.dao;

import web.mvc.dto.UserDto;

public interface LoginDao {
	public UserDto login(String email);
}
