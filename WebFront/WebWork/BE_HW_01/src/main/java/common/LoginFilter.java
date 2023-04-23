package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/personal/*")
public class LoginFilter implements Filter {

    
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사전 처리
		HttpServletRequest req = (HttpServletRequest) request;
		ServletContext application = req.getServletContext();
		String contextPath = application.getContextPath();
		HttpSession session = req.getSession();
		
		if(session.getAttribute("user") == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(contextPath + "/login.jsp"); // 폼으로 이동
			return; // chain.doFilter가 실행되기 전에 함수 빠져 나와야한다!!!!
		}
		
		chain.doFilter(request, response); // 실제 타겟대상
		
		// 사후 처리
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
