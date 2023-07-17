package web.mvc;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import web.mvc.domain.Board;
import web.mvc.repository.BoardRepository;

@SpringBootTest
@Transactional
@Commit
class BoardRepTest {
	
	@Autowired
	private BoardRepository boardRep;

	@Test
	void contextLoads() {
		System.out.println("boardRep = " + boardRep);
	}
	
	/**
	 * 게시물 등록
	 */
	@Test
	public void insert() {
		for(int i=1; i<=200; i++) {
			boardRep.save(Board.builder()
					.title("제목"+i).writer("User"+i).content("내용"+i).build());
			
		}
	}
	
	/**
	 * 전체 검색
	 */
	@Test
	public void selectAll() {
		List<Board> list = boardRep.findAll();
		list.forEach(b->System.out.println(b));
	}
	
	/**
	 * pk로 검색 
	 */
	@Test
	public void selectByBno() {
		//Optional은 java.util에 추가된 객체로 null 여부를 체크하지 않아도 되도록
		//관련된 메소드를 풍부하게 제공한다.
		Board board = boardRep.findById(210L).orElse(null);
		System.out.println("board = " + board);
	}
	
	/**
	 * 수정하기
	 */
	@Test
	public void update() {
		Board board = boardRep.findById(50L).orElse(null);
		board.setTitle("프로젝트");
		board.setWriter("윤상우");
	}
	
	/**
	 * 삭제하기
	 */
	@Test
	public void delete() {
//		boardRep.deleteById(50L);
		
		Board board = boardRep.findById(30L).orElse(null);
		
		boardRep.delete(board);
	}
	
	/**
	 * 인수로 전달된 글번호보다 큰 레코드를 삭제하고 싶다.
	 */
	@Test
	public void deleteGraterThan() {
		boardRep.deleteGraterThan(150L);
	}
	
	/**
	 * 글번호 또는 제목에 해당하는 레코드 검색
	 */
	
	@Test
	public void selectByBnoTitle() {
		List<Board> list = boardRep.selectByBnoTitle(130L, "제목5");
		
		list.forEach(b->System.out.println(b));
	}
	
	@Test
	public void selectByParamsBoard() {
		List<Board> list = boardRep.selectByParamsBoard(Board.builder().bno(30L).title("제목1").writer("User5").build());
		list.forEach(b->System.out.println(b));
	}
	

}
