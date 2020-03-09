package kr.or.ddit.mp.service.buylist;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.buylist.BuylistDaoImpl;
import kr.or.ddit.mp.vo.buylist.RequestVO;

public class BuylistServiceImpl extends UnicastRemoteObject implements IBuylistService {

	BuylistDaoImpl buyDao; // 사용할 다오 멤버변수 선언
	private static BuylistServiceImpl service; // 싱글톤 패턴
	
	private BuylistServiceImpl() throws RemoteException{
		super();
		buyDao = BuylistDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static BuylistServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new BuylistServiceImpl();
		}
		return service;
	}

	@Override
	public int deleteRequest(RequestVO rvo) throws RemoteException {
		return buyDao.deleteRequest(rvo);
	}

	@Override
	public List<RequestVO> getAllBuyList(RequestVO rvo) throws RemoteException {
		return buyDao.getAllBuyList(rvo);
	}

	@Override
	public int updateOrder_st(RequestVO rvo) throws RemoteException {
		return buyDao.updateOrder_st(rvo);
	}

	


}
