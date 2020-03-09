package kr.or.ddit.mp.dao.recogeatdeal;

import java.util.List;

import kr.or.ddit.mp.vo.recogeatdeal.EatdealVO;


public interface IRecogeatdealDao {
	
	/**
	 * 테이블의 데이터를 가져와서 장바구니 리스트에 반환하는 메서드
	 * @return CartVO 정보를 담고 있는 list객체
	 */
	public List<EatdealVO> getAllEatList();
	
	public int updateOnY(EatdealVO evo);
	
	public int updateOnB(EatdealVO evo);
}
