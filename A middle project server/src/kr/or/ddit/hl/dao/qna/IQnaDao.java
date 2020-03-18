package kr.or.ddit.hl.dao.qna;

import java.util.List;

import kr.or.ddit.hl.vo.QnaBoardVO;

public interface IQnaDao {
	
	//Qna 글 추가
	public boolean insertQna(QnaBoardVO qna);
	
	//Qna 답글추가
	public boolean answerQna(QnaBoardVO qna);
	
	//Qna 글 수정
	public boolean updateQna(QnaBoardVO qna);
	
	//Qna 글 삭제
	public boolean deleteQna(int no);
	
	//Qna 리스트 가져오기
	public List<QnaBoardVO> getAllQnaList();
	
	//Qna 검색하기
	public List<QnaBoardVO> getSearchQna(QnaBoardVO qna);
	
	//비밀글 접근가능 여부 확인하기
	public String secretCheck(int no);
	
}
