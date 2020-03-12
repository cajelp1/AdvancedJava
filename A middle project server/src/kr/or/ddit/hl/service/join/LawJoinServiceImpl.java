package kr.or.ddit.hl.service.join;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import kr.or.ddit.hl.dao.join.ILawJoinDao;
import kr.or.ddit.hl.dao.join.LawJoinDaoImpl;
import kr.or.ddit.hl.util.AES256Util;
import kr.or.ddit.hl.vo.LawfirmVO;
import kr.or.ddit.hl.vo.LawyerVO;

public class LawJoinServiceImpl extends UnicastRemoteObject implements ILawJoinService {
	
	private static ILawJoinService service;
	private ILawJoinDao dao;
	
	protected LawJoinServiceImpl() throws RemoteException {
		super();
		dao = LawJoinDaoImpl.getInstance();
	}
	
	public static ILawJoinService getInstance() throws RemoteException {
		if(service == null) {
			service = new LawJoinServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public boolean selectId(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public boolean selectNick(String nick) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectNick(nick);
	}

	@Override
	public boolean selectLawfirm(LawfirmVO lfv) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectLawfirm(lfv);
	}

	@Override
	public boolean insertLawyer(LawyerVO lv) throws RemoteException {
		
		//패스워드, 주민번호 암호화해서 저장
		try {
		AES256Util aes = new AES256Util();
		
			String enc = aes.encrypt(lv.getLaw_password());
			lv.setLaw_password(enc);
			enc = aes.encrypt(lv.getLaw_jumin_no());
			lv.setLaw_jumin_no(enc);
			
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
		
		return dao.insertLawyer(lv);
	}

}
