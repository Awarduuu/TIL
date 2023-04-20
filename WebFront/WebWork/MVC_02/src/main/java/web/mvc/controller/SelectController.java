package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  //���۵� �����͸� request �ޱ�
		
		//service ȣ�� -> �װ���� �޾Ƽ� scope�� �����ϰ� �̵��Ѵ�. 
		
		System.out.println("SelectController��  ȣ��Ǿ����ϴ�....");
        request.setAttribute("message", "��ü�˻� ����Դϴ�."); //${message}
		
		ModelAndView mv = new ModelAndView("selectResult.jsp");
        
		return mv;
	}

}
