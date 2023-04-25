package sample07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class BoardDTO {
	@Value("10")
	private int no;
	@Value("SpringDI")
	private String subject;
	@Value("surprise!")
	private String content;
	
	
}
