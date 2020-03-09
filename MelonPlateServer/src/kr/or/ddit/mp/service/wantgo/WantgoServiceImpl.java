package kr.or.ddit.mp.service.wantgo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.goodcom.GoodcomDaoImpl;
import kr.or.ddit.mp.dao.wantgo.WantgoDaoImpl;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.mypage.WantgoVO;

public class WantgoServiceImpl extends UnicastRemoteObject implements IWantgoService {
	WantgoDaoImpl wantDao; // 사용할 다오 멤버변수 선언
	private static WantgoServiceImpl service; // 싱글톤 패턴
	
	private WantgoServiceImpl() throws RemoteException{
		super();
		wantDao = WantgoDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static WantgoServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new WantgoServiceImpl();
		}
		return service;
	}

	@Override
	public List<WantgoVO> selectWantgo(WantgoVO wv) throws RemoteException {
		return wantDao.selectWantgo(wv);
	}

	@Override
	public boolean isEmptyWantgo(WantgoVO wv) throws RemoteException {
		return wantDao.isEmptyWantgo(wv);
	}

	@Override
	public int deleteWantgo(WantgoVO wv) throws RemoteException {
		return wantDao.deleteWantgo(wv);
	}

	@Override
	public int insertWantgo(WantgoVO wv) throws RemoteException {
		return wantDao.insertWantgo(wv);
	}

}
