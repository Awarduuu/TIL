package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *�α��α��
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserController �� login call........");
		
		
		request.setAttribute("message", "�α��� ��� �Ϸ��Դϴ�...");
		
		ModelAndView mv = new ModelAndView("user/login.jsp");
		
		return mv;
	}
	
	/**
	 * ȸ����������
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserController�� update call.......");
		
		
		return new ModelAndView("user/update.jsp", true);
	}
	
	/**
	 * �α׾ƿ����
	 * */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ȸ�����Ա��
	 * */
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
