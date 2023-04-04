package kb.mvc.service;

import java.util.List;

import kb.mvc.dao.BoardDAO;
import kb.mvc.dao.BoardDAOImpl;
import kb.mvc.dto.BoardDTO;
import kb.mvc.dto.ReplyDTO;
import kb.mvc.exception.DMLException;
import kb.mvc.exception.SearchWrongException;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService instance = new BoardServiceImpl();
	private BoardDAO boardDAO = BoardDAOImpl.getInstance();
	
	private BoardServiceImpl () {}

	public static BoardService getInstance() {
		return instance;
	}
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		List<BoardDTO> boardList = boardDAO.boardSelectAll();
		if(boardList.size()==0) throw new SearchWrongException("게시물에 레코드가 없습니다.^^");
		return boardList;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		List<BoardDTO> boardList = boardDAO.boardSelectBySubject(keyWord);
		if(boardList.size()==0) throw new SearchWrongException("게시물에 레코드가 없습니다.^^");
		return boardList;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		BoardDTO dto = boardDAO.boardSelectByNo(boardNo);
		if(dto == null) throw new SearchWrongException("게시물에 레코드가 없습니다.^^");
		return dto;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws DMLException {
		int result = boardDAO.boardInsert(boardDTO);
		if(result == 0) throw new DMLException("등록되지 않았습니다.");
		
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws DMLException {
		int result = boardDAO.boardUpdate(boardDTO);
		if(result == 0) throw new DMLException("수정되지 않았습니다.");
	}

	@Override
	public void boardDelete(int boardNo) throws DMLException {
		int result = boardDAO.boardDelete(boardNo);
		if(result == 0) throw new DMLException("삭제되지 않았습니다.");
	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws DMLException {
		int result = boardDAO.replyInsert(replyDTO);
		if(result == 0) throw new DMLException("댓글이 등록되지 않았습니다.");
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		BoardDTO dto = boardDAO.replySelectByParentNo(boardNo);
		if(dto == null) throw new SearchWrongException("게시물에 레코드가 없습니다.^^");
		return dto;
	}

}
