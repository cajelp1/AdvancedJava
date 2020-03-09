package kr.or.ddit.mp.dao.buylist;

import java.util.List;

import kr.or.ddit.mp.vo.buylist.LoginSession;
import kr.or.ddit.mp.vo.buylist.MemberVO;
import kr.or.ddit.mp.vo.buylist.RequestVO;

public interface IBuylisDao {
	
	
	/**
	 * 로그인 세션의 멤버 넘버와 오더넘을 받아서 결제 내역을 삭제
	 * @param rvo
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int deleteRequest(RequestVO rvo);
	
	/**
	 * 테이블의 데이터를 가져와서 구매내역 리스트에 반환하는 메서드
	 * @return RequestVO 정보를 담고 있는 list객체
	 */
	public List<RequestVO> getAllBuyList(RequestVO rvo);
	
	/**
	 * 결제취소하면 테이블에서 스테이터스를 취소로 바꿈
	 * @param rvo
	 * @return
	 */
	public int updateOrder_st(RequestVO rvo);
	
}
