package kr.or.ddit.mp.dao.recogeatdeal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.recogeatdeal.EatdealVO;


public class RecogeatdealDaoImpl implements IRecogeatdealDao {
	
private static SqlMapClient smc;
	
	private static RecogeatdealDaoImpl dao;
	
	private RecogeatdealDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static RecogeatdealDaoImpl getInstance() {
			
			if(dao == null) {
				dao = new RecogeatdealDaoImpl();
			}
			
			return dao;
		}
	

	@Override
	public List<EatdealVO> getAllEatList() {
		List<EatdealVO> eatList = null;
		try {
			eatList = (List<EatdealVO>)smc.queryForList("getAllEatList");
//			for(BoardVO boVO: boList) {
//				System.out.println("글번호 : " + boVO.getBoard_no());
//				System.out.println("글제목 : " + boVO.getBoard_title());
//				System.out.println("글쓴이 : " + boVO.getBoard_writer());
//				System.out.println("작성일자 : " + boVO.getBoard_date());
//				System.out.println("내 용 : " + boVO.getBoard_content());
//				
//				System.out.println("================================");
//			}
		}catch (SQLException e) {
			eatList = null;
			e.printStackTrace();
		}
		
		return eatList;
	}

	@Override
	public int updateOnY(EatdealVO evo) {
		int cnt = 0;
		try {
			cnt = smc.update("updateOnY", evo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateOnB(EatdealVO evo) {
		int cnt = 0;
		try {
			cnt = smc.update("updateOnB", evo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
	public static void main(String[] args) {
		RecogeatdealDaoImpl dao = new RecogeatdealDaoImpl();
		ArrayList<EatdealVO> list = new ArrayList<>();
		list = (ArrayList<EatdealVO>) dao.getAllEatList();
		System.out.println(list.size());
	}
}
