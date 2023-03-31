package day05;

public class TestExam {
	
	public static void aa(int j) {
		j++;
	}
	public static void bb(AB a) {
		a.name = "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j=10;
		aa(j);
		System.out.println(j);
	}

}

class AB {
	String name;
}