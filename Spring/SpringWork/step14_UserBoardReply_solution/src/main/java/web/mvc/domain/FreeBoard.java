package web.mvc.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Table(name = "이름설정..")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FreeBoard { //db에 free_board db에서는 _로 바뀐다.
	@Id //pk
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "free_bno_seq")
	@SequenceGenerator(name ="free_bno_seq" , allocationSize = 1 , sequenceName = "free_bno_seq")
	private Long bno;
	private String subject;
	private String writer;
	
	@Column(length = 500)
	private String content;
	private String password;
	private int readnum; //조회수
	
	@CreationTimestamp
	private LocalDateTime insertDate; //등록일
	
	@UpdateTimestamp
	private LocalDateTime updateDate; // 수정일
	
	
	//댓글정보!
	/**
	 * cascade = CascadeType.ALL 옵션은 Entity의 상태 변화가 생기면 연관관계에 있는
	 * Entity도 상태변화가 전이되는 옵션
	 * */
	//@OneToMany(mappedBy = "freeBoard", cascade = CascadeType.ALL) //freeboard 1개 리스트 많이, 지연로딩
	@OneToMany(mappedBy = "freeBoard") // 지연로딩
	private List<Reply> replyList;
	
	public FreeBoard(Long bno) {
		this.bno=bno;
	}
  
}











