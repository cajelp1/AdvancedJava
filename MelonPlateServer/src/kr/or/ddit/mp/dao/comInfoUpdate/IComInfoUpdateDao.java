package kr.or.ddit.mp.dao.comInfoUpdate;

import java.util.List;

import kr.or.ddit.mp.vo.comInfoUpdate.ComVO;
import kr.or.ddit.mp.vo.comInfoUpdate.MemberVO;
import kr.or.ddit.mp.vo.comInfoUpdate.ZiptbVO;

public interface IComInfoUpdateDao {
	
	
	// 관리 페이지로 들어가기 위한 비밀 번호 입력
	public MemberVO getPw(MemberVO mvo); // 비밀번호값 가져오기
	
	
	// 관리 페이지에서 들어온 후
	public ComVO getDefaultInfo(ComVO cvo); // 수정 불가한 기본 정보 가져오기
	public List<ZiptbVO> getSearchZipCode(ZiptbVO zvo); // 우편번호 찾기
	public int updateCom(ComVO cvo); // 회원 정보 수정
	public int updatePhoto(ComVO cvo); // 사진 경로값 넣기
	
	
	
}
