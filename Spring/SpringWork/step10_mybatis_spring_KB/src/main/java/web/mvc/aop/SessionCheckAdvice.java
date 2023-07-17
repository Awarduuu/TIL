package web.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *  personal/personal 로그인된 사용자만 접근가능하도록 체크
 *   : 만약 인증을 안했다면 오류페이지로 이동 할수 있도록한다. 
 * */

@Service // 생성
@Aspect
public class SessionCheckAdvice {
	public SessionCheckAdvice() {
		System.out.println("SessionCheckAdvice 생성됨......");
	}

	@Before("execution(public * web.mvc.controller.UserController.personal(..))")
	public void before(JoinPoint joinPoint) {
		//세션의 정보가 있는지 체크한다. 
		//HttpSession session=???
		
		Object [] params = joinPoint.getArgs();
		HttpSession session = (HttpSession)params[0];
		
		if(session ==null || session.getAttribute("userDto") == null) {
			throw new RuntimeException("로그인하고 이용해주세요.");
		}
		
	}
	///////////////////////////////////////////////////////////////////
	/**
	 *  Controller영역에서(joinPoint) 매개변수로 HttpSession을 전달하지 않고
	 *  Service or dao 영역에서 HttpServletRequest정보를 사용 할수 있도록 할수 있는 방법
	 *    : Spring에서 2.x 이상에서 부터 Service or dao 영역에서 HttpServletRequest를 사용할수 있도록
	 *      RequestContextHolder를 제공한다.
	 *  
	 * */
	/*@Before("execution(public * web.mvc.controller.UserController.personal(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("오니......?");
		//세션의 정보가 있는지 체크한다. 
		//HttpSession session=???
		RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes)requestAttr;
		HttpServletRequest request = sra.getRequest();
		
		HttpSession session = request.getSession();
		
		if(session ==null || session.getAttribute("userDto") == null) {
			throw new RuntimeException("로그인하고 이용해주세요.");
		}
		
	}*/
}



