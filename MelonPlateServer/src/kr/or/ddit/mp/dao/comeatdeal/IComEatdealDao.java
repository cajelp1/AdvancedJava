package kr.or.ddit.mp.dao.comeatdeal;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.EatdealVO;

public interface IComEatdealDao {
	public List<EatdealVO> getComEatdealList(String word);
	public int insertNewNoEatdeal(EatdealVO vo);
	public int deleteEatdeal(EatdealVO vo);
}
