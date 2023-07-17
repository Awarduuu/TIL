package web.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy 
public class Step32BoardReplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step32BoardReplyApplication.class, args);
	}

}
