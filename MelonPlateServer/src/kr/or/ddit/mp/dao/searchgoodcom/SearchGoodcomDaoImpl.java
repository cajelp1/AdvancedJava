package kr.or.ddit.mp.dao.searchgoodcom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.member.ComVO;

public class SearchGoodcomDaoImpl implements ISearchGoodcomDao {
	private SqlMapClient smc;
	
	private static SearchGoodcomDaoImpl dao;
	
	private SearchGoodcomDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static SearchGoodcomDaoImpl getInstance() {
		if(dao == null) {
			dao = new SearchGoodcomDaoImpl();
			
		}
		
		return dao;
	}
	
	@Override
	public List<ComVO> getResultGoodCom(String word) {
		
		ArrayList<ComVO> resultList = new ArrayList<ComVO>();
		
		try {
			resultList = (ArrayList<ComVO>) smc.queryForList("searchGoodcom.resultSearch", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	public static void main(String[] args) {
		ComVO vo = new ComVO();
		SearchGoodcomDaoImpl dao = new SearchGoodcomDaoImpl();
		String se = "대흥";
		ArrayList<ComVO> list = (ArrayList<ComVO>) dao.getResultGoodCom(se);
		System.out.println(list.size());
	}

}
