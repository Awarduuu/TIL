package ex0327.interfaceExam.board;

import java.util.List;

/**
 * 모든 게시물의 공통으로 사용하게 될 메소드 정의(규격서)
 * */
public interface BoardService {
	/**
	 * 등록하기
	 * @return : 0이면 등록실패, 1이상이면 등록성공
	 * */
	int insert(Board board);
	
	/**
	 * 수정하기(글번호에 해당하는 제목, 내용을 수정한다.)
	 * @return : false이면 수정실패, true이면 수정성공
	 * */
	boolean update(Board board);
	
	/**
	 * 전체 게시물 조회하기
	 * */
	List<Board> selectAll();
	
	/**
	 * 글번호에 해당하는 게시물 조회하기(글번호는 중복이 안된다)
	 * */
	Board selectByBno(int bno);
	
	/////////////////////////////////
	
	/**
	 * java 1.8version 추가된 문법
	 *     : interface 안에 있는 메소드에 static or default 메소드를 만들 수 있고
	 *       static or default가 선언되면 body가 있는 메소드가 된다.
	 *       이유 - 유지보수를 할 때 특정 구현객체에만 사용해야하는 메소드가 있을 때 interface
	 *       를 추가하면 이미 구현된 모든 구현객체들이 재정의해야하는 번거로움이 있다. 그래서 이미 구현된
	 *       상태에서 특정 구현객체만 필요한 메소드가 있다면 static or default를 만들고 필요한
	 *       구현 클래스에서만 재정의 하도록 하는것. 또, 모든 구현 객체들이 공통으로 사용하는 기능이 
	 *       정해져있다면 static or default로 만들어서 재정의 없이 사용한다.
	 *       
	 *     1) static 메소드
	 *        : 구현 객체 없이 바로 interface이름.메소드이름() 호출 가능
	 *     2) default 메소드
	 *        : 반드시 구현 객체가 있어야 호출 가능
	 * */
	
	/**
	 * 답변기능 메소드 추가
	 * */
	default int replayInsert() {
		System.out.println("BoardService의 replyInsert call....");
		return 0;
	}
	
	static Board selectBySubject() {
		System.out.println("BoardService의 selectBySubject call....");
		return null;
	}
	

}
