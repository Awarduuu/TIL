package service;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.UserDto;

public class LoginServiceImpl implements LoginService {

	@Override
	public UserDto login(String email, String password) {
		LoginDAO dao = new LoginDAOImpl();
		
		UserDto user = dao.login(email);
		
		if(password.equals(user.getPassword())) {
			password = null;
			return user;
		}
		
		return null;
	}

}
