package kr.or.ddit.mp.dao.alleatdeal;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;

public interface IAllEatdealDao {
	public List<EatdealVO> eatlistByMyzone(ZoneVO vo);
	public List<EatdealVO> eatlistByQty();
	public List<ZoneVO> zoneForlist(String word);
	public List<EatdealVO> eatlistByNew();

}
