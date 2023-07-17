package web.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_rno_seq")
    @SequenceGenerator(name="reply_rno_seq" , allocationSize = 1 , sequenceName = "reply_rno_seq")
	private Long rno;//댓글번호
	
	private String content;//댓글내용
	
	@CreationTimestamp
	private LocalDateTime insertDate;
	
	@ManyToOne(fetch = FetchType.LAZY) //지연로딩!! 댓글을 기준으로 글은 하나 이므로 (댓글을 가져오면서 부모글 미리 가져오지 말라고!)
	@JoinColumn(name = "free_bno") // fk 설정
	private FreeBoard freeBoard;
	
}




