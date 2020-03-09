package kr.or.ddit.mp.service.memInfoUpdate;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.memInfoUpdate.MemInfoUpdateDaoImpl;
import kr.or.ddit.mp.vo.memInfoUpdate.MemberVO;
import kr.or.ddit.mp.vo.memInfoUpdate.ZiptbVO;



public class MemInfoUpdateImpl extends UnicastRemoteObject  implements MemInfoUpdateService{
	
	MemInfoUpdateDaoImpl adDao; // 사용할 다오 멤버변수 선언
	private static MemInfoUpdateImpl service; // 싱글톤 패턴
	
	private MemInfoUpdateImpl() throws RemoteException{
		super();
		adDao = MemInfoUpdateDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static MemInfoUpdateImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new MemInfoUpdateImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO getPw(MemberVO mvo) throws RemoteException {
		return adDao.getPw(mvo);
	}
	
	@Override
	public MemberVO getDefaultInfo(MemberVO mvo) throws RemoteException {
		return adDao.getDefaultInfo(mvo);
	}
	
	@Override
	public MemberVO getNickCheck(String str) throws RemoteException {
		return adDao.getNickCheck(str);
	}
	
	@Override
	public List<ZiptbVO> getSearchZipCode(ZiptbVO zvo) throws RemoteException {
		return adDao.getSearchZipCode(zvo);
	}
	
	@Override
	public int deleteMember(MemberVO mvo) throws RemoteException {
		return adDao.deleteMember(mvo);
	}
	
	@Override
	public int updateMember(MemberVO mvo) throws RemoteException {
		return adDao.updateMember(mvo);
	}

			
	
	
	

}
