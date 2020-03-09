package kr.or.ddit.mp.service.comInfoUpdate;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.comInfoUpdate.ComInfoUpdateDapImpl;
import kr.or.ddit.mp.vo.comInfoUpdate.ComVO;
import kr.or.ddit.mp.vo.comInfoUpdate.MemberVO;
import kr.or.ddit.mp.vo.comInfoUpdate.ZiptbVO;

public class ComInfoUpdateImpl extends UnicastRemoteObject implements ComInfoUpdateService {

	ComInfoUpdateDapImpl adDao; // 사용할 다오 멤버변수 선언
	private static ComInfoUpdateImpl service; // 싱글톤 패턴

	private ComInfoUpdateImpl() throws RemoteException {
		super();
		adDao = ComInfoUpdateDapImpl.getInstance(); // 싱글톤 패턴
	}

	public static ComInfoUpdateImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new ComInfoUpdateImpl();
		}
		return service;
	}

	@Override
	public MemberVO getPw(MemberVO mvo) throws RemoteException {
		return adDao.getPw(mvo);
	}

	@Override
	public ComVO getDefaultInfo(ComVO cvo) throws RemoteException {
		return adDao.getDefaultInfo(cvo);
	}

	@Override
	public List<ZiptbVO> getSearchZipCode(ZiptbVO zvo) throws RemoteException {
		return adDao.getSearchZipCode(zvo);
	}

	@Override
	public int updateCom(ComVO cvo) throws RemoteException {
		return adDao.updateCom(cvo);
	}
	
	@Override
	public int updatePhoto(ComVO cvo) throws RemoteException {
		return adDao.updatePhoto(cvo);
	}

}
