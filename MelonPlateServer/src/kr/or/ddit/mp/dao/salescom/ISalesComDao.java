package kr.or.ddit.mp.dao.salescom;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.SalesVO;

public interface ISalesComDao {
	public List<SalesVO> getSalesComEatdeal(String word);
}
