package kr.or.ddit.mp.dao.eatdealhome;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.CartVO;
import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.mypage.MileageVO;

public interface IEatdealHomeDao {
	public List<EatdealVO> getSelectEatdeal(String word);
	public List<MileageVO> getMileageLast(String word);
	public int insertCartEatdeal(CartVO vo);
}
