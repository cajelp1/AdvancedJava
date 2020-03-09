package kr.or.ddit.mp.dao.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.admin.BlackVO;
import kr.or.ddit.mp.vo.admin.ComVO;
import kr.or.ddit.mp.vo.admin.MemberVO;
import kr.or.ddit.mp.vo.admin.ReadyComVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class AdminDapImpl implements IAdminDao {

	private SqlMapClient smc;

	private static AdminDapImpl dao  = new AdminDapImpl();

	private AdminDapImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static AdminDapImpl getInstance() {
		if (dao == null) {
			dao = new AdminDapImpl();
		}
		return dao;
	}

	@Override
	public List<MemberVO> getAllMemberCom() {
		ArrayList<MemberVO> memAllList = new ArrayList<MemberVO>();

		try {
			memAllList = (ArrayList<MemberVO>) smc.queryForList("getAllMemberCom");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memAllList;
	}

	@Override
	public List<MemberVO> getAllMember() {
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();

		try {
			memList = (ArrayList<MemberVO>) smc.queryForList("getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memList;
	}

	@Override
	public int insertAdmin(MemberVO mvo) {
		int cnt = 0;

		try {
			cnt = smc.update("insertAdmin", mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteMember(MemberVO mvo) {
		int cnt = 0;
		try {

			cnt = smc.update("deleteMemberAdmin", mvo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public  List<MemberVO> getAllCom() {
		ArrayList<MemberVO> comList = new ArrayList<MemberVO>();

		try {
			comList = (ArrayList<MemberVO>) smc.queryForList("getAllCom");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comList;
	}
	@Override
	public List<ReadyComVO> getReadyCom() {
		ArrayList<ReadyComVO> comList = new ArrayList<ReadyComVO>();

		try {
			comList = (ArrayList<ReadyComVO>) smc.queryForList("getReadyCom");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comList;
	}
	

	@Override
	public int insertJoinCom1(ReadyComVO rcvo) {
		int cnt = 0;

		try {
			cnt = smc.update("insertJoinCom1", rcvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	
	@Override
	public int insertJoinCom2(ReadyComVO rcvo) {
		int cnt = 0;

		try {
			cnt = smc.update("insertJoinCom2", rcvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteJoinCom(ReadyComVO rcvo) {
		int cnt = 0;
		try {

			cnt = smc.update("deleteJoinCom", rcvo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getReadyBlackMember() {
		ArrayList<MemberVO> blackMemList = new ArrayList<MemberVO>();

		try {
			blackMemList = (ArrayList<MemberVO>) smc.queryForList("getReadyBlackMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return blackMemList;
	}
	@Override
	public List<MemberVO> getAllBlackMember() {
		ArrayList<MemberVO> blackMemList = new ArrayList<MemberVO>();
		
		try {
			blackMemList = (ArrayList<MemberVO>) smc.queryForList("getAllBlackMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blackMemList;
	}

	@Override
	public int insertBlackMember(MemberVO mvo) {
		int cnt = 0;
		try {

			cnt = smc.update("insertBlackMember",mvo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteBlackMember(MemberVO mvo) {
		int cnt = 0;
		try {

			cnt = smc.update("deleteBlackMember", mvo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getReadyHolicMember() {
		ArrayList<MemberVO> holicMemList = new ArrayList<MemberVO>();

		try {
			holicMemList = (ArrayList<MemberVO>) smc.queryForList("getReadyHolicMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return holicMemList;
	}
	@Override
	public List<MemberVO> getAllHolicMember() {
		ArrayList<MemberVO> holicMemList = new ArrayList<MemberVO>();
		
		try {
			holicMemList = (ArrayList<MemberVO>) smc.queryForList("getAllHolicMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return holicMemList;
	}
	
	@Override
	public int insertHolicMember(MemberVO mvo) {
		int cnt = 0;
		try {

			cnt = smc.update("insertHolicMember", mvo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteHolicMember(MemberVO mvo) {
		int cnt = 0;
		try {

			cnt = smc.update("deleteHolicMember", mvo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getAllGoodCom() {
		ArrayList<MemberVO> goodComList = new ArrayList<MemberVO>();

		try {
			goodComList = (ArrayList<MemberVO>) smc.queryForList("getAllGoodCom");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return goodComList;
	}

	public static void main(String[] args) {
		ReadyComVO aa = new ReadyComVO(); 
		MemberVO mvo = new MemberVO();
		
		ArrayList<MemberVO> memlist = new ArrayList<MemberVO>();
		ArrayList<ComVO> comlist = new ArrayList<ComVO>();
		ArrayList<BlackVO> blacklist = new ArrayList<BlackVO>();
		
	
		//dao.insertHolicMember(mvo);
	dao.insertJoinCom2(aa);
		//memlist = (ArrayList<MemberVO>) dao.insertHolicMember(mvo);
		System.out.println(memlist.size());
		
		
	} 

}
