package kr.or.ddit.mp.dao.salescom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.SalesVO;

public class SalesComDaoImpl implements ISalesComDao {
	private SqlMapClient smc;
	
	private static SalesComDaoImpl dao;
	private SalesComDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
		
	
	public static SalesComDaoImpl getInstance() {
		if(dao == null) {
			dao = new SalesComDaoImpl();
		}
		
		return dao;	
	}


	@Override
	public List<SalesVO> getSalesComEatdeal(String word) {
		ArrayList<SalesVO> List = new ArrayList<SalesVO>();
		try {
			List = (ArrayList<SalesVO>) smc.queryForList("salescom.salesList", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	
}
