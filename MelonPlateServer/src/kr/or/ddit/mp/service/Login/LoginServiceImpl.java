package kr.or.ddit.mp.service.Login;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.login.LoginDaoImpl;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;

public class LoginServiceImpl extends UnicastRemoteObject implements ILoginService{

	private LoginDaoImpl loginDao;
	private static LoginServiceImpl service;
	
	protected LoginServiceImpl() throws RemoteException {
		super();
		loginDao = LoginDaoImpl.getInstance();
	}

	public static LoginServiceImpl getInstance () throws RemoteException {
		if (service == null) {
			service = new LoginServiceImpl();
		}
		
		return service;
		
	}
	@Override
	public List<MemberVO> memberLogin(MemberVO mv) throws RemoteException{
		return loginDao.memberLogin(mv);
	}

	@Override
	public List<MemberVO> idSearch(MemberVO mv) throws RemoteException {
		return loginDao.idSearch(mv);
	}

	@Override
	public List<MemberVO> memNoSearch(MemberVO mv) throws RemoteException {
		return loginDao.memNoSearch(mv);
	}

	@Override
	public List<MemberVO> pwSearch(MemberVO mv) throws RemoteException {
		return loginDao.pwSearch(mv);
	}

	@Override
	public List<ComVO> iscom(String mem_no) throws RemoteException {
		
		return loginDao.iscom(mem_no);
	}

	
}
