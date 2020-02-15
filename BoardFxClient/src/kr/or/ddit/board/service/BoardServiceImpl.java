package kr.or.ddit.board.service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private static BoardServiceImpl instance;
	private BoardServiceImpl() {}
	
	public static BoardServiceImpl getInstance() {
		if(instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> list = null;
		
		try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			IBoardService ibs = (IBoardService) reg.lookup("boardServer");
			
			list = ibs.getAllBoardList();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean getBoard(int board_no) {
		boolean result = false;
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			IBoardService ibs = (IBoardService) reg.lookup("boardServer");
			
			result = ibs.getBoard(board_no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int result = 0;
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			IBoardService ibs = (IBoardService) reg.lookup("boardServer");
			
			result = ibs.insertBoard(bv);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int result = 0;
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			IBoardService ibs = (IBoardService) reg.lookup("boardServer");
			
			result = ibs.updateBoard(bv);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deletBoard(int board_no) {
		int result = 0;
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			IBoardService ibs = (IBoardService) reg.lookup("boardServer");
			
			result = ibs.deletBoard(board_no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> list = null;
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			IBoardService ibs = (IBoardService) reg.lookup("boardServer");
			
			list = ibs.getSearchBoard(bv);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
