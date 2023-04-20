package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		//service call -> dao...
		
		System.out.println("SelectController call....");
        request.setAttribute("message", "검색된 결과입니다."); //뷰에서 이렇게 쓰면 됨! => ${message}
		
		ModelAndView mv = new ModelAndView("selectResult.jsp");
        
		return mv;
	}

}
