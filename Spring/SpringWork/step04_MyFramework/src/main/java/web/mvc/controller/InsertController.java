package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ϱ�
		System.out.println("InsertController �Դϴ�. ");
		
		return new ModelAndView("index.jsp", true);//rediect������� �̵��ض�.
	}

}
