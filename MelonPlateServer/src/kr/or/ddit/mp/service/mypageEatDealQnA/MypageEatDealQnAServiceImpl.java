package kr.or.ddit.mp.service.mypageEatDealQnA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.mypageEatDealQnA.MypageEatDealQnADaoImpl;
import kr.or.ddit.mp.vo.mypageEatDealQnA.EatqaVO;



public class MypageEatDealQnAServiceImpl extends UnicastRemoteObject  implements MypageEatDealQnAService{
	
	MypageEatDealQnADaoImpl adDao; // 사용할 다오 멤버변수 선언
	private static MypageEatDealQnAServiceImpl service; // 싱글톤 패턴
	
	private MypageEatDealQnAServiceImpl() throws RemoteException{
		super();
		adDao = MypageEatDealQnADaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static MypageEatDealQnAServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new MypageEatDealQnAServiceImpl();
		}
		return service;
	}

	@Override
	public List<EatqaVO> getMyEatDealQnA(EatqaVO evo) throws RemoteException {
		return adDao.getMyEatDealQnA(evo);
	}
	
	
			
	
	
	

}
