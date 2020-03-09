package kr.or.ddit.mp.dao.goodcom;

import java.util.List;

import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.member.MemberVO;


public interface IGoodcomDao {
	public List<ComVO> getSearchGoodCom(ComVO cv);
	public List<MemberVO> isVipCom(String word);
	
}
