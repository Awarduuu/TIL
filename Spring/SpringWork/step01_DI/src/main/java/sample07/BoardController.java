package sample07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class BoardController {
	
	@Autowired //byType
	private BoardService boardService;
	@Autowired
	private BoardDTO boardDTO1;
	@Autowired
	private BoardDTO boardDTO2;
	
	void test() {
		System.out.println("boardDTO1 = " + boardDTO1 + ", subject = " + boardDTO1.getSubject());
		System.out.println("boardDTO2 = " + boardDTO2 + ", subject = " + boardDTO2.getSubject());
		
		System.out.println("boardService = " + boardService);
		boardService.select();
	}
}
