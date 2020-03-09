package kr.or.ddit.mp.dao.paydeal;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.eatdeal.PayVO;
import kr.or.ddit.mp.vo.eatdeal.RequestVO;
import kr.or.ddit.mp.vo.mypage.MileageVO;

public interface IPaydealDao {
	public int requestPayInsert(RequestVO vo);
	public int requestCartInsert(RequestVO vo);
	public List<RequestVO> requestSelect(String word);
	public int payInsert(PayVO vo);
	public int mileNotuseInsert(MileageVO vo);
	public int mileUseInsert(MileageVO vo);
	public int eatdealQtyDown(EatdealVO vo);
	
	
}
