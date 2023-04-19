package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet(urlPatterns = { "/login", "/logout" }, loadOnStartup = 1,
	initParams = {
			@WebInitParam(name = "id", value = "jang"),
			@WebInitParam(name = "pwd", value = "1234"),
	}
		)
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String dbId, dbPwd;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dbId = config.getInitParameter("id");
		dbPwd = config.getInitParameter("pwd");
		
		
	}
	
	/**
	 * 로그인
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("test/html;charset=UTF-8");
		System.out.println("?");
		
		// 전송되는 데이터 3개 받기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		// NullPointerError 방지 위해 기준값을 dbId로 설정하는 것이 좋음
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			// 성공했으니 정보 저장하고 이동
			Customer customer = new Customer(userName, 20, "선릉역", "111-2222");
			
			// 저장
			request.setAttribute("cu", customer);	// request 유지되는 동안 사용 가능
			
			// customer 가지고 이동
			request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
		} else {
			// 실패했으니 오류메시지 출력 폼으로 이동
//			PrintWriter out = response.getWriter();
//			out.print("<script>");
//			out.println("alert('정보를 다시 확인해주세요. ');");
//			out.print("location.href=`LoginForm.html`");
//			out.println("history.back();");
//			out.print("</script>");
			
			// response.sendRedirect("LoginForm.html");
			
			/////////////// error.jsp 이동시키기 ///////////////////////
			request.setAttribute("errMsg", "로그인 정보를 확인해주세요.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}// elseEnd
	}
	
	/**
	 * 로그아웃
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout");
		
	}

	

}
