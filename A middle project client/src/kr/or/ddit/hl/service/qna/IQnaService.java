package kr.or.ddit.hl.service.qna;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.hl.vo.QnaBoardVO;

public interface IQnaService extends Remote{
	
	//Qna 글 추가
	public boolean insertQna(QnaBoardVO qna) throws RemoteException;
	
	//Qna 답글추가
	public boolean answerQna(QnaBoardVO qna) throws RemoteException;
	
	//Qna 글 수정
	public boolean updateQna(QnaBoardVO qna) throws RemoteException;
	
	//Qna 글 삭제
	public boolean deleteQna(int no) throws RemoteException;
	
	//Qna 리스트 가져오기
	public List<QnaBoardVO> getAllQnaList() throws RemoteException;
	
	//Qna 검색하기
	public List<QnaBoardVO> getSearchQna(QnaBoardVO qna) throws RemoteException;
	
	//변호사 비밀글 접근가능 여부 확인하기
	public String secretCheck(int no) throws RemoteException;
	
}
