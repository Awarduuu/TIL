package kb.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BloodCheckServlet
 */
@WebServlet(urlPatterns = "/bloodCheck", loadOnStartup = 1)	// @WebServlet("/bloodCheck")
public class BloodCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 방식으로 전송되는 한글 인코딩처리
		 request.setCharacterEncoding("UTF-8");	// filter로 대체
		 
//		 //HttpSession 사용
//		 HttpSession session = request.getSession();
//		 
//		 //ServletContext 사용
//		 ServletContext app = request.getServletContext();
		 
		
		
		 // 전송된 데이터 받기
		 String name = request.getParameter("name");
		 String blood = request.getParameter("blood");
				
		 System.out.println("name: " +  name);
		 System.out.println("blood: " + blood);
		 
		 // 혈액형에 따라 페이지 이동
		 // 1) forward 방식
		 // request.getRequestDispatcher("/" + blood + ".jsp").forward(request,  response);
		 	// 기존 request, response 유지 -> jsp 파일 안에서 확인 가능
		 	// 도착 주소 http://localhost:8000/step07_Servlet/bloodCheck 
		 	// url bloodCheck로 고정
		 
		 // 2) redirect 방식
		 response.sendRedirect(blood + ".jsp?name=" + URLEncoder.encode(name, "UTF-8") + "&blood=" + blood);	// 새로운 request, response 생성해서 이동
		 	// 도착 주소 http://localhost:8000/step07_Servlet/A.jsp
		 	// 주소에 jsp 추가
		 	// request, response 유지가 안 되기 때문에 url에 get방식으로 넘겨줌
		 
		 
		 
	 }
}
