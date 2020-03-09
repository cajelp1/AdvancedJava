package kr.or.ddit.mp.dao.mypageEatDealQnA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.mypageEatDealQnA.EatqaVO;

public class MypageEatDealQnADaoImpl implements IMypageEatDealQnADao {

	private SqlMapClient smc;

	private static MypageEatDealQnADaoImpl dao  = new MypageEatDealQnADaoImpl();

	private MypageEatDealQnADaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static MypageEatDealQnADaoImpl getInstance() {
		if (dao == null) {
			dao = new MypageEatDealQnADaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public List<EatqaVO> getMyEatDealQnA(EatqaVO evo) {
		
		ArrayList<EatqaVO> eatDealQnA = new ArrayList<EatqaVO>();

		try {
			eatDealQnA = (ArrayList<EatqaVO>) smc.queryForList("getMyEatDealQnA",evo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eatDealQnA;
	}
  	
	

}
