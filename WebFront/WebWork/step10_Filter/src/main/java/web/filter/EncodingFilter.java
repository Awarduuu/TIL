package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter(urlPatterns = {"/*"})
//@WebFilter(urlPatterns = {"/*.jsp"})
@WebFilter(urlPatterns = {"/user/*", "/admin/*"})
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    	System.out.println("EncodingFilter constructor call...");
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Encoding init call...");
	}
	
    public void destroy() {
		System.out.println("Encoding destroy call...");
	}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("사전처리 입니다...");
		
		// 인증된 사용자인지를 체크하고 싶다!!! -> HttpSession에 저장된 정보가 있는지 체크
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if(session.getAttribute("??") == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("로그인 폼으로 이동");
			return;
		}
		
		request.setCharacterEncoding("UTF-8"); // post 방식 한글 인코딩
		
		chain.doFilter(request, response);
		
		System.out.println("사후처리 입니다...");
	}

}
