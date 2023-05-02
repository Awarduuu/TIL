package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	
	@RequestMapping("/{type}/{id}.do")
	public void test(@PathVariable String type, @PathVariable String id) {
		System.out.println("type = " + type);
		System.out.println("id = " + id);
	}
	
	@RequestMapping("{id}")
	public String test2() {
		
		return "result";
	}
	
	@RequestMapping("{kind}/{type}/{no}")
	public String test3(@PathVariable String kind,
			@PathVariable int no,
			@PathVariable String type) {
		
		return "result";
	}
}
