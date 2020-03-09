package kr.or.ddit.mp.service.alleatdeal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.alleatdeal.AllEatdealDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;


public class AllEatdealServiceImpl extends UnicastRemoteObject  implements IAllEatdealService {
	AllEatdealDaoImpl dao;
	
	private static AllEatdealServiceImpl service;
	
	private AllEatdealServiceImpl() throws RemoteException{
		super();
		dao = AllEatdealDaoImpl.getInstance();
	}
	
	public static AllEatdealServiceImpl getInstance() throws RemoteException{
		if(service == null) {
			service = new AllEatdealServiceImpl();
		}
		return service;
	}

	@Override
	public List<EatdealVO> eatlistByMyzone(ZoneVO vo) {
		return dao.eatlistByMyzone(vo);
	}

	@Override
	public List<EatdealVO> eatlistByQty() {
		return dao.eatlistByQty();
	}

	@Override
	public List<ZoneVO> zoneForlist(String word) {
		return dao.zoneForlist(word);
	}

	@Override
	public List<EatdealVO> eatlistByNew() {
		return dao.eatlistByNew();
	}
}
