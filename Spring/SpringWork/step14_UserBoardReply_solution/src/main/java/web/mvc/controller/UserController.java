package web.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import web.mvc.domain.User;
import web.mvc.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor //final 기반으로 주입해주는 거임
public class UserController {
	
	private final UserService userService;

	/**
	 * 로그인 폼
	 * */
	@RequestMapping("/login")
	public void login() {}
	
	/**
	 * 로그인하기
	 * */
	@RequestMapping("/loginCheck")
	public String loginCheck(User user ,HttpSession session) {
		//서비스호출 하고 성공하면 리턴한 User를 받아서  
		User dbUser = userService.loginCheck(user);
		
		//HttpSession에 정보를 저장한다. - 뷰에서 사용하고 있음 ${loginUser}- 아이디 / ${loginName} - 이름
		session.setAttribute("loginUser", dbUser.getUserId());
		session.setAttribute("loginName", dbUser.getPwd());
		
		return "redirect:/";
	}
	
	/**
	 * 로그아웃
	 * */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		//모든 세션의 정보를 삭제한다.
		session.invalidate();

		return "redirect:/";
	}
	
}










