package com.itskb.ws03;

public class UserDto {
	public int userSeq;
	public String name;
	public String email;
	public String phone;
	public boolean isSleep; //기본값 false, boolean형은 변수에 is를 많이 넣음
	
	public UserDto() {} //기본생성자를 만들고 밑에 오버로딩
	public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}


}
