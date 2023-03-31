package ex0328.exceptionEx;

public class ShoppingMall {
	
	public void come(int age) throws AgeException{
		if(age < 18) {
			throw new AgeException("애들은 가라");
		}
	}
}
