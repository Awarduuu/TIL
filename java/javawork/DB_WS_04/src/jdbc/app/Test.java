package jdbc.app;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dao.UserDAOimpl;
import jdbc.dto.UserDto;

public class Test {
	static UserDAOimpl userDAOimpl = new UserDAOimpl();
	public static void main(String[] args) {
		
       
			// #1. users table 에 insert 1건 처리를 위해 insert() 를 완성한다.
//			insert();
			
			// #2. users table 에 update 1건 처리를 위해 update() 를 완성한다.
//			update();
		
			// #3. users table 을 전체 조회, 출력하는 selectAll() 를 완성한다.
			selectAll();
			
			// #4. users table 을 user_seq 로 1건  조회, 출력하는 selectOne() 를 완성한다.
//			selectOne();
			
			// #5. users table 을 user_seq 로 1건  삭제하는 delete() 를 완성한다.
//			delete();
		
	}
	
	static void insert() {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("six@gildong@com");
		userDto.setPhone("010-6666-6666");
		userDto.setSleep(false);
		
	//  dao호출하고 그결과에 따라 출력한다.
		
		if(userDAOimpl.insert(userDto)>0) {
			System.out.println("******* 입력 ********");
			System.out.println(userDto);
		}
	}
	
	static void update() {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("yook@gildong@com");
		userDto.setPhone("010-7777-7777");
		userDto.setSleep(true);

	//  dao호출하고 그결과에 따라 출력한다.
		if(userDAOimpl.update(userDto)>0) {
			System.out.println("******* 수정 ********");
			System.out.println(userDto);
		}
		
	}
	
	static void selectAll() {
		
	//  dao호출하고 그결과에 따라 출력한다.
		List<UserDto> list = userDAOimpl.selectAll();
		System.out.println("******* 전체 조회 ********");
		for(UserDto user : list) {
			System.out.println(user);
		}
	}
	
	static void selectOne() {
		int userSeq = 666;
		
	//  dao호출하고 그결과에 따라 출력한다.
		UserDto user = userDAOimpl.selectOne(userSeq);
		if(userDAOimpl.selectOne(userSeq) != null) {
			System.out.println("******* " + userSeq + " 데이터 조회 ********");
			System.out.println(user);
		};
		
	}
	
	static void delete() {	
		int userSeq = 666;
	//  dao호출하고 그결과에 따라 출력한다.
		UserDAOimpl userDAOimpl = new UserDAOimpl();
		if(userDAOimpl.delete(userSeq)>0) {
			System.out.println("******* " + userSeq + " 데이터 삭제 ********");
		}
	}
}


