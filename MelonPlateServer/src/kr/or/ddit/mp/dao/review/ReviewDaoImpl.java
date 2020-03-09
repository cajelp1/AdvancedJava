package kr.or.ddit.mp.dao.review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.review.ReviewVO;

public class ReviewDaoImpl implements IReviewDao{

	private SqlMapClient smc; //review.xml 연결
	
	//외부에서 객체를 생성하는 것을 막음
	public static ReviewDaoImpl dao = new ReviewDaoImpl(); 
	
	private ReviewDaoImpl() { 
		smc = SqlMapClientFactory.getInstance();
	}

	//객체 생성 및 제공
	public static ReviewDaoImpl getInstance() { 
		if(dao == null) {
			dao = new ReviewDaoImpl();
		}
		return dao;
	}
	
	public static void main(String[] args) {
		
//		ReviewVO vo = new ReviewVO();
//		vo.setMem_no("1");
//		int de_ad = dao.deleteAdminReview(vo);
//		System.out.println(de_ad);
//		vo.setMem_no("64");
//		ArrayList<ReviewVO> riviewList = (ArrayList<ReviewVO>) dao.adminReview();
//		System.out.println(riviewList.size());
		
//		ArrayList<ReviewVO> riviewList2 = (ArrayList<ReviewVO>) dao.selectReview(vo);
//		System.out.println(riviewList2.size());
		
//		ArrayList<ReviewVO> riviewList3 = (ArrayList<ReviewVO>) dao.selectMyReview(vo);
//		System.out.println(riviewList3.size());
		
//		int in_test = dao.insertReview(vo);
//		System.out.println(in_test);
		
//		int de_test = dao.deleteReview(vo);
//		System.out.println(de_test);
		
//		int up_test = dao.updateReview(vo);
//		System.out.println(up_test);
		
	}
	
	/**
	 * 1. 리뷰 전체 조회(맛집홈)
	 */
	@Override
	public List<ReviewVO> selectReviewAll(String com_id) {
		
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		
		try {
			reviewList = (ArrayList<ReviewVO>) smc.queryForList("selectList", com_id);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return reviewList;
	}

	/**
	 * 1-1. 리뷰 상세내용 조회
	 */
	@Override
	public List<ReviewVO> selectReview(ReviewVO com_id) {
		
		ArrayList<ReviewVO> selectReview = new ArrayList<>();
		
		try {
			selectReview = (ArrayList<ReviewVO>) smc.queryForList("selectListDetail", com_id);
			
			} catch (Exception e) {
				System.out.println("에러");
				e.printStackTrace();
			} 
		return selectReview;
	}


	/**
	 * 3. 자신이 쓴 리뷰 조회
	 */
	@Override
	public List<ReviewVO> selectMyReview(ReviewVO mem_no) {
		
		ArrayList<ReviewVO> noticeList = new ArrayList<>();
		
		try {
			noticeList = (ArrayList<ReviewVO>) smc.queryForList("selectListMy", mem_no);
			
			} catch (Exception e) {
				noticeList = null;
				e.printStackTrace();
			} 
		return noticeList;
	}

	/**
	 * 4. 리뷰 작성(리뷰 사진은 웹으로!)
	 */
	@Override
	public int insertReview(ReviewVO vo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("insertReview", vo);
			
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
	 * 5. 리뷰 삭제
	 */
	@Override
	public int deleteReview(ReviewVO vo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("deleteReview", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			
		}
		
		return cnt;
	}

	/**
	 * 6. 리뷰 수정(조건:re_no, mem_no)
	 */
	@Override
	public int updateReview(ReviewVO vo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("updateReview", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	/**
	 * 7. 리뷰 추천 // String 타입??
	 */
	@Override
	public int upReview(String re_up) {
		int cnt = 0;
		
		try {
			cnt = smc.update("upReview", re_up);
			
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	/**
	 * 8. 리뷰 신고 // String 타입??
	 */
	@Override
	public int downReview(String re_down) {
		int cnt = 0;
		
		try {
			cnt = smc.update("downReview", re_down);
			
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} 
		return cnt;
	}

	/**
	 * 9. 관리자 리뷰 관리리스트
	 */
	@Override
	public List<ReviewVO> adminReview() {
		
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		
		try {
			reviewList = (ArrayList<ReviewVO>) smc.queryForList("selectListAdmin");
		} catch (SQLException e) {
			System.out.println("리뷰 관리자 리뷰 에러~");
			e.printStackTrace();
		}
		return reviewList;
	}

	/**
	 * 10. 관리자 리뷰 삭제
	 */
	@Override
	public int deleteAdminReview(ReviewVO vo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("deleteAdminReview", vo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			
		}
		
		return cnt;
	}

	/**
	 * 11. 홀릭 달성 확인 페이지
	 */
	@Override
	public List<ReviewVO> checkHolic(ReviewVO vo) {
		
		ArrayList<ReviewVO> ch_holick = new ArrayList<ReviewVO>();
		
		try {
			ch_holick = (ArrayList<ReviewVO>) smc.queryForList("checkHolic", vo);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return ch_holick;
	}

	@Override
	public List<ReviewVO> clickedReviewNo(String word) {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		
		try {
			list = (ArrayList<ReviewVO>) smc.queryForList("clickedReviewNo", word);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return list;
	}

	
}
