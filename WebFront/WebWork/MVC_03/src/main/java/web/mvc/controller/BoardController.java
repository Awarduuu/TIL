package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �Խ��Ǻ���
	 * */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          System.out.println("BoardController�� list call......");
		
		request.setAttribute("message", "�Խù� ��üLIST .");
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/list.jsp");
		
		return mv;
	}
	
	/**
	 * �󼼺��� 
	 * */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController read call......");
		
		
		return new ModelAndView("board/read.jsp", true);
	}

}
