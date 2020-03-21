package kr.or.ddit.hl.dao.review;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hl.util.SqlMapClientFactory;
import kr.or.ddit.hl.vo.QnaBoardVO;
import kr.or.ddit.hl.vo.ReportVO;
import kr.or.ddit.hl.vo.ReservationVO;
import kr.or.ddit.hl.vo.ReviewVO;

public class ReviewDaoImpl implements IReviewDao {
	
	private SqlMapClient smc;
	private static IReviewDao dao;
	
	private ReviewDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IReviewDao getInstance() {
		if(dao == null) {
			dao = new ReviewDaoImpl();
		}
		return dao;
	}
	
	@Override
	public boolean insertReview(ReviewVO rv, int res_no) {
		
		boolean result = false;
		try {
			smc.startTransaction();
			int res1 = (Integer)smc.insert("review.insertReview", rv);
			int res2 = (Integer)smc.update("review.reservToComp", res_no);
			smc.commitTransaction(); //???
			if(res1 > 0 && res2 > 0) {
				result = true;
			}
			if(res1 <= 0) {
				System.out.println("리뷰 작성에 실패했습니다");
			}
			if(res2 <= 0) {
				System.out.println("예약테이블 상태 업데이트에 실패했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return result;
	}

	@Override
	public boolean insertReport(ReportVO rv) {
		
		boolean result = false;
		try {
			int res = (Integer)smc.insert("review.insertReport", rv);
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
	public boolean updateReview(ReviewVO rv) {
		
		boolean result = false;
		try {
			int res = (Integer)smc.insert("review.updateReview", rv);
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
	public boolean deleteReview(int review_no) {
		
		boolean result = false;
		try {
			smc.startTransaction();
			int res1 = (Integer)smc.update("review.deleteReview", review_no);
			int res2 = (Integer)smc.update("review.reservToDel", review_no);
			smc.endTransaction();
			
			if(res1 > 0 && res2 > 0) {
				result = true;
			}
			if(res1 <= 0) {
				System.out.println("리뷰 삭제에 실패했습니다");
			}
			if(res2 <= 0) {
				System.out.println("예약테이블 상태 업데이트에 실패했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				smc.commitTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public ReviewVO selectReview(int review_no) {
		
		ReviewVO vo = null;
		try {
			vo = (ReviewVO)smc.queryForObject("review.selectReview", review_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
	
	@Override
	public List<ReservationVO> getReservationList(String mem_id){
		
		List<ReservationVO> list = null;
		try {
			list = smc.queryForList("review.getReservationList", mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<ReviewVO> getAllReviewList() {
		
		List<ReviewVO> list = null;
		try {
			list = (List<ReviewVO>)smc.queryForList("review.getAllReviewList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ReviewVO> myReviewList(String review_writer_id) {
		
		List<ReviewVO> list = null;
		try {
			list = (List<ReviewVO>)smc.queryForList("review.myReviewList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ReviewVO> getSearchReview(ReviewVO rv) {
		
		List<ReviewVO> list = null;
		try {
			list = (List<ReviewVO>)smc.queryForList("review.getSearchReview", rv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	//!!!쓰지말고 insertReview에 같이 !!!!!
	@Override
	public boolean reservToComp(int res_no) {
		
		boolean result = false;
		try {
			int res = (Integer)smc.update("review.reservToComp", res_no);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	//!!!쓰지말고 deleteReview에 같이 !!!!!
	@Override
	public boolean reservToDel(int res_no) {

		boolean result = false;
		try {
			int res = (Integer)smc.update("review.reservToDel", res_no);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
