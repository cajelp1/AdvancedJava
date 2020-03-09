package kr.or.ddit.mp.service.salescom;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.salescom.SalesComDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.SalesVO;



public class SalesComServiceImpl extends UnicastRemoteObject implements ISalesComService {
	SalesComDaoImpl coDao;
	private static SalesComServiceImpl service; 
	
	private SalesComServiceImpl() throws RemoteException{
		super();
		coDao = SalesComDaoImpl.getInstance();
	}
	
	public static SalesComServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new SalesComServiceImpl();
		}
		return service;
	}

	@Override
	public List<SalesVO> getSalesComEatdeal(String word) throws RemoteException {
		return coDao.getSalesComEatdeal(word);
	}
}
