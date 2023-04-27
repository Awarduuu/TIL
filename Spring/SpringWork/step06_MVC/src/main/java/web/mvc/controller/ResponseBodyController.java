package web.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//@Controller and @ResponseBody -> ajax 전용 controller
// return이 모두 브라우저로 전송 (view x)
public class ResponseBodyController {
	
	@RequestMapping("/responseBody.do")
	public String aa() {
		System.out.println("responseBody.do 요청입니다...");
		return "Have a nice day!";
	}
	
	@RequestMapping(value = "/responseBody2.do", produces = "text/html;charset=UTF-8")
	public String bb() {
		System.out.println("responseBody2.do 요청입니다...");
		return "오늘도 수고 많으셨어요^^";
	}
}
