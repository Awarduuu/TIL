package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HobbyCheckServlet extends HttpServlet {
	public HobbyCheckServlet() {
		System.out.println("HobbyCheckServlet constructor call...");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//post방식으로 전송되는 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
//		String hobby = request.getParameter("hobby");
		
		//하나의 이름으로 값이 여러개 전송될때
		String [] hobbys = request.getParameterValues("hobby");
		
		// 브라우저에 출력
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Servlet연습</title></head>");
		out.println("<body>");
		out.println("<h3> 이름 : "+name+ " </h3>");
		out.println("<h3> 나이 : "+age+ " </h3>");
		out.println("<h3> 취미 : ");
		
		for(String h : hobbys) {
			out.print(h+", ");
		}
		out.println("</h3>");
		
		out.println("</body>");
		out.print("</html>");
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("doGet call...");
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("doPost call...");
//	}
}
