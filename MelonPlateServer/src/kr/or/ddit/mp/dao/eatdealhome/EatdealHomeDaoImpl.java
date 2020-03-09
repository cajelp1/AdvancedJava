package kr.or.ddit.mp.dao.eatdealhome;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.CartVO;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.mypage.MileageVO;

public class EatdealHomeDaoImpl implements IEatdealHomeDao {
	private SqlMapClient smc;
	private static EatdealHomeDaoImpl dao;
	private EatdealHomeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static EatdealHomeDaoImpl getInstance() {
		if(dao == null) {
			dao = new EatdealHomeDaoImpl();
		}
		
		return dao;	
	}

	@Override
	public List<EatdealVO> getSelectEatdeal(String word) {
		ArrayList<EatdealVO> List = new ArrayList<EatdealVO>();
		try {
			List = (ArrayList<EatdealVO>) smc.queryForList("eatdealhome.selectEatdeal", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		EatdealVO vo = new EatdealVO();
		EatdealHomeDaoImpl dao = new EatdealHomeDaoImpl();
		
		String i = "9";
		ArrayList<EatdealVO> list = (ArrayList<EatdealVO>) dao.getSelectEatdeal(i);
		
		System.out.println(list.get(0).getEat_name());
	}

	@Override
	public int insertCartEatdeal(CartVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("eatdealhome.addcart", vo);
			
			if(cnt > 0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패!");
			}

		}catch(SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MileageVO> getMileageLast(String word) {
		ArrayList<MileageVO> List = new ArrayList<MileageVO>();
		try {
			List = (ArrayList<MileageVO>) smc.queryForList("eatdealhome.viewMil", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
}
