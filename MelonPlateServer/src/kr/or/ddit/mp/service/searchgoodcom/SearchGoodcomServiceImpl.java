package kr.or.ddit.mp.service.searchgoodcom;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.searchgoodcom.SearchGoodcomDaoImpl;
import kr.or.ddit.mp.vo.member.ComVO;

public class SearchGoodcomServiceImpl extends UnicastRemoteObject implements ISearchGoodcomService {

	SearchGoodcomDaoImpl seDao; // 사용할 다오 멤버변수 선언
	private static SearchGoodcomServiceImpl service; // 싱글톤 패턴
	
	private SearchGoodcomServiceImpl() throws RemoteException{
		super();
		seDao = SearchGoodcomDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static SearchGoodcomServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new SearchGoodcomServiceImpl();
		}
		return service;
	}

	@Override
	public List<ComVO> getResultGoodCom(String word) throws RemoteException {
		return seDao.getResultGoodCom(word);
	}

}
