package web.mvc.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
public class AppConfig {

   /**
      예외처리
    * */
	@Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties pro = new Properties();
		pro.put("Exception", "error/errorView");
		
		exceptionResolver.setExceptionMappings(pro);
		return exceptionResolver;
	}
	
	@PersistenceContext // EntityManager는 각 서비스마다 새롭게 생성해서 주입
	private EntityManager em;
	
	@Bean // 생성
	public JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(em);
	}
	
}






