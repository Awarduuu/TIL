package web.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping("/test.do")
	public ModelAndView home(Locale locale, Model model) {
		System.out.println("test.do 요청되었습니다...");
		
		return new ModelAndView("home"); // /WEB-INF/views/home.jsp 이동 
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(Locale locale, Model model) {
		System.out.println("login.do 요청되었습니다...");
		
		return new ModelAndView("login"); // /WEB-INF/views/login.jsp 이동 
	}
	
}
