package kr.or.ddit.mp.service.admin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.admin.AdminDapImpl;
import kr.or.ddit.mp.vo.admin.MemberVO;
import kr.or.ddit.mp.vo.admin.ReadyComVO;



public class AdminServiceImpl extends UnicastRemoteObject  implements AdminService{
	
	AdminDapImpl adDao; // 사용할 다오 멤버변수 선언
	private static AdminServiceImpl service; // 싱글톤 패턴
	
	private AdminServiceImpl() throws RemoteException{
		super();
	adDao = AdminDapImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static AdminServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new AdminServiceImpl();
		}
		return service;
	}

	@Override
	public List<MemberVO> getAllMemberCom() throws RemoteException {
		return adDao.getAllMemberCom();
	}

	@Override
	public int deleteMember(MemberVO mvo) throws RemoteException {
		return adDao.deleteMember(mvo);
	}

	@Override
	public int insertAdmin(MemberVO mvo) throws RemoteException {
		return adDao.insertAdmin(mvo);
	}

	@Override
	public List<MemberVO> getAllMember() throws RemoteException {
		return adDao.getAllMember();
	}

	@Override
	public List<MemberVO> getAllCom() throws RemoteException {
		return adDao.getAllCom();
	}
	@Override
	public List<ReadyComVO> getReadyCom() throws RemoteException {
		return adDao.getReadyCom();
	}

	@Override
	public int insertJoinCom1(ReadyComVO rcvo) throws RemoteException {
		return adDao.insertJoinCom1(rcvo);
	}

	@Override
	public int insertJoinCom2(ReadyComVO rcvo) throws RemoteException {
		return adDao.insertJoinCom2(rcvo);
	}

	@Override
	public int deleteJoinCom(ReadyComVO rcvo) throws RemoteException {
		return adDao.deleteJoinCom(rcvo);
	}

	@Override
	public List<MemberVO> getReadyBlackMember() throws RemoteException {
		return adDao.getReadyBlackMember();
	}
	@Override
	public List<MemberVO> getAllBlackMember() throws RemoteException {
		return adDao.getAllBlackMember();
	}

	@Override
	public int insertBlackMember(MemberVO mvo) throws RemoteException {
		return adDao.insertBlackMember(mvo);
	}

	@Override
	public int deleteBlackMember(MemberVO mvo) throws RemoteException {
		return adDao.deleteBlackMember(mvo);
	}

	@Override
	public List<MemberVO> getReadyHolicMember() throws RemoteException {
		return adDao.getReadyHolicMember();
	}
	@Override
	public List<MemberVO> getAllHolicMember() throws RemoteException {
		return adDao.getAllHolicMember();
	}

	@Override
	public int insertHolicMember(MemberVO mvo) throws RemoteException {
		return adDao.insertHolicMember(mvo);
	}

	@Override
	public int deleteHolicMember(MemberVO mvo) throws RemoteException {
		return adDao.deleteHolicMember(mvo);
	}

	@Override
	public List<MemberVO> getAllGoodCom() throws RemoteException {
		return adDao.getAllGoodCom();
	}

	
	
			
	
	
	

}
