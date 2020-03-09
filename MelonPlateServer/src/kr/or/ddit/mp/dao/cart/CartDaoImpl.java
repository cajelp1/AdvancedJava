package kr.or.ddit.mp.dao.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.cart.CartVO;
import kr.or.ddit.mp.vo.cart.EatdealVO;
import kr.or.ddit.mp.vo.cart.MileageVO;
import kr.or.ddit.mp.vo.cart.PayVO;
import kr.or.ddit.mp.vo.cart.RequestVO;



public class CartDaoImpl implements ICartDao {
	
private static SqlMapClient smc;
	
	private static CartDaoImpl dao;
	
	private CartDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static CartDaoImpl getInstance() {
			
			if(dao == null) {
				dao = new CartDaoImpl();
			}
			
			return dao;
		}
	
	@Override
	public int deleteCart(CartVO cvo){
		int cnt = 0;
		try {
			cnt = smc.delete("deleteCart", cvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int insertCart(CartVO cvo) {
		int cnt = 0;
		try {
			cnt = smc.update("insertCart", cvo);

		}catch(SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<CartVO> getAllCartList(CartVO cvo) {
		List<CartVO> cartList = null;
		try {
			cartList = (List<CartVO>)smc.queryForList("getAllCartList",cvo);
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
			cartList = null;
			e.printStackTrace();
		}
		
		return cartList;
	}

	@Override
	public List<CartVO> getEatdealName(CartVO cvo) {
		List<CartVO> cartList = null;
		try {
			cartList = (List<CartVO>) smc.queryForList("getEatdealName", cvo);

		}catch(SQLException e) {
			cartList = null;
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public List<MileageVO> getMileage(MileageVO mvo) {
		ArrayList<MileageVO> mileList = null;
		try {
			mileList = (ArrayList<MileageVO>) smc.queryForList("getMileage", mvo);
		} catch (SQLException e) {
			mileList = null;
			e.printStackTrace();
		}
		return mileList;
	}
	
	@Override
	public List<CartVO> getEatdealprice(CartVO cvo) {
		ArrayList<CartVO> cartList = null;
		try {
			cartList = (ArrayList<CartVO>) smc.queryForList("getEatdealprice", cvo);

		}catch(SQLException e) {
			cartList = null;
			e.printStackTrace();
		}
		return cartList;
	}
	
	@Override
	public List<RequestVO> requestSelect(String word) {
		ArrayList<RequestVO> List = new ArrayList<RequestVO>();
		try {
			List = (ArrayList<RequestVO>) smc.queryForList("requestSelect", word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public List<EatdealVO> getEatdealInfo(CartVO cvo) {
		ArrayList<EatdealVO> List = new ArrayList<EatdealVO>();
		try {
			List = (ArrayList<EatdealVO>) smc.queryForList("getEatdealInfo", cvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public int requestPayInsert(RequestVO revo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("requestPayInsert", revo);
			
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
	public int payInsert(PayVO pvo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("payInsert", pvo);
			
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
	public int mileNotuseInsert(MileageVO mvo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("mileNotuseInsert", mvo);
			
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
	public int mileUseInsert(MileageVO mvo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("mileUseInsert", mvo);
			
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
	public int eatdealQtyDown(EatdealVO evo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("eatdealQtyDown", evo);
			
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
	
	public static void main(String[] args) {
		CartDaoImpl dao = new CartDaoImpl();
		ArrayList<MileageVO> mlist = null;
		MileageVO mvo = new MileageVO();
		
		mvo.setMem_no("1");
		mlist = (ArrayList<MileageVO>) dao.getMileage(mvo);
		System.out.println(mlist.size());
	}
	
}
