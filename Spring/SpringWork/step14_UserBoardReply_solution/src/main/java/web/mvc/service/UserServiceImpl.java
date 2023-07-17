package web.mvc.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;
import web.mvc.domain.User;
import web.mvc.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;
	

	@Override
	public User loginCheck(User user) {
		//아이디에 해당하는 회원정보를 조회한다.
		User dbUser = userRep.findById(user.getUserId()).orElse(null);
		
		//조회된 결과가 null이면 throw new RuntimeException("존재하지 않는 ID로 로그인할수 없습니다.");
		if(dbUser == null) {
			throw new RuntimeException("존재하지 않는 ID로 로그인할 수없습니다.");
		}
		//조회된결과가 있으면 비밀번호 일치확인 후 틀리면 throw new RuntimeException("비밀번호를 다시 확인해주세요.");
		if(!dbUser.getPwd().equals(user.getPwd())) {
			throw new RuntimeException("비밀번호를 다시 확인해주세요.");
		}
		
		
		//일치하면 조회된 회원정보 리턴
		return dbUser;
	}

}
