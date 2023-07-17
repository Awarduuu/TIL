package exam;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "team")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_pk")
	@SequenceGenerator(name = "member_pk", allocationSize = 1, sequenceName = "member_pk")
	private Long memberId;
	
	private String name;
	
	private int age;
	
	@ManyToOne // fk설정, 즉시 로딩 (조인) 
//	@ManyToOne(fetch = FetchType.LAZY) // 지연로딩
	@JoinColumn(name = "tid")
	private Team team;
	
	
}
