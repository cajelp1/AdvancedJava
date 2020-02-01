package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 
 * service에 전달하는 DAO의 interface 
 * 
 * @author PC-20
 *
 */
public interface IMemberDao {
	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메소드
	 * 
	 * @param mv DB에 insert할 자료가 저장된 MemberVO 객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param memId
	 * @return
	 */
	public boolean getMember(String memId);
	
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 list에 담는 메서드
	 * @return
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 하나의 MemberVO자료를 이용하여 DB를 update하는 메서드
	 * @param mv
	 * @return
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId
	 * @return
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * 
	 * @param mv 검색할 자료가 들어있는 MemverVO객체
	 * @return 검색된 결과를 담은 List객체 
	 */
	public List<MemberVO> getSearchMember(MemberVO mv);
	
	
}






