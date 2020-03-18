package kr.or.ddit.hl.dao.cust;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hl.util.SqlMapClientFactory;
import kr.or.ddit.hl.vo.CustomerCenterVO;

public class CustDaoImpl implements ICustDao{
	
	private SqlMapClient smc;
	private static ICustDao dao;
	
	private CustDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ICustDao getInstance() {
		if (dao == null) {
			dao = new CustDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public boolean insertCust(CustomerCenterVO cust){
		
		boolean result = false;
		
		try {
			int res = (Integer)smc.insert("cust.insertCust", cust);
			if(res > 0) {
				result = true;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean updateCust(CustomerCenterVO cust){
		
		boolean result = false;
		
		try {
			int res = (Integer)smc.update("cust.updateCust", cust);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean deleteCust(int no) {

		boolean result = false;
		
		try {
			int res = (Integer)smc.delete("cust.deleteCust", no);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//글 가져오기
	@Override
	public CustomerCenterVO selectCust(int no){

		CustomerCenterVO vo = null;
		
		try {
			vo = (CustomerCenterVO)
					smc.queryForObject("cust.selectCust", no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	//글 모두 가져오기
	@Override
	public List<CustomerCenterVO> getAllCustList() {
		
		List<CustomerCenterVO> list = null;
		
		try {
			list = (List<CustomerCenterVO>)smc.queryForList
					("cust.getAllCustList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	@Override
	public List<CustomerCenterVO> getSearchCust(CustomerCenterVO cust) {
		
		List<CustomerCenterVO> list = null;
		
		try {
			list = (List<CustomerCenterVO>)smc.queryForList
					("cust.getSearchCust", cust);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
