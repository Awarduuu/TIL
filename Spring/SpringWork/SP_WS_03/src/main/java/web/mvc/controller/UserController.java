package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/registerForm")
	public ModelAndView goRegister() {
		return new ModelAndView("register");
	}
	
	@RequestMapping("/personal/personal")
	public ModelAndView goPersonal() {
		return new ModelAndView("personal/personal");
	}
}
