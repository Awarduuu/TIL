package exam.service;

import org.springframework.stereotype.Service;

@Service("target")
public class MessageServiceImpl implements MessageService {

	@Override
	public void korHello() {
		System.out.println("MessageServiceImpl의 korHello() 메소드 핵심로직입니다....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void engHello(String name) {
		System.out.println("MessageServiceImpl의 engHello(String name) 메소드 핵심로직입니다....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int hello() {
		System.out.println("MessageServiceImpl의 hello() 메소드 핵심로직입니다....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 100;
	}

	@Override
	public String hello(String name, int age) {
		System.out.println("MessageServiceImpl의 hello(String name, int age) 메소드 핵심로직입니다....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello";
	}

}
