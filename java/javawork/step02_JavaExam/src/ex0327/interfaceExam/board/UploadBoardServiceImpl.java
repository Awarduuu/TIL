package ex0327.interfaceExam.board;

import java.util.ArrayList;
import java.util.List;

public class UploadBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("UploadBoardServiceImpl의 insert call..");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UploadBoardServiceImpl의 update call..");
		return true;
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("UploadBoardServiceImpl의 selectAll call..");
		List<Board> list = new ArrayList<>();
		list.add(new UploadBoard(1, "제목1", "작성자1", "내용1", "a.jpg"));
		list.add(new UploadBoard(2, "제목2", "작성자2", "내용2", "b.zip"));
		return list;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("UploadBoardServiceImpl의 selectByBno call..");
		return new Board(bno, "찾은_제목", "찾은_작성자", "찾은_내용");
	}

}
