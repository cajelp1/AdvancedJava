package kr.or.ddit.board;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServer extends UnicastRemoteObject implements IBoardService {
	
	private IBoardDao boardDao = BoardDaoImpl.getInstance();
	
	public BoardServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		try {
			// RMI 인터페이스를 등록한 객체 생성
			 IBoardService ibs = new  BoardServer();
			
			// 객체를 클라이언트에서 찾을 수 있게 registry 생성. 임의의 포트 8888 사용
			Registry reg = LocateRegistry.createRegistry(8888);
			
			// Registry에 객체 등록
			reg.rebind("boardServer", ibs);
			
			System.out.println("서버가 준비되었습니다.");
			
		}catch(RemoteException e) {e.printStackTrace();}
	}

	@Override
	public List<BoardVO> getAllBoardList() throws RemoteException{
		// TODO Auto-generated method stub
		List<BoardVO> list = boardDao.getAllBoardList();
		return list;
	}

	@Override
	public boolean getBoard(int board_no) throws RemoteException{
		// TODO Auto-generated method stub
		return boardDao.getBoard(board_no);
	}

	@Override
	public int insertBoard(BoardVO bv) throws RemoteException{
		// TODO Auto-generated method stub
		return boardDao.insertBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) throws RemoteException{
		// TODO Auto-generated method stub
		return boardDao.updateBoard(bv);
	}

	@Override
	public int deletBoard(int board_no) throws RemoteException{
		// TODO Auto-generated method stub
		return boardDao.deletBoard(board_no);
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) throws RemoteException{
		// TODO Auto-generated method stub
		return boardDao.getSearchBoard(bv);
	}

}
