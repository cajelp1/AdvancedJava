package kr.or.ddit.mp.dao.matZip;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.matZip.ReviewVO;

public class MatZipDaoImpl implements IMatZipDao {

	private SqlMapClient smc;

	private static MatZipDaoImpl dao  = new MatZipDaoImpl();

	private MatZipDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static MatZipDaoImpl getInstance() {
		if (dao == null) {
			dao = new MatZipDaoImpl();
		}
		return dao;
	}
	
	
  	@Override
  	public List<ReviewVO> getGoodCom(ReviewVO rvo) {
  		
  		ArrayList<ReviewVO> goodCom = new ArrayList<>(); 
  		
  		try {
  			goodCom = (ArrayList<ReviewVO>) smc.queryForList("getGoodCom",rvo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
  		
  		return goodCom;
  	}
	
  	
   public static void main(String[] args) {
	ArrayList<ReviewVO> list = new ArrayList<>();
	ReviewVO vo = new ReviewVO();
	
	vo.setMem_no("57");
	
	list = (ArrayList<ReviewVO>) dao.getGoodCom(vo);
	
	list.get(0).getRe_no();
	
	
	
	System.out.println(list.get(0).getCom_name());
	
	
}
  	
  	
}
