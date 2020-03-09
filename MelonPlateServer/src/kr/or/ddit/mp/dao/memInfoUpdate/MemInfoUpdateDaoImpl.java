package kr.or.ddit.mp.dao.memInfoUpdate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.memInfoUpdate.MemberVO;
import kr.or.ddit.mp.vo.memInfoUpdate.ZiptbVO;

public class MemInfoUpdateDaoImpl implements IMemInfoUpdateDao {

	private SqlMapClient smc;

	private static MemInfoUpdateDaoImpl dao  = new MemInfoUpdateDaoImpl();

	private MemInfoUpdateDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static MemInfoUpdateDaoImpl getInstance() {
		if (dao == null) {
			dao = new MemInfoUpdateDaoImpl();
		}
		return dao;
	}
	
	@Override
	public MemberVO getPw(MemberVO mvo) {
		MemberVO vo = new MemberVO();
		try {
			vo =  (MemberVO) smc.queryForObject("getMemPw",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public MemberVO getDefaultInfo(MemberVO mvo) {
		MemberVO vo = new MemberVO();
		
		try {
			vo = (MemberVO) smc.queryForObject("getMemDefaultInfo",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
		
	}
	
	@Override
	public MemberVO getNickCheck(String str) {
		
		MemberVO vo = new MemberVO();

		try {
			vo = (MemberVO) smc.queryForObject("getNickCheck", str);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	@Override
	public List<ZiptbVO> getSearchZipCode(ZiptbVO zvo) {
		ArrayList<ZiptbVO> zipCodeList = new ArrayList<ZiptbVO>();

		try {
			zipCodeList = (ArrayList<ZiptbVO>) smc.queryForList("getMemSearchZipCode",zvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return zipCodeList;
	}
	
	@Override
	public int deleteMember(MemberVO mvo) {
		int cnt = 0;

		try {
			cnt = smc.update("deleteMember", mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	
	@Override
	public int updateMember(MemberVO mvo) {
		int cnt = 0;

		try {
			cnt = smc.update("updateMember", mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	

}
