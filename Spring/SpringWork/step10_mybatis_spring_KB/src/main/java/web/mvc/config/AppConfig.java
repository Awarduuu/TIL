package web.mvc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

/**
 * 환경설정을 돕는 클래스 (server가 start될 때 @Configuration 설정이 있는 클래스를 
 * 로딩해서 @Bean을 등록해준다.
 */
@Configuration 
public class AppConfig {
	/**
	 * 예외처리
	 * */
	@Bean
	public SimpleMappingExceptionResolver getSimpleMappingException() {
		SimpleMappingExceptionResolver exceptionResolover = new SimpleMappingExceptionResolver();
		System.out.println("SimpleMappingExceptionResolver 등록됨......");
		Properties pro = new Properties();
		pro.put("Exception", "error/errorMessage");
		
		exceptionResolover.setExceptionMappings(pro);
		return exceptionResolover;
	}
	

}





