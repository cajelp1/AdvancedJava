package kr.or.ddit.hl.dao.join;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hl.util.SqlMapClientFactory;
import kr.or.ddit.hl.vo.LawfirmVO;
import kr.or.ddit.hl.vo.LawyerVO;
import kr.or.ddit.hl.vo.MemberVO;

public class LawJoinDaoImpl implements ILawJoinDao {
	
	private SqlMapClient smc;
	private static ILawJoinDao dao;
	
	private LawJoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILawJoinDao getInstance() {
		if(dao == null) {
			dao = new LawJoinDaoImpl();
		}
		return dao;
	}
	
	
	//아이디 중복 확인
	@Override
	public boolean selectId(String id) {
		
		boolean result = false;
		
		try {
			LawyerVO lv = (LawyerVO)smc.queryForObject("lawjoin.selectId", id);
			if(lv == null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//닉네임 중복 확인
	@Override
	public boolean selectNick(String nick) {
		
		boolean result = false;
		
		try {
			LawyerVO lv = (LawyerVO)smc.queryForObject("lawjoin.selectNick", nick);
			if(lv == null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//로펌 정보 확인
	@Override
	public boolean selectLawfirm(LawfirmVO lfv) {
		
		boolean result = false;
		
		try {
			LawfirmVO lfv2 = (LawfirmVO)smc.queryForObject("lawjoin.selectLawfirm", lfv);
			if(lfv2 != null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//회원가입 완료시키기
	@Override
	public boolean insertLawyer(LawyerVO lv) {

		boolean result = false;
		
		try {
			String res = (String)smc.insert("lawjoin.insertLawyer", lv);
			if(res != null) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
}
