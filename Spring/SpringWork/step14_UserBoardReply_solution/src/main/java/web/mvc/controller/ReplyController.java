package web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.mvc.domain.FreeBoard;
import web.mvc.domain.Reply;
import web.mvc.service.FreeBoardService;
import web.mvc.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired //주입
   private ReplyService replyService;
  
	@Autowired
	private FreeBoardService boardService;
   
  /**
   * 댓글 등록품
   * */
	@RequestMapping("/writeForm")
	public String writeForm(Long bno, Model model) {
		model.addAttribute("bno", bno); //뷰쪽으로 bno 전달한다
		return "reply/write";
	}
	
	/**
	 * 등록하기
	 *  : 게시물 등록 완료후 board/read.jsp으로 이동한다. 
	 * */
	@RequestMapping("/insert")
	public String insert(Reply r, Long bno) {
		
		r.setFreeBoard(new FreeBoard(bno));
		replyService.insert(r);
		
		return "redirect:/board/read/"+bno+"?flag=false"; // flag -> false 해야 조회수 안올라 감
	}
	
	
	
	
	
	/**
	 * 삭제하기
	 *  : 
	 * */
	@RequestMapping("/delete/{rno}/{bno}")
	public String delete(@PathVariable Long rno , @PathVariable Long bno) {
		replyService.delete(rno);
		
		return "redirect:/board/read/"+bno+"?flag=1";
	}

}














