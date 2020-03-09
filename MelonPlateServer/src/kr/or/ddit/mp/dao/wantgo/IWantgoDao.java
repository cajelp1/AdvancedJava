package kr.or.ddit.mp.dao.wantgo;

import java.util.List;

import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.mypage.WantgoVO;


public interface IWantgoDao {
	public List<WantgoVO> selectWantgo(WantgoVO wv);
	public boolean isEmptyWantgo(WantgoVO wv);
	public int deleteWantgo(WantgoVO wv);
	public int insertWantgo(WantgoVO wv);
}
