package kr.or.ddit.mp.service.eatdealhome;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.eatdealhome.EatdealHomeDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.CartVO;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.mypage.MileageVO;

public class EatdealHomeServiceImpl extends UnicastRemoteObject implements IEatdealHomeService {
	
	EatdealHomeDaoImpl dao;
	
	private static EatdealHomeServiceImpl service;
	
	private EatdealHomeServiceImpl() throws RemoteException{
		super();
		dao = EatdealHomeDaoImpl.getInstance();
	}
	
	public static EatdealHomeServiceImpl getInstance() throws RemoteException{
		if(service == null) {
			service = new EatdealHomeServiceImpl();
		}
		return service;
	}

	@Override
	public List<EatdealVO> getSelectEatdeal(String word) throws RemoteException {
		
		return dao.getSelectEatdeal(word);
		
	}

	@Override
	public int insertCartEatdeal(CartVO vo) throws RemoteException {
		return dao.insertCartEatdeal(vo);
	}

	@Override
	public List<MileageVO> getMileageLast(String word) throws RemoteException {
		return dao.getMileageLast(word);
	}
	
}
