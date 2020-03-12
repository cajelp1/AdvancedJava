package kr.or.ddit.hl.service.join;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import kr.or.ddit.hl.dao.join.IJoinDao;
import kr.or.ddit.hl.dao.join.JoinDaoImpl;
import kr.or.ddit.hl.util.AES256Util;
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
		
		//패스워드 , 주민번호 암호화해서 저장
		try {
			AES256Util aes = new AES256Util();
			
			String enc = aes.encrypt(mv.getMem_password());
			mv.setMem_password(enc);
			enc = aes.encrypt(mv.getMem_jumin_no());
			mv.setMem_jumin_no(enc);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dao.insertMember(mv);
	}

}
