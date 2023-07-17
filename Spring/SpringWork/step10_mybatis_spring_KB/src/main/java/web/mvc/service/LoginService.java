package  web.mvc.service;

import web.mvc.dto.UserDto;

public interface LoginService {
	public UserDto login(String email, String password);
}
