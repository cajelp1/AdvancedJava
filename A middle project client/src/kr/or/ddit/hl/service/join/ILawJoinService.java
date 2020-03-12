package kr.or.ddit.hl.service.join;

import java.rmi.Remote;
import java.rmi.RemoteException;

import kr.or.ddit.hl.vo.LawfirmVO;
import kr.or.ddit.hl.vo.LawyerVO;

public interface ILawJoinService extends Remote {
	
	//아이디 중복 확인
	public boolean selectId(String id) throws RemoteException;
	
	//닉네임 중복 확인
	public boolean selectNick(String nick) throws RemoteException;
	
	//로펌 존재여부 확인
	public boolean selectLawfirm(LawfirmVO lfv) throws RemoteException;
	
	//변호사 가입
	public boolean insertLawyer(LawyerVO lv) throws RemoteException;
	
}
