package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//기존 방식
		/*
		StudentDAO dao = new StudentDAOImpl();
		
		StudentServiceImpl service = new StudentServiceImpl();
		service.setStudentDAO(dao);
		
		StudentController controller = new StudentController();
		
		Student student = new Student();
		student.setName("희정");
		student.setAddr("선릉");
		student.setNo(0);
		student.setPhone("111-2222");
		
		controller.setService(service);
		controller.setStudent(student);
		
		System.out.println("---------------------------------");
		
		controller.insert();
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample04/springDISetter.xml");
		
		StudentController controller = context.getBean("controller", StudentController.class);
		controller.insert();

	}

}
