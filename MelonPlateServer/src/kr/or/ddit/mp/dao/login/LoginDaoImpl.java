package kr.or.ddit.mp.dao.login;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;

public class LoginDaoImpl implements ILoginDao {

	private SqlMapClient smc;
	
	private static LoginDaoImpl dao;
	private LoginDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static LoginDaoImpl getInstance() {
		if (dao == null) {
			dao = new LoginDaoImpl();
		}
		return dao;
	}
	
	
	//vo로 던져 
	@Override
	public List<MemberVO> memberLogin(MemberVO mv) {
		List<MemberVO> memberList = null;
		
		//vo로 받아
		try {
			memberList = (List<MemberVO>) smc.queryForList("login.select", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	
	@Override
	public List<MemberVO> idSearch(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>)smc.queryForList("login.idSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	@Override
	public List<MemberVO> memNoSearch(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>)smc.queryForList("login.memnoSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	@Override
	public List<MemberVO> pwSearch(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>)smc.queryForList("login.pwSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return memberList;
	}

	@Override
	public List<ComVO> iscom(String mem_no) throws RemoteException {
		
		List<ComVO> memberList = new ArrayList<ComVO>();
		try {
			memberList = (List<ComVO>)smc.queryForList("login.iscom", mem_no);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return memberList;
	}
	
	
	/*
	public static void main(String[] args) {
		LoginDaoImpl lodao = new LoginDaoImpl();
		String mem_id = "d007";
		String mem_pw = "asdf";
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(mem_id);
		mvo.setMem_pw(mem_pw);
 		ArrayList<MemberVO> list = new ArrayList<>();
		list = (ArrayList<MemberVO>) lodao.memberLogin(mvo);
		System.out.println(list.size());
		list = (ArrayList<MemberVO>) lodao.memNoSearch(mvo);
		System.out.println(list.size());
	}
	 */
	
}



