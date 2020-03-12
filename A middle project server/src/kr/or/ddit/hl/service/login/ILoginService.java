package kr.or.ddit.hl.service.login;

import java.rmi.Remote;
import java.rmi.RemoteException;

import kr.or.ddit.hl.vo.LawyerVO;
import kr.or.ddit.hl.vo.MemberVO;

public interface ILoginService extends Remote{
	

	//회원 로그인
	public MemberVO memLogin(MemberVO mv) throws RemoteException;
	
	//변호사 로그인
	public LawyerVO lawLogin(LawyerVO lv) throws RemoteException;
	
	//회원 아이디 찾기
	public String findMId(MemberVO mv) throws RemoteException;
	
	//변호사 아이디 찾기
	public String findLId(LawyerVO lv) throws RemoteException;
	
	//회원 비밀번호 찾기
	public String findMPass(MemberVO mv) throws RemoteException;
	
	//변호사 비밀번호 찾기
	public String findLPass(LawyerVO lv) throws RemoteException;
	
	
}
