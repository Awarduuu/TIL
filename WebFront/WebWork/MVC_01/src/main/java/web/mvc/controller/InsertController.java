package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		System.out.println("InsertController call.....");
		
		// 이동방식과 주소를 설정
		ModelAndView mv = new ModelAndView("front?key=select", true); // controller -> controller 이동
		
		return mv;
	}

}
