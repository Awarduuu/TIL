package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import dto.UserDto;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		
		switch(job) {
			case "register" : register(request, response); break;
			
		}
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 가입
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		// 하나의 DTO객체로 만든다.
		UserDto user = new UserDto(0, name, email, phone, false, password);
		
		UserService service = UserServiceImpl.getInstance();
		int result = service.register(user);
		
		response.getWriter().print(result);
		
		
		
	}

}
