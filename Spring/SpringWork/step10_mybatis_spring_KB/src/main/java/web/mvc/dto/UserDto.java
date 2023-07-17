package web.mvc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDto {
	private int userSeq;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String isSleep;
	
	
	public UserDto(int userSeq, String password) {
		this.userSeq=userSeq;
		this.password=password;
	}
	
	
}
