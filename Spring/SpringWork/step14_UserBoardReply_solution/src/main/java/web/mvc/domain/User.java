package web.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users") //user는 예약어라서 이름 바꿔줌
@NoArgsConstructor
@AllArgsConstructor
public class User { 
	@Id
   private String userId; // string임
	
   private String pwd;
   private String name;
}
