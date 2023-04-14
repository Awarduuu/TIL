package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet {

	public ServletLifeCycle() {
		System.out.println("ServletLifeCycle 생성자...");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletLifeCycle init call...");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//브라우저의 문서 타입 + 한글 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("ServletLifeCycle doGet call...");
		
		//브라우저에 출력
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Servlet연습</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red'>Servlet 첫 수업!!</h1>");
		out.println("불금이 다가온다...");
		out.println("<br>할게 없다...!");
		out.println("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletLifeCycle doPost call...");
	}

//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("ServletLifeCycle service call...");
//	}

	@Override
	public void destroy() {
		System.out.println("ServletLifeCycle destroy call...");
	}

	
	
}
