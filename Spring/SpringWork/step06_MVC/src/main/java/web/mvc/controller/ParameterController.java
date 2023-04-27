package web.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/param")
public class ParameterController {
	
	/*@RequestMapping("/a.do")
	public String aa(String name, int age) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		
		return "result";
	}*/
	
	@RequestMapping("/a.do")
	public String aa(String name, Integer age) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		
		return "result";
	}
	/**
	 * void는 요청주소가 뷰 이름이 된다.
	 *  /WEB-INF/views/param/b.jsp
	 */
	@RequestMapping("/b.do")
	public void bb(@RequestParam(defaultValue = "guest") String id, @RequestParam(defaultValue = "0") int age) {
		System.out.println("id = " + id);
		System.out.println("age = " + age);
	}
	
	@RequestMapping("/c.do")
	public String cc(@RequestParam(value = "userId") String id) {
		System.out.println("id = " + id);
		return "result";
	}
	
	/**
	 * 인수로 객체타입(DTO)를 받으면
	 * 전달된 객체가 뷰쪽으로 전달된다.
	 * 뷰에서 표현언어를 이용하여 사용할 수 있다.
	 * 객체이름의 첫글자만 소문자로 접근 
	 * ex) ${memberDTO.속성}
	 * 
	 */
	// @ModelAttribute
	// 1) 인수 : 뷰쪽으로 전달되는 객체의 별칭 만들기
	// 2) 메소드 : 현재 컨트롤러를 실행하는 모든 요청들이 공유해서 사용한 정보를 뷰에 전달
	@RequestMapping("/user.do")
	public ModelAndView user(@ModelAttribute("dto") MemberDTO dto) {
		System.out.println(dto);
		return new ModelAndView("ok");
	}
	
	@ModelAttribute("hobbys")
	public List<String> hobbys(){
		return Arrays.asList("골프", "낚시", "수영", "놀기");
	}
	
	@ModelAttribute("info")
	public String info(){
		return "Spring study";
	}
}//클래스 끝
