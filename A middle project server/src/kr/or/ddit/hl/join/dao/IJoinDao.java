package kr.or.ddit.hl.join.dao;

import java.rmi.RemoteException;

import kr.or.ddit.hl.vo.MemberVO;

public interface IJoinDao {

	//아이디 중복 확인. true면 사용가능 false면 중복
	public boolean selectId(String id) throws RemoteException;
	
	//닉네임 중복 확인. true면 사용가능 false면 중복
	public boolean selectNick(String id) throws RemoteException;
	
	//멤버 추가하기. true면 추가성공 false면 추가 실패
	public boolean insertMember(MemberVO mv) throws RemoteException;
	
}
