package service;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.UserDto;

public class UserServiceImpl implements UserService{

	private static UserService instance = new UserServiceImpl();
	
	private UserServiceImpl() {}
	
	public static UserService getInstance() {
		return instance;
	}
	
	UserDao userDao = UserDaoImpl.getInstance();
	
	@Override
	public int register(UserDto userDto) {
		return userDao.register(userDto);
	}

	@Override
	public int changePassword(int userSeq, String password, String passwordNew) {
		if(userDao.confirmPassword(userSeq, password)) return userDao.changePassword(userSeq, passwordNew);
		return 0;
	}

}
