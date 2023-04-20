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
		System.out.println("InsertController ȣ��Ǿ����ϴ�.....");
		
		//����� �Ϸ�� �Ŀ� ��ü�˻����ϴ� controller�� �����Ѵ�.
		ModelAndView mv = new ModelAndView("front?key=select", true);
		
		return mv;
	}

}
