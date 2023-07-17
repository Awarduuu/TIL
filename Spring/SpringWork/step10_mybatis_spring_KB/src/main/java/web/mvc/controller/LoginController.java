package web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.mvc.dto.UserDto;
import web.mvc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public void login() {}
	
	
	/**
	 * post방식으로 요청을 받아 ajax로 응답한다.(@PostMapping + @ResponseBody)
	 * */
	@PostMapping("/login")
	@ResponseBody
	public String login(String email, String pwd, HttpServletRequest request) {
		UserDto userDto = loginService.login(email, pwd);
		HttpSession session = request.getSession();
		session.setAttribute("userDto", userDto);
		if(userDto!=null) {
			return "success";
		}else {
			return "fail";
		}
	}
	/**
	 * 로그아웃기능을 만든다.
	 *  모든 세션의 정보를 제거한다.
	 * */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	
}
