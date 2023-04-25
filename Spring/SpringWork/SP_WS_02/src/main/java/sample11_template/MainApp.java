package sample11_template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
          ApplicationContext context = 
        		  new ClassPathXmlApplicationContext("sample11_template/applicationContext.xml");
          
          //controller의 invoker를 호출해본다!
          BookController controller = context.getBean("controller" , BookController.class);
          controller.invoker();

	}

}
