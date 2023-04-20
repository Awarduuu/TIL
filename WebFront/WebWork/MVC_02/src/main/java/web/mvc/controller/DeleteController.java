package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ϱ��....
		
	    System.out.println("DeleteController ȣ��Ǿ����ϴ�....");
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("deleteResult.jsp");
	    mv.setRedirect(true);
	    
		
		return mv;
	}

}
