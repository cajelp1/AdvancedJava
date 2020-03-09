package kr.or.ddit.mp.dao.eatdeal;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.EatqaVO;


public interface IEatdealQADao {

	/**
	 * 1. 잇딜 현황 조회
	 */
	public List<EatqaVO> selectQA(String eat_no);
	
	/**
	 * 2. 잇딜문의 게시글 상세 조회
	 */
	public List<EatqaVO> selectQAdetail(EatqaVO eatqa_no);
	
	/**
	 * 3. 잇딜문의 게시글 작성
	 */
	public int insertQA(EatqaVO vo);
}
