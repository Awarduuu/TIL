package day04.overriding;

class ObjectExam{
	String str;
	public ObjectExam(){   }
	public ObjectExam(String str){  
		this.str = str;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return str + " = " + super.toString();
	}
}
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			
			if(s01 == s02) {} // String 객체의 주소값 비교
			
			if(s01.equals(s02)) {} //
			
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam("언제 쉴거야?");
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//
			System.out.println(s01);//
			System.out.println(s02);//
			System.out.println(s03);// 월요일 (왜 주소값이 아닌가?)
			/**
			 * println(Object obj) 메소드는
			 * 인수로 객체가 전달되면 obj.toString()를 자동으로 호출한다.
			 * toString이 리턴하는 값을 출력
			 */
			System.out.println(oe1);// 주소값
			System.out.println(oe2.toString());// 주소값
			
	}
}

