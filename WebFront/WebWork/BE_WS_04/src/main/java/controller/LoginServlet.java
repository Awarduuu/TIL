package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.UserDto;
import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/login", "/logout" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		LoginService service = new LoginServiceImpl();
		UserDto user = service.login(email, password);
		String result;
		HttpSession session = request.getSession();
		
		if(user != null) {
			result="success";
			session.setAttribute("user", user);
		}else {
			result="fail";
		}
		
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		obj.addProperty("result", result);
		String jsonArr = gson.toJson(obj);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
	}

}
