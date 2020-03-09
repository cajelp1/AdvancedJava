package kr.or.ddit.mp.service.recogeatdeal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.recogeatdeal.RecogeatdealDaoImpl;
import kr.or.ddit.mp.vo.recogeatdeal.EatdealVO;

public class RecogeatdealServiceImpl extends UnicastRemoteObject implements IRecogeatdealService {

	RecogeatdealDaoImpl recogDao; // 사용할 다오 멤버변수 선언
	private static RecogeatdealServiceImpl service; // 싱글톤 패턴
	
	private RecogeatdealServiceImpl() throws RemoteException{
		super();
		recogDao = RecogeatdealDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static RecogeatdealServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new RecogeatdealServiceImpl();
		}
		return service;
	}
	
	
	

	@Override
	public List<EatdealVO> getAllEatList() throws RemoteException {
		return recogDao.getAllEatList();
	}

	@Override
	public int updateOnY(EatdealVO evo) throws RemoteException {
		return recogDao.updateOnY(evo);
	}

	@Override
	public int updateOnB(EatdealVO evo) throws RemoteException {
		return recogDao.updateOnB(evo);
	}



}
