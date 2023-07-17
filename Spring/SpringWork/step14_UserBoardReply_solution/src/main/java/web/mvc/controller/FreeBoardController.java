package web.mvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;


import web.mvc.domain.FreeBoard;
import web.mvc.service.FreeBoardService;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeService;
	
	private final static int PAGE_COUNT=5; //게시글이 한 페이지에 5개로..!
	private final static int BLOCK_COUNT=3; // 몇 개씩 끊을거냐?!
	
	/**
	 * 전체 검색 페이지
	 * */
	@RequestMapping("/list")
	public void list(Model model, @RequestParam(defaultValue = "1") int nowPage) { //@RequestParam(defaultValue = "1") 처음엔 디폴트로 1페이지 주는 것
		//service -> dao
		/*List<FreeBoard> freeBoardList =freeService.selectAll();
		model.addAttribute("freeList", freeBoardList);*/
		
		//////페이징처리////////////////////////
		Pageable page = PageRequest.of((nowPage-1), PAGE_COUNT , Direction.DESC, "bno"); //nowPage-1하는 이유는 내부적으로는 0부터 시작하므로
	   Page<FreeBoard> pageList =  freeService.selectAll(page);
	   
	   int temp = (nowPage-1)%BLOCK_COUNT;
	   int startPage=nowPage-temp;
	   
	   model.addAttribute("pageList", pageList);
	   
	   model.addAttribute("blockCount", BLOCK_COUNT);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("nowPage", nowPage);
		
	}
	
	/**
	 * 등록폼
	 * */
	@RequestMapping("/write")
	public void write() {}
	
	/**
	 * 게시물 등록하기 
	 *  : 등록완료 후에 /board/list를 요청한다.
	 * */
	@RequestMapping("/insert")
	public String insert(FreeBoard freeBoard) {
		freeService.insert(freeBoard);
		
		return "redirect:/board/list";
	}
	
	
	/**
	 * 상세보기
	 *   : 조회수를 증가한후 글번호에 해당하는 정보를 조회한다.
	 *   : 조회된 정보를 가지고 board/read.jsp이동한다.
	 * */
	@RequestMapping("/read/{bno}")
	public ModelAndView read(@PathVariable Long bno , String flag) {
		boolean state = flag==null ? true : false;
		
		//서비스 호출...
		FreeBoard freeboard= freeService.selectBy(bno, state);
		
		return new ModelAndView("board/read", "board", freeboard);
	}
	
	/**
	 * 수정폼
	 *   : 수정폼으로 이동전에 수정하기위한 게시물의 정보를 조회하여(조회수를 증가하지 않는다)
	 *      board/update.jsp이동한다. 
	 * */
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(Long bno) {
		 //서비스호출
		
		FreeBoard freeboard= freeService.selectBy(bno, false);
		
		return new ModelAndView("board/update", "board", freeboard);
	}
	
	/**
	 * 수정완료하기
	 *  : 수정완료후에 board/read.jsp로 이동한다. 
	 * */
	@RequestMapping("/update")
    public ModelAndView update(FreeBoard board) {
		//서비스호출
		FreeBoard freeboard = freeService.update(board);
		return new ModelAndView("board/read", "board", freeboard);
	}
	
	/**
	 * 삭제하기
	 *   : 삭제완료후에 board/list를 요청한다. 
	 * */
	@RequestMapping("/delete")
    public String delete(Long bno , String password) {
		 //서비스호출
		freeService.delete(bno, password);
		return "redirect:/board/list";
	}
}














