package kr.or.ddit.mp.dao.join;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.zipcode.ZipcodeVO;

public class JoinDaoImpl implements IJoinDao {
	
	private SqlMapClient smc;
	
	private static JoinDaoImpl dao;
	private JoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static JoinDaoImpl getInstance() {
		if (dao == null) {
			dao = new JoinDaoImpl();
		}
		return dao;
	}
	
	

	@Override
	public List<MemberVO> selectId(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("join.idSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public List<MemberVO> selectNick(MemberVO mv) throws RemoteException {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("join.nickSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public List<ZipcodeVO> selectZipcode(ZipcodeVO zv) throws RemoteException {
		List<ZipcodeVO> zipcodeList = new ArrayList<ZipcodeVO>();
		try {
			zipcodeList = (List<ZipcodeVO>)  smc.queryForList("join.zipSearch",zv); // 얘도 원래 안떳음
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("join.insertMember", mv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}
	
	public static void main(String[] args) throws RemoteException {
		JoinDaoImpl daao = new JoinDaoImpl();
		ZipcodeVO zv = new ZipcodeVO();
		ArrayList<ZipcodeVO> list = new ArrayList<>();
		zv.setDong("도곡");
		list = (ArrayList<ZipcodeVO>) daao.selectZipcode(zv);
		System.out.println(list.size());
	}

	
}
