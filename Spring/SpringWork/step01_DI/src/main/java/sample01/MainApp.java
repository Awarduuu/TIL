package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기존 방법 
		
		/*MessageBean bean = new MessageBeanKoImpl();
		bean.sayHello("heejung");
		bean = new MessageBeanEnImpl();
		bean.sayHello("희정");*/
		
		/**
		 * SpringContainer인 ApplicationContext는 객체를 미리 사전초기화한다.
		 * scope="singletone"으로 관리된다. (default)
		 * scope="prototype"으로 설정하면 지연초기화한다. (원할때마다 객체 생성 가능)
		 */
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sample01/applicationContext.xml");
		
		MessageBean bean = context.getBean("en", MessageBean.class);
		bean.sayHello("heejung");
		
		bean = context.getBean("ko", MessageBean.class);
		bean.sayHello("희정");
		
		System.out.println("bean = " + bean);
		
		MessageBean bean2 = context.getBean("ko", MessageBean.class);
		
		System.out.println("bean2 = " + bean2);
				
		
	}

}
