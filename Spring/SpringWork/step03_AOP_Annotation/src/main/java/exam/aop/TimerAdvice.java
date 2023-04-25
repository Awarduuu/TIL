package exam.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * 공통의 기능 : around방식(사전, 사후 처리)
 * 	사전 : 현재 시간을 구한다.
 *  사후 : 현재 시간을 구해서 사전의 시간과의 gap을 출력한다
 */
@Service // id="timerAdvice"
@Aspect
public class TimerAdvice {
	@Around("execution(public void exam.service.*Impl.*ello(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		// 사전처리
		// 사전처리를 하는 타겟 대상의 메소드 정보를 가져오고 싶다.
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[log] " + methodName + " 호출 전 사전처리중입니다...");
		
		Object params [] = joinPoint.getArgs();
		for(Object o : params) {
			System.out.print(o + ", ");
		}
		System.out.println();
		
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed(); // 다음 advice call or 실제 핵심 기능 담당하는 메소드 call
		
		sw.stop();
		System.out.println("[log] " + methodName + " 리턴 값 obj = " + obj);
		System.out.println("[log] " + methodName + " 의 총 실행 ms = " + sw.getTotalTimeMillis()+"ms");
		System.out.println("[log] " + methodName + " 사후처리 완료되었습ㄴ디ㅏ.\n");
		// 사후처리 
		return obj;
	}
}
