package web.mvc.controller;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String id;
	private String name;
	private int age;
	private String addr;
}
