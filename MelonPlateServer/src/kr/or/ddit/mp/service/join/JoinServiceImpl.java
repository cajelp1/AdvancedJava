package kr.or.ddit.mp.service.join;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.join.JoinDaoImpl;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.zipcode.ZipcodeVO;

public class JoinServiceImpl extends UnicastRemoteObject implements IJoinService{

	private JoinDaoImpl joinDao;
	private static JoinServiceImpl service;
	
	private JoinServiceImpl() throws RemoteException{
		super();
		joinDao = JoinDaoImpl.getInstance();
	}
	
	public static JoinServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new JoinServiceImpl();
		}
		return service;
	}

	@Override
	public List<MemberVO> selectId(MemberVO mv) throws RemoteException {
		return joinDao.selectId(mv);
	}

	@Override
	public List<MemberVO> selectNick(MemberVO mv) throws RemoteException {
		return joinDao.selectNick(mv);
	}

	@Override
	public List<ZipcodeVO> selectZipcode(ZipcodeVO zv) throws RemoteException {
		return joinDao.selectZipcode(zv);
	}

	@Override
	public int insertMember(MemberVO mv) {
		return joinDao.insertMember(mv);
	}

}
