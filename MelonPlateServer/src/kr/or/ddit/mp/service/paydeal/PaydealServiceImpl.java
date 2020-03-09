package kr.or.ddit.mp.service.paydeal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.paydeal.PaydealDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.eatdeal.PayVO;
import kr.or.ddit.mp.vo.eatdeal.RequestVO;
import kr.or.ddit.mp.vo.mypage.MileageVO;

public class PaydealServiceImpl extends UnicastRemoteObject implements IPaydealService {
	PaydealDaoImpl dao;
	
	private static PaydealServiceImpl service;
	
	private PaydealServiceImpl() throws RemoteException{
		super();
		dao = PaydealDaoImpl.getInstance();
	}
	
	public static PaydealServiceImpl getInstance() throws RemoteException{
		if(service == null) {
			service = new PaydealServiceImpl();
		}
		return service;
	}

	@Override
	public int requestPayInsert(RequestVO vo) throws RemoteException {
		return dao.requestPayInsert(vo);
	}

	@Override
	public int requestCartInsert(RequestVO vo) throws RemoteException {
		return dao.requestCartInsert(vo);
	}

	@Override
	public List<RequestVO> requestSelect(String word) throws RemoteException {
		return dao.requestSelect(word);
	}

	@Override
	public int payInsert(PayVO vo) throws RemoteException {
		return dao.payInsert(vo);
	}

	@Override
	public int mileNotuseInsert(MileageVO vo) throws RemoteException {
		return dao.mileNotuseInsert(vo);
	}

	@Override
	public int mileUseInsert(MileageVO vo) throws RemoteException {
		return dao.mileUseInsert(vo);
	}

	@Override
	public int eatdealQtyDown(EatdealVO vo) throws RemoteException {
		return dao.eatdealQtyDown(vo);
	}

}
