package  web.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.mvc.dao.LoginDao;
import web.mvc.dao.LoginDaoImpl;
import web.mvc.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
    private LoginDao loginDao;

	@Override
	public UserDto login(String email, String password) {
		UserDto userDto = loginDao.login(email);
		System.out.println("userDto = " + userDto);
		if(userDto!=null) {
			if(userDto.getPassword().equals(password)) {
				return userDto;
			}else {
				return null;
			}
		}
		
		
		return userDto;
	}
}

