package kr.or.ddit.mp.dao.qnacomeatdeal;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.EatqaVO;

public interface IQnacomEatdealDao {
	public List<EatqaVO> getAllQnaComeatdealList(String com_id);
	public List<EatqaVO> getNotQnaComeatdealList(String com_id);
	public int ansQna(EatqaVO vo);
}
