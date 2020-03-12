package kr.or.ddit.hl.dao.join;

import kr.or.ddit.hl.vo.LawfirmVO;
import kr.or.ddit.hl.vo.LawyerVO;

public interface ILawJoinDao {
	
	//아이디 중복 확인
	public boolean selectId(String id);
	
	//닉네임 중복 확인
	public boolean selectNick(String nick);
	
	//로펌 존재여부 확인
	public boolean selectLawfirm(LawfirmVO lfv);
	
	//변호사 가입
	public boolean insertLawyer(LawyerVO lv);
	
}
