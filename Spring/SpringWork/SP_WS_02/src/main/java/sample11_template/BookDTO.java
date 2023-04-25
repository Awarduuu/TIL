package sample11_template;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Scope("prototype")
@Component
public class BookDTO {
   private String subject;
   private String writer;
   private int price;
   private String date;
   
	
}

