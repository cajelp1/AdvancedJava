package kr.or.ddit.mp.service.matZip;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.matZip.MatZipDaoImpl;
import kr.or.ddit.mp.vo.matZip.ReviewVO;



public class MatZipServiceImpl extends UnicastRemoteObject  implements MatZipService{
	
	MatZipDaoImpl adDao; // 사용할 다오 멤버변수 선언
	private static MatZipServiceImpl service; // 싱글톤 패턴
	
	private MatZipServiceImpl() throws RemoteException{
		super();
		adDao = MatZipDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static MatZipServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new MatZipServiceImpl();
		}
		return service;
	}

	@Override
	public List<ReviewVO> getGoodCom(ReviewVO rvo) throws RemoteException {
		return adDao.getGoodCom(rvo);
	}
	
	
			
	
	
	

}
