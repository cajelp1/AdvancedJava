package kr.or.ddit.mp.dao.home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;

public class HomeDaoImpl implements IHomeDao {
	private SqlMapClient smc;
	
	private static HomeDaoImpl dao;
	
	private HomeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static HomeDaoImpl getInstance() {
		
		if(dao == null) {
			dao = new HomeDaoImpl();
		}
		
		return dao;
	}

	@Override
	public List<MemberVO> homeBestTop10() {
		ArrayList<MemberVO> coList = new ArrayList<MemberVO>();
		
		try {
			coList = (ArrayList<MemberVO>) smc.queryForList("home.homeBestTop10");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coList;
	}

	@Override
	public List<ZoneVO> myZoneSelect(String word) {
		ArrayList<ZoneVO> coList = new ArrayList<ZoneVO>();
		
		try {
			coList = (ArrayList<ZoneVO>) smc.queryForList("home.myZoneSelect", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coList;
	}

	@Override
	public List<EatdealVO> homeEatBest5() {
		ArrayList<EatdealVO> coList = new ArrayList<EatdealVO>();
		
		try {
			coList = (ArrayList<EatdealVO>) smc.queryForList("home.homeEatBest5");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coList;
	}

	@Override
	public List<ComVO> homeComeBest5(ZoneVO vo) {
		ArrayList<ComVO> coList = new ArrayList<ComVO>();
		
		try {
			coList = (ArrayList<ComVO>) smc.queryForList("home.homeComeBest5", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coList;
	}
	
	public static void main(String[] args) {
		MemberVO vo = new MemberVO();
		HomeDaoImpl dao = new HomeDaoImpl();
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) dao.homeBestTop10();
		System.out.println(list.size());
	}
}
