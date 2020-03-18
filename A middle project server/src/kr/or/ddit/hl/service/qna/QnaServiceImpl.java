package kr.or.ddit.hl.service.qna;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.hl.dao.qna.IQnaDao;
import kr.or.ddit.hl.dao.qna.QnaDaoImpl;
import kr.or.ddit.hl.vo.QnaBoardVO;

public class QnaServiceImpl extends UnicastRemoteObject implements IQnaService {
	
	private static IQnaService service;
	private IQnaDao dao;
	
	
	protected QnaServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		dao = QnaDaoImpl.getInstance();
	}
	
	public static IQnaService getInstance() throws RemoteException {
		if(service == null) {
			service = new QnaServiceImpl();
		}
		return service;
	}
	
	@Override
	public boolean insertQna(QnaBoardVO qna) throws RemoteException {
		
		return dao.insertQna(qna);
	}
	
	@Override
	public boolean answerQna(QnaBoardVO qna) throws RemoteException {
		
		return dao.answerQna(qna);
	}
	
	@Override
	public boolean updateQna(QnaBoardVO qna) throws RemoteException {
		
		return dao.updateQna(qna);
	}
	
	@Override
	public boolean deleteQna(int no) throws RemoteException {
		
		return dao.deleteQna(no);
	}
	
	@Override
	public List<QnaBoardVO> getAllQnaList() throws RemoteException {
		
		return dao.getAllQnaList();
	}
	
	@Override
	public List<QnaBoardVO> getSearchQna(QnaBoardVO qna) throws RemoteException {
		
		return dao.getSearchQna(qna);
	}
	
	@Override
	public String secretCheck(int no) throws RemoteException {
		
		return dao.secretCheck(no);
	}
	
}
