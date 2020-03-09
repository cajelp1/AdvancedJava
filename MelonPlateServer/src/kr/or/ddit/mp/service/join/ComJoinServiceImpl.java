package kr.or.ddit.mp.service.join;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.join.ComJoinDaoImpl;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.member.ReadyComVO;
import kr.or.ddit.mp.vo.zipcode.ZipcodeVO;

public class ComJoinServiceImpl extends UnicastRemoteObject implements IComJoinService {

	private ComJoinDaoImpl comjoinDao;
	private static ComJoinServiceImpl service;
	
	private ComJoinServiceImpl() throws RemoteException{
		super();
		comjoinDao = ComJoinDaoImpl.getInstance();
	}
	
	public static ComJoinServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new ComJoinServiceImpl();
		}
		return service;
	}

	@Override
	public List<MemberVO> selectId(MemberVO mvo) throws RemoteException {
		// TODO Auto-generated method stub
		return comjoinDao.selectId(mvo);
	}

	@Override
	public List<MemberVO> selectNick(MemberVO mvo) throws RemoteException {
		// TODO Auto-generated method stub
		return comjoinDao.selectNick(mvo);
	}

	@Override
	public List<ZipcodeVO> selectZipcode(ZipcodeVO zv) throws RemoteException {
		// TODO Auto-generated method stub
		return comjoinDao.selectZipcode(zv);
	}

	
	@Override
	public List<ComVO> selectComId(ComVO cvo) throws RemoteException {
		// TODO Auto-generated method stub
		return comjoinDao.selectComId(cvo);
	}


	@Override
	public int insertReadyComMember(ReadyComVO rvo) throws RemoteException {
		// TODO Auto-generated method stub
		return comjoinDao.insertReadyComMember(rvo);
	}

	

}
