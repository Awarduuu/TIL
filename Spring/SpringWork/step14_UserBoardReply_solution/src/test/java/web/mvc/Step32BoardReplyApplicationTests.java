package web.mvc;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import web.mvc.domain.FreeBoard;
import web.mvc.domain.User;
import web.mvc.repository.FreeBoardRepository;
import web.mvc.repository.UserRepository;

@SpringBootTest
@Commit
@Transactional
class Step32BoardReplyApplicationTests {
	
	@Autowired
	private FreeBoardRepository freeRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Test
	public void aa() {
		System.out.println("freeRep = " + freeRep);
	}

	@Test
	void contextLoads() {
		//freeboard에 100개 정도 레코드 추가..
		
		for(int i=1; i<=37; i++) {
		  freeRep.save(
				   FreeBoard.builder()
				  .subject("제목"+i)
				  .writer("User"+i)
				  .content("FreeBoard Test "+i)
				  .password("1234")
				  .readnum(0)
				  .build()
				  );
		}
	}
	
	
	@Test
	void userInsert() {
		//freeboard에 100개 정도 레코드 추가..
		userRep.save(new User("jang", "1234", "장희정"));
		userRep.save(new User("hyun", "1234", "이가현"));
		userRep.save(new User("chan", "1234", "이찬범"));
		
	}

}






