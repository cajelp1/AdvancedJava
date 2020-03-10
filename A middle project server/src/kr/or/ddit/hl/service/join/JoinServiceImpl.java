package kr.or.ddit.hl.service.join;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.hl.dao.join.IJoinDao;
import kr.or.ddit.hl.dao.join.JoinDaoImpl;
import kr.or.ddit.hl.vo.MemberVO;

public class JoinServiceImpl extends UnicastRemoteObject implements IJoinService {

	private static IJoinService service;
	private IJoinDao dao;
	
	
	protected JoinServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		dao = JoinDaoImpl.getInstance();
	}
	
	public static IJoinService getInstance() throws RemoteException {
		if(service == null) {
			service = new JoinServiceImpl();
		}
		return service;
	}
	
	@Override
	public boolean selectId(String id) throws RemoteException {

		return dao.selectId(id);
	}

	@Override
	public boolean selectNick(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectNick(id);
	}

	@Override
	public boolean insertMember(MemberVO mv) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.insertMember(mv);
	}

}
