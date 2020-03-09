package kr.or.ddit.mp.service.goodcom;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.goodcom.GoodcomDaoImpl;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;

public class GoodcomServiceImpl extends UnicastRemoteObject implements IGoodcomService {
	GoodcomDaoImpl coDao; 
	private static GoodcomServiceImpl service; 
	
	private GoodcomServiceImpl() throws RemoteException{
		super();
		coDao = GoodcomDaoImpl.getInstance();
	}
	
	public static GoodcomServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new GoodcomServiceImpl();
		}
		return service;
	}
	@Override
	public List<ComVO> getSearchGoodCom(ComVO cv) throws RemoteException {
		return coDao.getSearchGoodCom(cv);
	}

	@Override
	public List<MemberVO> isVipCom(String word) throws RemoteException {
		return coDao.isVipCom(word);
	}

}
