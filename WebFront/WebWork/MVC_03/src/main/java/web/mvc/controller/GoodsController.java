package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
   
	 /**
	  * ��ǰ���� ���
	  * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController�� select call......");
		
		request.setAttribute("message", "��ǰ�󼼺��� ����Դϴ�...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("goods/list.jsp");
		
		return mv;
	}
	
	/**
	 * ��ǰ��ϱ��
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController�� insert call...");
		
		//����� ��� ---> service -> dao
		
		return new ModelAndView("goods/registerOk.jsp");
	}
}
