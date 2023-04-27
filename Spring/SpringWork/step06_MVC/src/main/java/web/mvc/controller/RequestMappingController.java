package web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem")
public class RequestMappingController {

	@RequestMapping("/a.do")
	public ModelAndView aa() {
		System.out.println("a.do 요청되었습니다...");
		
		// 뷰 쪽으로 전달될 정보(Model) + 뷰 이름 
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Spring 재미있다."); // 뷰에 전달될 정보 -> ${requestScope.message}
		mv.setViewName("result"); // prefix + 뷰이름 + suffix -> /WEB-INF/views/result.jsp 이동 
		return mv;
	}
	
	/**
	 * 여러개의 요청이 하나의 메소드를 호출
	 * @return : String인 경우는 리턴 값이 뷰이름 
	 */
	@RequestMapping(value= {"/b.do", "/c.do"})
	public String aaaa() {
		System.out.println("b.do 또는 c.d 요청되었습니다...");
		return "result";
	}
	
	/**
	 * @return : void인 경우 요청된 주소가 뷰의 이름이 된다. ex) rem/test.do이면 rem/test가 뷰이름 된다. /WEB-INF/views/rem/test.jsp 이동 
	 */
	/*@RequestMapping("/test.do")
	public void test() {
		System.out.println("test.do 요청되었습니다...");
		
	}*/
	@GetMapping("/test.do")
	public void bb(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println(name + " = get -> test.do 요청되었습니다...");
		
	}
	
	@PostMapping("/test.do")
	public void cc(String name) {
		System.out.println(name + " = post -> test.do 요청되었습니다...");
		
	}
}
