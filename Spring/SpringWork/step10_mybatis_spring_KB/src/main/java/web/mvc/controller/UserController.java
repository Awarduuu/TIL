package web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.mvc.dto.UserDto;
import web.mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/registerForm")
	public String registerForm() {
		
		return "register";
	}
	
	
	@RequestMapping("/personal/personal")
	public void personal(HttpSession session) {
		
	}
	
	/**
	 * 회원가입(가입 성공여부를 int로 응답한다) - ajax처리 
	 * */
	@RequestMapping("/register")
	@ResponseBody
	public int register(UserDto userDto) {
		return userService.register(userDto);
	}
	
	/**
	 * 비밀번호 변경의 결과를 int로 응답힌다. - ajax처리
	 * */
	@RequestMapping("/changePassword")
	@ResponseBody
	public int changePassword(HttpServletRequest request, String password, String passwordNew) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		return userService.changePassword(new UserDto(userDto.getUserSeq(), password), passwordNew);
	}
	
}
