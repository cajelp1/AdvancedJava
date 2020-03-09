package kr.or.ddit.mp.service.comeatdeal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.comeatdeal.ComEatdealDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;

public class ComEatdealServiceImpl extends UnicastRemoteObject implements IComEatdealService {
	
	ComEatdealDaoImpl dao;
	
	private static ComEatdealServiceImpl service;
	
	private ComEatdealServiceImpl() throws RemoteException{
		super();
		dao = ComEatdealDaoImpl.getInstance();
	}
	
	public static ComEatdealServiceImpl getInstance() throws RemoteException{
		if(service == null) {
			service = new ComEatdealServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public List<EatdealVO> getComEatdealList(String word) throws RemoteException {
		return dao.getComEatdealList(word);
	}

	@Override
	public int insertNewNoEatdeal(EatdealVO vo) throws RemoteException {
		return dao.insertNewNoEatdeal(vo);
	}

	@Override
	public int deleteEatdeal(EatdealVO vo) throws RemoteException {
		return dao.deleteEatdeal(vo);
	}

}
