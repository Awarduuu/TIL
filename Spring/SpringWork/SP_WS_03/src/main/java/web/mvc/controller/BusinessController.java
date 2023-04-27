package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusinessController {
	
	@RequestMapping("/business")
	public ModelAndView goBusiness() {
		return new ModelAndView("business");
	}
}
