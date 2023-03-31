package day05;

public class AbstractKeywordExam {
	public static void main(String[] args) {
		Remote re = new LgRemote();
		re.on();
		
		re = new SamsungRemote();
		re.on();
		
	}
}

abstract class Remote{
	abstract void on();
}

class LgRemote extends Remote{
	void on() {
		System.out.println("LgRemote on");
	};
}

class SamsungRemote extends Remote{
	void on() {
		System.out.println("Samsung on");
	};
}

