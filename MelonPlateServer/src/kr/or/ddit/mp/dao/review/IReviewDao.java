package kr.or.ddit.mp.dao.review;

import java.util.List;

import kr.or.ddit.mp.vo.review.ReviewVO;


public interface IReviewDao {

	/**
	 * 1. 리뷰 전체 조회(맛집홈)
	 */
	public List<ReviewVO> selectReviewAll(String com_id);
	
	/**
	 * 1-1. 리뷰 상세내용 조회(글번호로)
	 */
	public List<ReviewVO> selectReview(ReviewVO com_id); 
	
//	/**
//	 * 2. 리뷰 평점별 정렬.. 없어도되는 것.. fxml에서 구현되는 것..
//	 */
//	public List<ReviewVO> reviewArray();  
	
	/**
	 * 3. 자신이 쓴 리뷰 조회
	 */
	public List<ReviewVO> selectMyReview(ReviewVO mem_no);  
	
	/**
	 * 4. 리뷰 작성(리뷰 사진은 웹으로!)
	 */
	public int insertReview(ReviewVO vo);
	
	/**
	 * 5. 리뷰 삭제(글번호, mem_no 받아와야함)
	 */
	public int deleteReview(ReviewVO vo);
	
	/**
	 * 6. 리뷰 수정(글번호, mem_no 받아와야함)
	 */
	public int updateReview(ReviewVO vo);
	
	/**
	 * 7. 리뷰 추천
	 */
	public int upReview(String re_up);
	
	/**
	 * 8. 리뷰 신고
	 */
	public int downReview(String re_down);
	
	/**
	 * 9. 관리자 리뷰 관리리스트
	 */
	public List<ReviewVO> adminReview();
	
	/**
	 * 10. 관리자 리뷰 삭제
	 */
	public int deleteAdminReview(ReviewVO vo);
	
	/**
	 * 11. 홀릭 달성 확인 페이지
	 */
	public List<ReviewVO> checkHolic(ReviewVO vo);
	
	/**
	 * 12. reno 검색
	 */
	public List<ReviewVO> clickedReviewNo(String word);
	
}
