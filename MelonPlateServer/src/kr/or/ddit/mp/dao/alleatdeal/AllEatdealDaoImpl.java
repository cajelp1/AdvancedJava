package kr.or.ddit.mp.dao.alleatdeal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;


public class AllEatdealDaoImpl implements IAllEatdealDao {
	private SqlMapClient smc;
	private static AllEatdealDaoImpl dao;
	private AllEatdealDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static AllEatdealDaoImpl getInstance() {
		if(dao == null) {
			dao = new AllEatdealDaoImpl();
		}
		
		return dao;	
	}

	@Override
	public List<EatdealVO> eatlistByMyzone(ZoneVO vo) {
		ArrayList<EatdealVO> List = new ArrayList<EatdealVO>();
		try {
			List = (ArrayList<EatdealVO>) smc.queryForList("alleatdeal.eatlistByMyzone", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public List<EatdealVO> eatlistByQty() {
		ArrayList<EatdealVO> List = new ArrayList<EatdealVO>();
		try {
			List = (ArrayList<EatdealVO>) smc.queryForList("alleatdeal.eatlistByQty");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public List<ZoneVO> zoneForlist(String word) {
		ArrayList<ZoneVO> List = new ArrayList<ZoneVO>();
		try {
			List = (ArrayList<ZoneVO>) smc.queryForList("alleatdeal.zoneForlist", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public List<EatdealVO> eatlistByNew() {
		ArrayList<EatdealVO> List = new ArrayList<EatdealVO>();
		try {
			List = (ArrayList<EatdealVO>) smc.queryForList("alleatdeal.eatlistByNew");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	
}
