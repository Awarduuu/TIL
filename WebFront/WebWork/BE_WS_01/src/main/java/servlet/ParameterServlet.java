package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParameterServlet extends HttpServlet {
	
	private long serialVersionID = 1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String job = req.getParameter("job");
		String pageNo = req.getParameter("pageNo");
		String searchWord = req.getParameter("searchWord");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<h1> job : " + job + "</h1>");
		out.println("<h1> pageNo : " + pageNo + "</h1>");
		out.println("<h1> searchWord : " + searchWord + "</h1>");
		
		System.out.println("job : " + job);
		System.out.println("pageNo : " + pageNo);
		System.out.println("searchWord : " + searchWord);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String [] hobbys = req.getParameterValues("hobby");
		String favorite = req.getParameter("favorite");
		String desc = req.getParameter("desc");
		

		
		out.println("<h1> name : " + name + "</h1>");
		out.println("<h1> email : " + email + "</h1>");
		out.println("<h1> gender : " + gender + "</h1>");
		out.print("<h1> hobby : ");
		for(int i=0; i<hobbys.length; i++) {
			
			if(i != hobbys.length -1) {
				out.print(hobbys[i] + ", ");
			}else {
				out.print(hobbys[i]);
			}
			
		}
		out.println("</h1>");
		out.println("<h1> favorite : " + favorite + "</h1>");
		out.println("<h1> desc : " + desc + "</h1>");
		


		
	}

	
}
