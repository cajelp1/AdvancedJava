package kr.or.ddit.mp.service.melonageCheck;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.melonageCheck.MelonageCheckDapImpl;
import kr.or.ddit.mp.vo.melonageCheck.MileageVO;



public class MileageCheckServiceImpl extends UnicastRemoteObject  implements MileageCheckService{
	
	MelonageCheckDapImpl adDao; // 사용할 다오 멤버변수 선언
	private static MileageCheckServiceImpl service; // 싱글톤 패턴
	
	private MileageCheckServiceImpl() throws RemoteException{
		super();
		adDao = MelonageCheckDapImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static MileageCheckServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new MileageCheckServiceImpl();
		}
		return service;
	}

	@Override
	public List<MileageVO> getAddUsedMelonage(MileageVO mvo) throws RemoteException {
		return adDao.getAddUsedMelonage(mvo);
	}
	
	
	@Override
	public List<MileageVO> getAllMelonage(MileageVO mvo) throws RemoteException {
		return adDao.getAllMelonage(mvo);
	}
	
	
			
	
	
	

}
