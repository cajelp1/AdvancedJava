package kr.or.ddit.hl.join.service;

import java.rmi.RemoteException;

import kr.or.ddit.hl.join.dao.IJoinDao;
import kr.or.ddit.hl.join.dao.JoinDaoImpl;
import kr.or.ddit.hl.vo.MemberVO;

public class JoinServiceImpl implements IJoinService {
	
	private static IJoinService service;
	private IJoinDao dao;
	
	private JoinServiceImpl() {
		dao = JoinDaoImpl.getInstance();
	}
	
	public static IJoinService getInstance() {
		if(service == null) {
			service = new JoinServiceImpl();
		}
		return service;
	}
	
	@Override
	public boolean selectId(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectNick(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMember(MemberVO mv) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
