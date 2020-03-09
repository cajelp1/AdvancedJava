package kr.or.ddit.mp.dao.reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.reservation.ReserOptionVO;
import kr.or.ddit.mp.vo.reservation.ReservationVO;

public class ReservationDaoImpl implements IReservationDao{

	private SqlMapClient smc; //revservation_option.xml 연결
	
	//외부에서 객체를 생성하는 것을 막음
	public static ReservationDaoImpl dao = new ReservationDaoImpl(); 
	
	private ReservationDaoImpl() { 
		smc = SqlMapClientFactory.getInstance();
	}

	//객체 생성 및 제공
	public static ReservationDaoImpl getInstance() { 
		if(dao == null) {
			dao = new ReservationDaoImpl();
		}
		return dao;
	}
	
	public static void main(String[] args) {
		
//		ReserOptionVO vo = new ReserOptionVO();
//		vo.setCom_id("558-87-87895");
//		vo.setOp_time("15");
//		vo.setCl_time("22");
//		vo.setOp_person("3");
//		vo.setEtc_option("매주 수요일은 쉽니다");
		
		ReservationVO vo = new ReservationVO();
		vo.setCom_id("");
		
		ReservationDaoImpl dao = new ReservationDaoImpl();
		
		ArrayList<ReservationVO> list = new ArrayList<>();
		list = (ArrayList<ReservationVO>) dao.selectReserList("219-05-14421");
		
		System.out.println(list.get(0).getCom_id());
		System.out.println(list.get(0).getMem_no());
	}

	/**
	 * 1. 예약 옵션 설정
	 */
	@Override
	public int insertReserOption(ReserOptionVO vo) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("insertReserOption", vo);
			
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

	/**
	 * 2. 예약현 황 조회
	 */
	@Override
	public List<ReservationVO> selectReserList(String com_id) {
		
		ArrayList<ReservationVO> reserList = new ArrayList<ReservationVO>();
		
		try {
			reserList = (ArrayList<ReservationVO>) smc.queryForList("selectReserList", com_id);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return reserList;
	}

	@Override
	public List<ReservationVO> selectReserApprove(String com_id) {
		
		ArrayList<ReservationVO> reserList = new ArrayList<ReservationVO>();
		
		try {
			reserList = (ArrayList<ReservationVO>) smc.queryForList("selectReserApprove", com_id);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
	}

	@Override
	public List<ReservationVO> selectReserWait(String com_id) {
		
		ArrayList<ReservationVO> reserList = new ArrayList<ReservationVO>();
		
		try {
			reserList = (ArrayList<ReservationVO>) smc.queryForList("selectReserWait", com_id);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
	}

	@Override
	public List<ReservationVO> selectReserBack(String com_id) {
		
		ArrayList<ReservationVO> reserList = new ArrayList<ReservationVO>();
		
		try {
			reserList = (ArrayList<ReservationVO>) smc.queryForList("selectReserBack", com_id);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
	}

	@Override
	public List<ReservationVO> selectReserNoshow(String com_id) {
		
		ArrayList<ReservationVO> reserList = new ArrayList<ReservationVO>();
		
		try {
			reserList = (ArrayList<ReservationVO>) smc.queryForList("selectReserNoshow", com_id);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
	}

	@Override
	public int approveReservation(ReservationVO vo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("approveReservation", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int backReservation(ReservationVO vo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("backReservation", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int noshowReservation(ReservationVO vo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("noshowReservation", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertReservation(ReservationVO vo) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("insertReservation", vo);
			
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
	public List<ReservationVO> selectMyReservation(String mem_no) {
		
		ArrayList<ReservationVO> reserList = new ArrayList<ReservationVO>();
		
		try {
			reserList = (ArrayList<ReservationVO>) smc.queryForList("selectMyReservation", mem_no);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return reserList;
	}

	@Override
	public int deleteReservation(ReservationVO vo) {

		int cnt = 0;
		
		try {
			cnt = smc.update("deleteReservation", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<ReserOptionVO> selectComOption(String com_id) {
		
		ArrayList<ReserOptionVO> reserList = new ArrayList<ReserOptionVO>();
		
		try {
			reserList = (ArrayList<ReserOptionVO>) smc.queryForList("selectComOption", com_id);
			
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
		
	}

	@Override
	public List<ComVO> chiceComResOption(String com_id) {
		
		ArrayList<ComVO> reserList = new ArrayList<ComVO>();
		
		try {
			reserList = (ArrayList<ComVO>) smc.queryForList("chiceComResOption", com_id);
			
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
	}

	@Override
	public List<ComVO> selectComFirstOption(String com_id) {
		
		ArrayList<ComVO> reserList = new ArrayList<ComVO>();
		
		try {
			reserList = (ArrayList<ComVO>) smc.queryForList("selectComFirstOption", com_id);
			
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		
		return reserList;
	}
	
	

	
}
