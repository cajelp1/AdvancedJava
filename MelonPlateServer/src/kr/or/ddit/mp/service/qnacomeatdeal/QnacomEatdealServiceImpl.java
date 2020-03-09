package kr.or.ddit.mp.service.qnacomeatdeal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.qnacomeatdeal.QnacomEatdealDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.EatqaVO;

public class QnacomEatdealServiceImpl extends UnicastRemoteObject implements IQnacomEatdealService {
	QnacomEatdealDaoImpl dao;
	private static QnacomEatdealServiceImpl service;
	
	private QnacomEatdealServiceImpl() throws RemoteException{
		super();
		dao = QnacomEatdealDaoImpl.getInstance();
	}
	
	public static QnacomEatdealServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new QnacomEatdealServiceImpl();
		}
		return service;
	}

	@Override
	public List<EatqaVO> getAllQnaComeatdealList(String com_id) throws RemoteException {
		return dao.getAllQnaComeatdealList(com_id);
	}

	@Override
	public List<EatqaVO> getNotQnaComeatdealList(String com_id) throws RemoteException {
		return dao.getNotQnaComeatdealList(com_id);
	}

	@Override
	public int ansQna(EatqaVO vo) throws RemoteException {
		return dao.ansQna(vo);
	}
	
	

}
