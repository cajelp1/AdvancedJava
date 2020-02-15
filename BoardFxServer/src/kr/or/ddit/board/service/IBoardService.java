package kr.or.ddit.board.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService extends Remote{
	
	// 글 전부 가져오기
	public List<BoardVO> getAllBoardList() throws RemoteException;

	// 글 찾기 (보드넘버)
	public boolean getBoard(int board_no) throws RemoteException;
	
	// 글 추가
	public int insertBoard(BoardVO bv) throws RemoteException;
	
	// 글 수정
	public int updateBoard(BoardVO bv) throws RemoteException;
	
	// 글 삭제 (보드넘버)
	public int deletBoard(int board_no) throws RemoteException;
	
	// 글 검색
	public List<BoardVO> getSearchBoard(BoardVO bv) throws RemoteException;
	
}
