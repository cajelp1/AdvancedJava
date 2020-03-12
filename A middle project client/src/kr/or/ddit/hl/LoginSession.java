package kr.or.ddit.hl;

import kr.or.ddit.hl.vo.LawyerVO;
import kr.or.ddit.hl.vo.MemberVO;

public class LoginSession {
	
	// 로그인 정보를 임시저장하는 MemberVO 객체
	// 로그아웃시 null로 만들어줘야 함.
	public static MemberVO memSession = new MemberVO();
	public static LawyerVO lawSession = new LawyerVO();
	public static int ch_up = 0;
	public static int ch_down = 0;
	public static boolean isClicked = false;
	
}
