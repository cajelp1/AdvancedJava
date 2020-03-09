package kr.or.ddit.mp.dao.matZip;

import java.util.List;

import kr.or.ddit.mp.vo.matZip.ReviewVO;

public interface IMatZipDao {
	
	
	public List<ReviewVO> getGoodCom(ReviewVO rvo); // 리뷰수 및 평점 평균 가져오기

	
	
	
}
