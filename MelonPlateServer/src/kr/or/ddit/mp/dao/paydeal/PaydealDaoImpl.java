package kr.or.ddit.mp.dao.paydeal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.eatdeal.PayVO;
import kr.or.ddit.mp.vo.eatdeal.RequestVO;
import kr.or.ddit.mp.vo.mypage.MileageVO;

public class PaydealDaoImpl implements IPaydealDao {
	private SqlMapClient smc;
	private static PaydealDaoImpl dao;
	private PaydealDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static PaydealDaoImpl getInstance() {
		if(dao == null) {
			dao = new PaydealDaoImpl();
		}
		
		return dao;	
	}

	@Override
	public int requestPayInsert(RequestVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payeatdeal.requestPayInsert", vo);
			
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
	public int requestCartInsert(RequestVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payeatdeal.requestCartInsert", vo);
			
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
	public List<RequestVO> requestSelect(String word) {
		ArrayList<RequestVO> List = new ArrayList<RequestVO>();
		try {
			List = (ArrayList<RequestVO>) smc.queryForList("payeatdeal.requestSelect", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public int payInsert(PayVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payeatdeal.payInsert", vo);
			
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
	public int mileNotuseInsert(MileageVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payeatdeal.mileNotuseInsert", vo);
			
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
	public int mileUseInsert(MileageVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payeatdeal.mileUseInsert", vo);
			
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
	public int eatdealQtyDown(EatdealVO vo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payeatdeal.eatdealQtyDown", vo);
			
			if(cnt > 0) {
				System.out.println("업데이트 성공");
			}else {
				System.out.println("업데이트 실패!");
			}

		}catch(SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
}
