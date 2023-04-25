package exam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.service.MessageService;
import exam.service.MessageServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("springAOP.xml");
		
		System.out.println("-----------------------------");
		MessageService service = context.getBean("target", MessageService.class);
	
		service.engHello("희정");
		
		System.out.println("-----------------------------");
		
		service.korHello();
		
		System.out.println("-----------------------------");
		
		int re = service.hello();
		System.out.println("re = " + re);
		
		System.out.println("-----------------------------");
		
		String s = service.hello("희정", 10);
		System.out.println("리턴 s = " + s);
	}

}
