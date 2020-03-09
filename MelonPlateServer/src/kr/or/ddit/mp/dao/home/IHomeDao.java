package kr.or.ddit.mp.dao.home;

import java.util.List;

import kr.or.ddit.mp.vo.eatdeal.EatdealVO;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;

public interface IHomeDao {
	public List<MemberVO> homeBestTop10();
	public List<ZoneVO> myZoneSelect(String word);
	public List<EatdealVO> homeEatBest5();
	public List<ComVO> homeComeBest5(ZoneVO vo);
	
}
