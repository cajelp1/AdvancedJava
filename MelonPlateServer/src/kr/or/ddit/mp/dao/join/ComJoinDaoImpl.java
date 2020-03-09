package kr.or.ddit.mp.dao.join;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.member.ReadyComVO;
import kr.or.ddit.mp.vo.zipcode.ZipcodeVO;

public class ComJoinDaoImpl implements IComJoinDao{
private SqlMapClient smc;
	
	private static ComJoinDaoImpl dao;
	private ComJoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();	
	}
	
	public static ComJoinDaoImpl getInstance() {
		if (dao == null) {
			dao = new ComJoinDaoImpl();
		}
		return dao;
	}
	

	@Override
	public List<MemberVO> selectId(MemberVO mvo) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("comjoin.idSearch", mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public List<MemberVO> selectNick(MemberVO mvo) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("comjoin.nickSearch", mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public List<ZipcodeVO> selectZipcode(ZipcodeVO zv) {
		List<ZipcodeVO> zipcodeList = new ArrayList<ZipcodeVO>();
		try {
			zipcodeList = (List<ZipcodeVO>)  smc.queryForList("comjoin.zipSearch",zv); // 얘도 원래 안떳음
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}

	@Override
	public List<ComVO> selectComId(ComVO cvo)  {
		List<ComVO> CommemberList = new ArrayList<ComVO>();
		try {
			CommemberList = (List<ComVO>) smc.queryForList("comjoin.comidSearch", cvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CommemberList;
	}

	@Override
	public int insertReadyComMember(ReadyComVO rvo) {
		int cnt = 0;
		try {
//			Object obj = smc.insert("comjoin.insertReadyComMember", rvo);
			cnt = smc.update("comjoin.insertReadyComMember", rvo);
//			cnt = (int) smc.insert("comjoin.insertReadyComMember", rvo);
			if(cnt > 0) {
//				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	


	public static void main(String[] args) {
		ReadyComVO cvo = new ReadyComVO();
		ComJoinDaoImpl dao = new ComJoinDaoImpl();
		
		
		int c = dao.insertReadyComMember(cvo);
		
		System.out.println(c);
	}

}
