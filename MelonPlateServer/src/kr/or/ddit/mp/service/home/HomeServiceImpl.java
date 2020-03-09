package kr.or.ddit.mp.service.home;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.home.HomeDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;

public class HomeServiceImpl extends UnicastRemoteObject implements IHomeService {
	HomeDaoImpl coDao; 
	private static HomeServiceImpl service; 
	
	private HomeServiceImpl() throws RemoteException{
		super();
		coDao = HomeDaoImpl.getInstance();
	}
	
	public static HomeServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new HomeServiceImpl();
		}
		return service;
	}
	@Override
	public List<MemberVO> homeBestTop10() throws RemoteException {
		return coDao.homeBestTop10();
	}

	@Override
	public List<ZoneVO> myZoneSelect(String word) throws RemoteException {
		return coDao.myZoneSelect(word);
	}

	@Override
	public List<EatdealVO> homeEatBest5() throws RemoteException {
		return coDao.homeEatBest5();
	}

	@Override
	public List<ComVO> homeComeBest5(ZoneVO vo) throws RemoteException {
		return coDao.homeComeBest5(vo);
	}

}
