package web.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  ������� ��� ��û�� ó���� ������ Controller�̴�(FrontController�� �����Ѵ�)
 */
@WebServlet(urlPatterns = "/front" , loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map = new HashMap<String, Controller>();
	@Override
	public void init(ServletConfig config) throws ServletException {

        //~.properties파일 로딩
       ResourceBundle rb = ResourceBundle.getBundle("actionMapping");
  
        try {
	        for(String key : rb.keySet()) {
	        	String value = rb.getString(key);
	        	//System.out.println(key +" = " + value );
	        	
	        	//String의 문자열을 Controller의 객체로 생성해야한다!!!
	        	//Class<?>는 어떤 객체가 가지고 있는 필드, 생성자, 메소드의 정보를 동적으로 가져올수 있도록 도와주는 객체이다 - reflection 개념
	    		//reflection 개념은 동적으로 즉 실행도중에 필요한 객체를 적절하게 생성하고 그 객체가 가지고 있는 생성자나 메소드를 
	    		//동적으로 호출해줄수 있도록 하는 개념을 reflection이라고 하고 자바에서 이 개념을 적용해 놓은 API가 Class<?> 이다.
	
	        	Class<?> className = Class.forName(value);
	        	Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
	        	
	        	System.out.println("controller = " + controller);
	        	
	        	map.put(key, controller);  	
	        }
        }catch (Exception ex) {
			ex.printStackTrace();
		}
       
	}
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		System.out.println("key = " + key);
		
		Controller controller = map.get(key);
		ModelAndView mv = controller.handleRequest(request, response);
		
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
		
		
	}//service �޼ҵ� �� 

}









