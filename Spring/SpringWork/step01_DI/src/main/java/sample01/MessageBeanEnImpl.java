package sample01;

public class MessageBeanEnImpl implements MessageBean {
	
	public MessageBeanEnImpl() {
		System.out.println("MessageBeanEmImpl call...");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name);
	}

}
