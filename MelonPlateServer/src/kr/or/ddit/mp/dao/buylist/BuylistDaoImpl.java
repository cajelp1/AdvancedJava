package kr.or.ddit.mp.dao.buylist;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.buylist.LoginSession;
import kr.or.ddit.mp.vo.buylist.RequestVO;


public class BuylistDaoImpl implements IBuylisDao {
	
private static SqlMapClient smc;
	
	private static BuylistDaoImpl dao;
	
	private BuylistDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
		
	}
	
	public static BuylistDaoImpl getInstance() {
			
			if(dao == null) {
				dao = new BuylistDaoImpl();
			}
			
			return dao;
		}
	
	@Override
	public int deleteRequest(RequestVO rvo){
		int cnt = 0;
		try {
			cnt = smc.delete("deletebuylist", rvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	

	@Override
	public List<RequestVO> getAllBuyList(RequestVO rvo) {
		List<RequestVO> cartList = null;
		try {
			cartList = (List<RequestVO>)smc.queryForList("getAllbuyList",rvo);
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
	public int updateOrder_st(RequestVO rvo) {
		int cnt = 0;
		try {
			cnt = smc.update("updateOrder_st", rvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}
	
	
	public static void main(String[] args) {
		RequestVO rvo = new RequestVO();
		LoginSession session = new LoginSession();
		BuylistDaoImpl dao = new BuylistDaoImpl();
//		LoginSession.session.setMem_no("1"); //
//		rvo.setMem_no(LoginSession.session.getMem_no()); //
		rvo.setOrder_no("1");// 
		int cnt = dao.updateOrder_st(rvo); //
		System.out.println(cnt);
	}
		

	
	



}
