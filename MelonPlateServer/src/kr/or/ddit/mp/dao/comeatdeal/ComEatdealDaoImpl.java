package kr.or.ddit.mp.dao.comeatdeal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;

public class ComEatdealDaoImpl implements IComEatdealDao {
	private SqlMapClient smc;
	private static ComEatdealDaoImpl dao;
	private ComEatdealDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
		
	
	public static ComEatdealDaoImpl getInstance() {
		if(dao == null) {
			dao = new ComEatdealDaoImpl();
		}
		
		return dao;	
	}
	
	@Override
	public List<EatdealVO> getComEatdealList(String word) {
		ArrayList<EatdealVO> List = new ArrayList<EatdealVO>();
		try {
			List = (ArrayList<EatdealVO>) smc.queryForList("comeatdeal.comList", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	public static void main(String[] args) {
		String a = "15-11";
		ComEatdealDaoImpl dao = new ComEatdealDaoImpl();
		ArrayList<EatdealVO> list = (ArrayList<EatdealVO>) dao.getComEatdealList(a);
		System.out.println(list.size());
	}


	@Override
	public int insertNewNoEatdeal(EatdealVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("comeatdeal.addeat", vo);
			
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
	public int deleteEatdeal(EatdealVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("comeatdeal.deleat", vo);
			
			if(cnt > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패!");
			}

		}catch(SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
