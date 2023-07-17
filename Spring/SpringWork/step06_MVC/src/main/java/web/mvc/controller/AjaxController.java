package web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
//	@RequestMapping("/ajax.do")
//	public String aa(String email, String pwd) {
//		System.out.println(email + ", " +pwd);
//		return "hello�ȳ�";
//	}
	@RequestMapping("/ajax.do")
	public List<MemberDTO> aa(String email, String pwd) {
		System.out.println(email + ", " +pwd);
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO("jang", "a@daum.net", 20, "선릉"));
		list.add(new MemberDTO("kim", "kim@daum.net", 30, "불광"));
		list.add(new MemberDTO("queen", "queen@daum.net", 40, "강남"));
		
		return list;
	}
}
