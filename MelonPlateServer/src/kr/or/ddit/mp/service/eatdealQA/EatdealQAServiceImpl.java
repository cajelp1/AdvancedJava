package kr.or.ddit.mp.service.eatdealQA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.eatdeal.EatdealQADaoImpl;
import kr.or.ddit.mp.dao.reservation.ReservationDaoImpl;
import kr.or.ddit.mp.vo.eatdeal.EatqaVO;
import kr.or.ddit.mp.vo.reservation.ReserOptionVO;
import kr.or.ddit.mp.vo.reservation.ReservationVO;

public class EatdealQAServiceImpl extends UnicastRemoteObject implements IEatdealQAService{

	EatdealQADaoImpl eatdealQADao; //사용할 Dao의  멤버변수를 선언
	
	private static EatdealQAServiceImpl service;//Singleton패턴
	
	private EatdealQAServiceImpl() throws RemoteException {
		super();
		eatdealQADao =  EatdealQADaoImpl.getInstance();//Singleton패턴
	}
	
	public static EatdealQAServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new EatdealQAServiceImpl();
		}
		return service;
	}

	@Override
	public List<EatqaVO> selectQA(String eat_no) throws RemoteException {
		
		return eatdealQADao.selectQA(eat_no);
	}

	@Override
	public List<EatqaVO> selectQAdetail(EatqaVO eatqa_no) throws RemoteException {
		 
		return eatdealQADao.selectQAdetail(eatqa_no);
	}

	@Override
	public int insertQA(EatqaVO vo) throws RemoteException {
	
		return eatdealQADao.insertQA(vo);
	}
	 
	 
}
