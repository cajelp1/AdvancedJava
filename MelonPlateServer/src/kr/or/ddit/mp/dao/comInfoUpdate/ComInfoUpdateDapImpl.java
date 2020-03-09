package kr.or.ddit.mp.dao.comInfoUpdate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.comInfoUpdate.ComVO;
import kr.or.ddit.mp.vo.comInfoUpdate.MemberVO;
import kr.or.ddit.mp.vo.comInfoUpdate.ZiptbVO;

public class ComInfoUpdateDapImpl implements IComInfoUpdateDao {

	private SqlMapClient smc;

	private static ComInfoUpdateDapImpl dao  = new ComInfoUpdateDapImpl();

	private ComInfoUpdateDapImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static ComInfoUpdateDapImpl getInstance() {
		if (dao == null) {
			dao = new ComInfoUpdateDapImpl();
		}
		return dao;
	}
	
	@Override
	public MemberVO getPw(MemberVO mvo) {
		MemberVO vo = new MemberVO();
		try {
			vo =  (MemberVO) smc.queryForObject("getComPw",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public ComVO getDefaultInfo(ComVO mvo) {
		ComVO vo = new ComVO();
		
		try {
			vo = (ComVO) smc.queryForObject("getComDefaultInfo",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
		
	}
	

	@Override
	public List<ZiptbVO> getSearchZipCode(ZiptbVO zvo) {
		ArrayList<ZiptbVO> zipCodeList = new ArrayList<ZiptbVO>();

		try {
			zipCodeList = (ArrayList<ZiptbVO>) smc.queryForList("getComSearchZipCode",zvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return zipCodeList;
	}
	

	
	@Override
	public int updateCom(ComVO mvo) {
		int cnt = 0;

		try {
			cnt = smc.update("updateCom", mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	
	@Override
	public int updatePhoto(ComVO cvo) {
		int cnt = 0;

		try {
			cnt = smc.update("updatePhoto", cvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	

}
