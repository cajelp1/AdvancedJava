package kr.or.ddit.mp.dao.join;

import java.util.List;

import kr.or.ddit.mp.vo.member.ReadyComVO;
import kr.or.ddit.mp.vo.member.MemberVO;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.zipcode.ZipcodeVO;

public interface IComJoinDao{
	
	public List<MemberVO> selectId(MemberVO mvo);
	
	public List<MemberVO> selectNick(MemberVO mvo);
	
	public List<ZipcodeVO> selectZipcode(ZipcodeVO zv);
	
	public int insertReadyComMember(ReadyComVO rvo);
	
	public List<ComVO> selectComId(ComVO cvo);
	
	
	

}
