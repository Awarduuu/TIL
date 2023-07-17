package exam;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
//@ToString
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_pk")
	@SequenceGenerator(name = "team_pk", allocationSize = 1, sequenceName = "team_pk")
	private Long id;
	
	private String teamName;
	
	@OneToMany(mappedBy = "team") // default가 지연로딩
	private List<Member> memberList;
	
}
