package kr.or.ddit.hl.dao.join;

import java.rmi.RemoteException;
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hl.dao.join.JoinDaoImpl;
import kr.or.ddit.hl.vo.MemberVO;
import kr.or.ddit.hl.util.SqlMapClientFactory;

public class JoinDaoImpl implements IJoinDao {
	
	private SqlMapClient smc;
	
	private static IJoinDao dao;
	
	private JoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IJoinDao getInstance() {
		if (dao == null) {
			dao = new JoinDaoImpl();
		}
		return dao;
	}
	
	
	//아이디 중복 확인
	@Override
	public boolean selectId(String id) throws RemoteException {
		
		boolean result = false;
		
		try {
			MemberVO mem = (MemberVO)smc.queryForObject("join.selectId", id);
			if(mem == null) {
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
	public boolean selectNick(String id) throws RemoteException {
		
		boolean result = false;
		
		try {
			MemberVO mem = (MemberVO)smc.queryForObject("join.selectNick", id);
			if(mem == null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//회원가입 완료
	@Override
	public boolean insertMember(MemberVO mv) throws RemoteException {
		
		boolean result = false;
		
		try {
			String res = (String)smc.insert("join.insertMember", mv);
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
