package kr.or.ddit.mp.dao.reservation;

import java.util.List;

import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.reservation.ReserOptionVO;
import kr.or.ddit.mp.vo.reservation.ReservationVO;


public interface IReservationDao {

	/**
	 * 1. 예약 옵션 설정
	 */
	public int insertReserOption(ReserOptionVO vo);
	
	/**
	 * 2. 예약 현황 조회
	 */
	public List<ReservationVO> selectReserList(String com_id);
	
	/**
	 * 3. 예약 승인내역 조회
	 */
	public List<ReservationVO> selectReserApprove(String com_id);
	
	/**
	 * 4. 예약 대기내역 조회
	 */
	public List<ReservationVO> selectReserWait(String com_id);
	
	/**
	 * 5. 예약 반려내역 조회
	 */
	public List<ReservationVO> selectReserBack(String com_id);
	
	/**
	 * 6. 예약 노쇼내역 조회
	 */
	public List<ReservationVO> selectReserNoshow(String com_id);
	
	/**
	 * 7. 예약 승인하기
	 */
	public int approveReservation(ReservationVO vo);
	
	/**
	 * 8. 예약 반려하기
	 */
	public int backReservation(ReservationVO vo);
	
	/**
	 * 9. 예약 노쇼하기
	 */
	public int noshowReservation(ReservationVO vo);
	
	/**
	 * 10. 예약하기
	 */
	public int insertReservation(ReservationVO vo);
	
	/**
	 * 11. 사용자의 나의예약 현황 조회
	 */
	public List<ReservationVO> selectMyReservation(String mem_no);
	
	/**
	 * 12. 사용자 나의예약 삭제
	 */
	public int deleteReservation(ReservationVO vo);
	
	/**
	 * 13. 예약 옵션 조회
	 */
	public List<ReserOptionVO> selectComOption(String com_id);
	
	/**
	 * 14. 업체 오픈, 마감시간 조회
	 */
	public List<ComVO> chiceComResOption(String com_id);
	
	/**
	 * 15. 업체 가입시 오픈, 마감시간 조회
	 */
	public List<ComVO> selectComFirstOption(String com_id);
}
