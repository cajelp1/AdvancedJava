package kr.or.ddit.mp.dao.searchgoodcom;

import java.util.List;

import kr.or.ddit.mp.vo.member.ComVO;

public interface ISearchGoodcomDao {
	public List<ComVO> getResultGoodCom(String word);
}
