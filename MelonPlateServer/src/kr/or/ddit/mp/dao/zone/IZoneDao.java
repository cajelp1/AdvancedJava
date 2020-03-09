package kr.or.ddit.mp.dao.zone;

import java.util.List;

import kr.or.ddit.mp.vo.mypage.ZiptbVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;
import kr.or.ddit.mp.vo.reservation.ReserOptionVO;


public interface IZoneDao {

	/**
	 * 1. 등으로 검색하기
	 */
	public List<ZiptbVO> selectZone(String dong);
	
	/**
	 * 2. 관심지역1 셋팅하기
	 */
	public int insertZone1(ZoneVO zone1);
	
	/**
	 * 3. 관심지역2 셋팅하기
	 */
	public int updateZone2(ZoneVO zone2);
	
	/**
	 * 4. 관심지역3 셋팅하기
	 */
	public int updateZone3(ZoneVO zone3);
	
	/**
	 * 5. 관심지역3 삭제
	 */
	public int deleteZone3(ZoneVO zone3);
	
	/**
	 * 6. 관심지역2 삭제
	 */
	public int deleteZone2(ZoneVO zone2);
	
	/**
	 * 7. 관심지역1 삭제
	 */
	public int deleteZone1(ZoneVO zone1);
	
	/**
	 *  설정된 값 조회하기
	 */
	public List<ZoneVO> selectZoneChoice(ZoneVO vo);
	
}
