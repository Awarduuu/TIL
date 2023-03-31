package ex0327.interfaceExam.board;

import java.util.ArrayList;
import java.util.List;

public class TestMainApp {
	BoardService service; // null -> 필드를 이용한 다형성
	Board board;
	
	public static void main(String[] args) {
		new TestMainApp();
	}

	public TestMainApp() {
		// test 메소드 호출
		System.out.println("*********** QABoard TEST ************");
		service = new QABoardServiceImpl();
		board = new QABoard(1, "제목1", "작성자1", "내용1", true);
		this.test(service, board);
		
		System.out.println("\n*********** UploadBoard TEST ************");
		service = new UploadBoardServiceImpl();
		board = new UploadBoard(2, "Upload 제목", "Upload 작성자", "Upload 내용", "Upload.jpg");
		this.test(service, board);
		
		System.out.println("\n*********** Free Board TEST ************");
		service = new FreeBoardServiceImpl();
		board = new FreeBoard(3, "Free 제목", "Free 작성자", "Free 내용");
		this.test(service, board);
		
		////익명구현클래스////////////////////////
		System.out.println("\n*********** Photo Board TEST ************");
		service = new BoardService() {
			
			@Override
			public boolean update(Board board) {
				System.out.println("PhotoService....insert");
				return false;
			}
			
			@Override
			public Board selectByBno(int bno) {
				System.out.println("PhotoService....update");
				return null;
			}
			
			@Override
			public List<Board> selectAll() {
				System.out.println("PhotoService....selectByBno");
				return new ArrayList<>();
			}
			
			@Override
			public int insert(Board board) {
				System.out.println("PhotoService....selectAll");
				return 0;
			}
		};
		this.test(service, board);
		
	} // 생성자 끝
	
	/**
	 * 인수로 전달된 BoardService를 이용해서 각 메소드를 호출해보자 (매개변수를 이용한 다형성)
	 * */
	public void test(BoardService service, Board board) {
		service.insert(board);
		service.update(board);
		Board searchedBoard = service.selectByBno(0);
		System.out.println("searchedBoard = " + searchedBoard);
		
		List<Board> list = service.selectAll();
		System.out.println("검색된 레코드 : " + list.size());
		for(Board b : list) {
			System.out.println(b);
		}
		
		System.out.println("---------- 추가된 메소드 호출 ----------");
		service.replayInsert();
		BoardService.selectBySubject(); // static method
	} //test End
	
}
