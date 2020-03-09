package kr.or.ddit.mp.dao.zone;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.mypage.ZiptbVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;

public class ZoneDaoImpl implements IZoneDao{

	private SqlMapClient smc; 
	
	//외부에서 객체를 생성하는 것을 막음
	public static ZoneDaoImpl dao = new ZoneDaoImpl(); 
	
	private ZoneDaoImpl() { 
		smc = SqlMapClientFactory.getInstance();
	}

	//객체 생성 및 제공
	public static ZoneDaoImpl getInstance() { 
		if(dao == null) {
			dao = new ZoneDaoImpl();
		}
		return dao;
	}
	
	public static void main(String[] args) {
		
	}

	/**
	 * 1. 동으로 검색하기
	 */
	@Override
	public List<ZiptbVO> selectZone(String dong) {

		ArrayList<ZiptbVO> zipList = new ArrayList<ZiptbVO>();
		
		try {
			zipList = (ArrayList<ZiptbVO>) smc.queryForList("selectZone", dong);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return zipList;
	}

	@Override
	public int insertZone1(ZoneVO zone1) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("insertZone1", zone1);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int updateZone2(ZoneVO zone2) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("updateZone2", zone2);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int updateZone3(ZoneVO zone3) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("updateZone3", zone3);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int deleteZone3(ZoneVO zone3) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("deleteZone3", zone3);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int deleteZone2(ZoneVO zone2) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("deleteZone2", zone2);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int deleteZone1(ZoneVO zone1) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("deleteZone1", zone1);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public List<ZoneVO> selectZoneChoice(ZoneVO vo) {
		
		ArrayList<ZoneVO> zipList = new ArrayList<ZoneVO>();
		
		try {
			zipList = (ArrayList<ZoneVO>) smc.queryForList("selectZoneChoice", vo);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return zipList;
	}



	
	

	

	
}
