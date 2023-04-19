package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.BannerService;
import service.BannerServiceImpl;

/**
 * Servlet implementation class BannerServlet
 */
@WebServlet(urlPatterns = "/banners", loadOnStartup = 1)
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static BannerService bannerService = BannerServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		json(request,response);
	}

	
	
	public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 호출 -> dao 호출 후 결과 받아서 ajax로 통신
		
		List<String> banners = bannerService.listBanner();
		
		// List<> 형태를 javaScript가 알 수 있는 json형태로 변환 -> 전용 lib로 구현
		Gson gson = new Gson();
		String jsonArr = gson.toJson(banners);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
	}
}
