package web.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //JPA 관리 객체 --> ddl-auto = create 이면 table로 생성
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_bno_seq")
	@SequenceGenerator(name = "board_bno_seq", allocationSize = 1, sequenceName = "board_bno_seq")
	@Id //pk설정
	private Long bno;
	
	@Column(nullable = false)
	private String title;
	private String writer;
	
	@Column(length=500)
	private String content;
	
	@CreationTimestamp
	private LocalDateTime insertDate;
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
}
