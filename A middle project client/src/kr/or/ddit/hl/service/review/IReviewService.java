package kr.or.ddit.hl.service.review;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.hl.vo.ReportVO;
import kr.or.ddit.hl.vo.ReservationVO;
import kr.or.ddit.hl.vo.ReviewVO;

public interface IReviewService extends Remote {
	
	//리뷰 작성하기
	public boolean insertReview(ReviewVO rv, int res_no) throws RemoteException;
	
	//리뷰 신고하기
	public boolean insertReport(ReportVO rv) throws RemoteException;
	
	//리뷰 수정하기
	public boolean updateReview(ReviewVO rv) throws RemoteException;
	
	//리뷰 삭제하기
	public boolean deleteReview(int review_no) throws RemoteException;
	
	//리뷰 하나 가져오기
	public ReviewVO selectReview(int review_no) throws RemoteException;
	
	//리뷰 전체 가져오기
	public List<ReviewVO> getAllReviewList() throws RemoteException;
	
	//리뷰 쓸 수 있는 예약리스트 가져오기
	public List<ReservationVO> getReservationList(String mem_id) throws RemoteException;
	
	//본인이 쓴 리뷰만 가져오기 
	public List<ReviewVO> myReviewList(String review_writer_id) throws RemoteException;
	
	//글 검색하기
	public List<ReviewVO> getSearchReview(ReviewVO rv) throws RemoteException;
	
	//리뷰 작성후 예약 상태 변경
	public boolean reservToComp(int res_no) throws RemoteException;
	
	//리뷰 삭제후 예약 상태 변경
	public boolean reservToDel(int res_no) throws RemoteException;
	
}
