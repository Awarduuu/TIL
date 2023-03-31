package ex0327.interfaceExam.board;

import java.util.ArrayList;
import java.util.List;
/**
 * QA에 관련된 비지니스 로직(주요기능)
 * */
public class QABoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("QABoardServiceImpl의 insert call..");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("QABoardServiceImpl의 update call..");
		return true;
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("QABoardServiceImpl의 selectAll call..");
		List<Board> list = new ArrayList<>();
		list.add(new QABoard(1, "제목1", "작성자1", "내용1", true));
		list.add(new QABoard(2, "제목2", "작성자2", "내용2", false));
		return list;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("QABoardServiceImpl의 selectByBno call..");
		return new Board(bno, "찾은_제목", "찾은_작성자", "찾은_내용");
	}

	@Override
		public int replayInsert() {
			System.out.println("QABoardImpl의 replyInsert call...");
			return 3;
		}
}
