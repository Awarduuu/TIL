package ex0327.interfaceExam.board;

import java.util.ArrayList;
import java.util.List;
/**
 * Free와 관련된 비지니스 로직
 * */
public class FreeBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("FreeBoardServiceImpl의 insert call..");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("FreeBoardServiceImpl의 update call..");
		return true;
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("FreeBoardServiceImpl의 selectAll call..");
		List<Board> list = new ArrayList<>();
		list.add(new FreeBoard(1, "제목1", "작성자1", "내용1"));
		list.add(new FreeBoard(2, "제목2", "작성자2", "내용2"));
		return list;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("FreeBoardServiceImpl의 selectByBno call..");
		return new Board(bno, "찾은_제목", "찾은_작성자", "찾은_내용");
	}

}
