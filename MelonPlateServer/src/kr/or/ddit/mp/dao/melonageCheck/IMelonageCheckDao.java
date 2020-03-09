package kr.or.ddit.mp.dao.melonageCheck;

import java.util.List;

import kr.or.ddit.mp.vo.melonageCheck.MileageVO;

public interface IMelonageCheckDao {
	
	
	// 마일리지 조회
	public List<MileageVO> getAddUsedMelonage(MileageVO mvo); // 사용한 마일리지 조회
	public List<MileageVO> getAllMelonage(MileageVO mvo); // 적립된 마일리지 조회

	
	
	
}
