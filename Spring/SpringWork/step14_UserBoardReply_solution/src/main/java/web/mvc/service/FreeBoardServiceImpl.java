package web.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import web.mvc.domain.FreeBoard;
import web.mvc.domain.QFreeBoard;
import web.mvc.domain.QReply;
import web.mvc.repository.FreeBoardRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class FreeBoardServiceImpl implements FreeBoardService {
	
	private final FreeBoardRepository freeRep;
	
	private final JPAQueryFactory queryFactory; 

	@Override
	public List<FreeBoard> selectAll() {
		return freeRep.findAll();
	}

	@Override
	public Page<FreeBoard> selectAll(Pageable pageable) {
		return freeRep.findAll(pageable);
	}

	@Override
	public void insert(FreeBoard board) {
		FreeBoard freeBoard = freeRep.save(board); //insert를 하면 그 결과에 대한 걸 리턴함
		
		System.out.println("freeBoard = " + freeBoard); // 여 안에 글 번호 있음 이를활용하면 된다 
		
		//주문하기
		// 주문 테이블에도 삽입, 주문 상세 테이블에도 삽입
		
		
	}

	@Override
	public FreeBoard selectBy(Long bno, boolean state) {
	   // state가 true라면 조회수 증가를 호출한다. - repository에 조회수증가하는 메소드 완료하여 JPQL문법 사용
		if (state) {
			freeRep.updateReadnum(bno);
		}
		
		// bno에 해당하는 게시물을 조회 호출한다.
		 FreeBoard board = freeRep.findById(bno).orElse(null);
		 // 결과가 null이라면 throw new RuntimeException("상세보기 오류입니다.^^") 발생
		 if(board == null) {
			 throw new RuntimeException("상세보기 오류입니다.^^");
		 }
		  //null아니면 조회된 게시물 리턴
		
		 return board;
	}

	@Override
	public FreeBoard update(FreeBoard board) {
		//수정전에 비번 일치를 확인하기 위해서 bno에 해당하는 정보를 조회한다.
		FreeBoard freeBoard = freeRep.findById(board.getBno()).orElse(null);
		
		//조회된 게시물이 없으면 throw new RuntimeException("글번호 오류로 수정할수 없습니다."); 발생
		if (freeBoard == null) {
			throw new RuntimeException("글번호 오류로 수정할수 없습니다.");
		}
		//조회된 게시물이 있으면 비밀번호 일치여부를 확인한다.
		//비번이 일치하지 않으면 throw new RuntimeException("비밀번호 오류로 수정할수 없습니다."); 발생
		if(!freeBoard.getPassword().equals(board.getPassword())) {
			throw new RuntimeException("비밀번호 오류로 수정할수 없습니다.");
		}
		
		//비번이 일치하면 content와 subject을 수정한다. 
		//수정된 객체를 리턴한다.
		freeBoard.setContent(board.getContent());
		freeBoard.setSubject(board.getSubject());
		
		return freeBoard;
	}

	@Override
	public void delete(Long bno, String password) {
		// 삭제전에 bno에 해당하는 게시물을 조회한다.
		FreeBoard dbBoard = freeRep.findById(bno).orElse(null);
		 //조회된 게시물이 없으면 throw new RuntimeException("글번호 오류로 삭제할 수 없습니다.");
		if(dbBoard == null) 
			throw new RuntimeException("글번호 오류로 삭제할 수 없습니다.");
		//조회된 게시물이 있으면 비밀번호 일치를 확인한다'
		//비번이 틀리면 throw new RuntimeException("비밀번호 오류로 삭제 할수 없습니다.");
		if(!dbBoard.getPassword().equals(password))
			throw new RuntimeException("비밀번호 오류로 삭제 할수 없습니다.");
		
		//비번이 일치하면 삭제한다.
		//freeRep.delete(dbBoard);
		
		//삭제하기 전에 삭제하려는 글의 댓글 정보가 있으면 댓글을 먼저 삭제한 후 부모글을 삭제한다.
		// cascade = CascadeType.ALL 옵션으로 자동으로 삭제할 수 있지만 직접 쿼리를 만들어서 삭제할수 있따.
		// 직접 사용자 정의 쿼리를 만들 때는 JPAQueryFactory를 이용하면 편리하다
		
		QFreeBoard board = QFreeBoard.freeBoard;
		QReply reply = QReply.reply;
		
		
		//자식 삭제
		long re1 = queryFactory.delete(reply).where(reply.freeBoard.bno.eq(bno)).execute();
		
		//부모 삭제
		long re2 = queryFactory.delete(board).where(board.bno.eq(bno).and(board.password.eq(password))).execute();
		
		if(re1 == 0 || re2 == 0)
			throw new RuntimeException("삭제할 수 없습니다.");
		
	}

}












