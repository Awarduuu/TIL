package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.dao.MemberDAO;
import web.dao.MemberDAOImpl;
import web.dto.Member;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet(urlPatterns = "/ajaxTest", loadOnStartup = 1)
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String key = request.getParameter("key");
		
		if(key.equals("text")) {
			text(request, response);
		}else if(key.equals("json")) {
			json(request, response);
		}else if(key.equals("dto")) {
			dto(request, response);
		}else if(key.equals("list")) {
			list(request, response);
		}else if(key.equals("map")) {
			map(request, response);
		}else if(key.equals("textJson")) {
			textJson(request, response);
		}
	} // 메소드 끝
	
	/**
	 *  ajax String 리턴
	 */
	public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.print("Welcome to " + name + "님!!!");
		
	
	}
	
	/**
	 * ajax json 리턴
	 */
	public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 호출 -> dao 호출 후 결과 받아서 ajax로 통신
		List<String> menu = Arrays.asList("짜장면", "짬뽕", "탕수육", "깐쇼새우");
		
		// List<> 형태를 javaScript가 알 수 있는 json형태로 변환 -> 전용 lib로 구현
		Gson gson = new Gson();
		String jsonArr = gson.toJson(menu);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
	}
	
	/**
	 * ajax dto 리턴
	 */
	public void dto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member("awarduuu", "윤상우", 26, "서울시 관악구");
		
		// member객체를 json 변환해서 이동
		Gson gson = new Gson();
		String jsonArr = gson.toJson(member);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
	}
	
	/**
	 * ajax list 리턴
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Member> memberList = new ArrayList<>();
//		
//		memberList.add(new Member("awarduuu", "윤상우", 26, "서울시 관악구"));
//		memberList.add(new Member("jjjune", "박용준", 26, "광주시 서구"));
//		memberList.add(new Member("wooseung", "우승", 26, "수원시 구구"));
		
		MemberDAO dao = new MemberDAOImpl();
		List<Member> memberList = dao.selectAll();
		
		// list를 json 변환해서 이동
		Gson gson = new Gson();
		String jsonArr = gson.toJson(memberList);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
		
	}
	
	/**
	 * ajax map 리턴
	 */
	public void map(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Ajax 재밌다!");
		map.put("pageNo", 10);
		map.put("dto", new Member("awarduuu", "윤상우", 26, "서울시 관악구"));
		
		List<Member> memberList = new ArrayList<>();
		memberList.add(new Member("awarduuu", "윤상우", 26, "서울시 관악구"));
		memberList.add(new Member("jjjune", "박용준", 26, "광주시 서구"));
		memberList.add(new Member("wooseung", "우승", 26, "수원시 구구"));
		map.put("memberList", memberList);
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(map);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
		
		
	}
	
	/**
	 * ajax textJson 리턴
	 */
	public void textJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("addr = " + addr);
		
		//BL 완료한 후 그 성공여부에 따라 결과 메세지를 json형태로 전송
		JsonObject obj = new JsonObject();
		if(name.equals("얼짱")) {
			obj.addProperty("info", "success");	
		}else {
			obj.addProperty("info", "fail");
		}
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(obj);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
	
}
