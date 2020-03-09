package kr.or.ddit.mp.dao.admin;

import java.util.List;

import kr.or.ddit.mp.vo.admin.BlackVO;
import kr.or.ddit.mp.vo.admin.ComVO;
import kr.or.ddit.mp.vo.admin.HolicVO;
import kr.or.ddit.mp.vo.admin.MemberVO;
import kr.or.ddit.mp.vo.admin.ReadyComVO;

public interface IAdminDao {
	
	//전체 회원 정보 CRUD
	public List<MemberVO> getAllMemberCom(); //전체회원 조회(일반,회원)
	public int deleteMember(MemberVO mvo); //회원 정보 삭제
	
	//관리자 추가
	public int insertAdmin(MemberVO mvo); //관리자 정보 삽입
	
	//일반 회원 정보 
	public List<MemberVO> getAllMember(); //일반회원 조회
	
	//업체 회원 정보 
	public List<MemberVO> getAllCom(); //업체 회원 조회
	public List<ReadyComVO> getReadyCom(); //대기중인 업체 회원 조회

	//업체회원 가입 신청 승인/반려
	public int insertJoinCom1(ReadyComVO rcvo); //업체회원 가입 승인(회원테이블 삽입)
	public int insertJoinCom2(ReadyComVO rcvo); //업체회원 가입 승인(업체테이블 삽입)
	public int deleteJoinCom(ReadyComVO rcvo); //업체회원 가입 반려
	
	//일반회원 블랙리스트 CRUD
	public List<MemberVO> getReadyBlackMember(); //블랙 대기 회원 조회
	public List<MemberVO> getAllBlackMember(); //전체 블랙 회원 조회
	public int insertBlackMember(MemberVO mvo); //블랙 회원 정보 삽입
	public int deleteBlackMember(MemberVO mvo); //블랙 회원 정보 삭제 (회원번호 사용)
	
	//일반회원 홀릭 회원 CRUD
	public List<MemberVO> getReadyHolicMember(); //홀릭 대기 회원 조회
	public List<MemberVO> getAllHolicMember(); //전체 홀릭 회원 조회
	public int insertHolicMember(MemberVO mvo); //홀릭 회원 정보 삽입
	public int deleteHolicMember(MemberVO mvo); //홀릭 회원 정보 삭제 (회원번호 사용)
	
	//업체회원 우수 맛집리스트 CRUD
	public List<MemberVO> getAllGoodCom(); //전체 우수 맛집 조회
	
	
}
