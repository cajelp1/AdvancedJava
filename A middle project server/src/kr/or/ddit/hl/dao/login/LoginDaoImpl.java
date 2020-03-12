package kr.or.ddit.hl.dao.login;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hl.util.SqlMapClientFactory;
import kr.or.ddit.hl.vo.LawyerVO;
import kr.or.ddit.hl.vo.MemberVO;

public class LoginDaoImpl implements ILoginDao {

	private SqlMapClient smc;
	
	private static ILoginDao dao;
	
	private LoginDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILoginDao getInstance() {
		if (dao == null) {
			dao = new LoginDaoImpl();
		}
		return dao;
	}
	
	@Override
	public MemberVO memLogin(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LawyerVO lawLogin(LawyerVO lv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findMId(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLId(LawyerVO lv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findMPass(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLPass(LawyerVO lv) {
		// TODO Auto-generated method stub
		return null;
	}

}
