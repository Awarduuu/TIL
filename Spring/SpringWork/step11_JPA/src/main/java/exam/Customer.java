package exam;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer {
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.AUTO) //시퀀스 생성과 동일 
	private Long id;
	
	@Column(nullable = false, length = 100, name="user_name")
	private String userName;
	
//	@Transient //column으로 만들지 않는다.
	@Column(nullable = true)
	private int age;
	
	@CreationTimestamp
	private LocalDateTime insertDate; // 등록일
	
	@UpdateTimestamp
	private LocalDateTime updateDate; // 수정일
	
	@Temporal(TemporalType.DATE)
	private Date birthDay;
}
