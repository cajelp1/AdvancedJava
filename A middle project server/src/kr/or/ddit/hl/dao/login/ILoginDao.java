package kr.or.ddit.hl.dao.login;

import kr.or.ddit.hl.vo.LawyerVO;
import kr.or.ddit.hl.vo.MemberVO;

public interface ILoginDao {
	
	//회원 로그인
	public MemberVO memLogin(MemberVO mv);
	
	//변호사 로그인
	public LawyerVO lawLogin(LawyerVO lv);
	
	//회원 아이디 찾기
	public String findMId(MemberVO mv);
	
	//변호사 아이디 찾기
	public String findLId(LawyerVO lv);
	
	//회원 비밀번호 찾기
	public String findMPass(MemberVO mv);
	
	//변호사 비밀번호 찾기
	public String findLPass(LawyerVO lv);
	
}
