package kr.or.ddit.mp.dao.goodcom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;

public class GoodcomDaoImpl implements IGoodcomDao {
	private SqlMapClient smc;
	
	private static GoodcomDaoImpl dao;
	
	private GoodcomDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static GoodcomDaoImpl getInstance() {
		
		if(dao == null) {
			dao = new GoodcomDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public List<ComVO> getSearchGoodCom(ComVO cv) {
		ArrayList<ComVO> coList = new ArrayList<ComVO>();
		
		try {
			coList = (ArrayList<ComVO>) smc.queryForList("goodCom.searchGoodCom", cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coList;
	}
	
	public static void main(String[] args) {
		ComVO vo = new ComVO();
		GoodcomDaoImpl dao = new GoodcomDaoImpl();
		vo.setCom_id("155-89-45875");
		ArrayList<ComVO> list = (ArrayList<ComVO>) dao.getSearchGoodCom(vo);
		System.out.println(list.get(0).getCom_addr());
	}

	@Override
	public List<MemberVO> isVipCom(String word) {
		
		
		ArrayList<MemberVO> coList = new ArrayList<MemberVO>();
		
		try {
			coList = (ArrayList<MemberVO>) smc.queryForList("goodCom.isVipCom", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coList;
	}

}
