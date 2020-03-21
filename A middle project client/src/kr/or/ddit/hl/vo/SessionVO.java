package kr.or.ddit.hl.vo;

public class SessionVO {
	public static String id;
	public static String name;
	public static String nickname;
	public static int roleCode;
	public static String hpNumber;
	
	public static boolean isLogin; //로그인 여부를 알 수 있는 변수
	/*
	 * public static SessionVO getInstance() { if(session==null) session=new
	 * SessionVO(); return session; }
	 */
	

	//스태틱 변수만 있므로 getter setter가 필요없음
}
