package kr.or.ddit.mp.service.reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.reservation.ReservationDaoImpl;
import kr.or.ddit.mp.vo.member.ComVO;
import kr.or.ddit.mp.vo.reservation.ReserOptionVO;
import kr.or.ddit.mp.vo.reservation.ReservationVO;

public class ReservationServiceImpl extends UnicastRemoteObject implements IReservationService{

	ReservationDaoImpl reserDao; //사용할 Dao의  멤버변수를 선언
	
	private static ReservationServiceImpl service;//Singleton패턴
	
	private ReservationServiceImpl() throws RemoteException {
		super();
		reserDao =  ReservationDaoImpl.getInstance();//Singleton패턴
	}
	
	public static ReservationServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new ReservationServiceImpl();
		}
		return service;
	}

	@Override
	public int insertReserOption(ReserOptionVO vo) throws RemoteException {

		return reserDao.insertReserOption(vo);
	}

	@Override
	public List<ReservationVO> selectReserList(String com_id) throws RemoteException {

		return reserDao.selectReserList(com_id);
	}

	@Override
	public List<ReservationVO> selectReserApprove(String com_id) throws RemoteException {

		return reserDao.selectReserApprove(com_id);
	}

	@Override
	public List<ReservationVO> selectReserWait(String com_id) throws RemoteException {

		return reserDao.selectReserWait(com_id);
	}

	@Override
	public List<ReservationVO> selectReserBack(String com_id) throws RemoteException {
		
		return reserDao.selectReserBack(com_id);
	}

	@Override
	public List<ReservationVO> selectReserNoshow(String com_id) throws RemoteException {
		
		return reserDao.selectReserNoshow(com_id);
	}

	@Override
	public int approveReservation(ReservationVO vo) throws RemoteException {
		
		return reserDao.approveReservation(vo);
	}

	@Override
	public int backReservation(ReservationVO vo) throws RemoteException {
		
		return reserDao.backReservation(vo);
	}

	@Override
	public int noshowReservation(ReservationVO vo) throws RemoteException {
		
		return reserDao.noshowReservation(vo);
	}

	@Override
	public int insertReservation(ReservationVO vo) throws RemoteException {
		
		return reserDao.insertReservation(vo);
	}

	@Override
	public List<ReservationVO> selectMyReservation(String mem_no) throws RemoteException {
		
		return reserDao.selectMyReservation(mem_no);
	}

	@Override
	public int deleteReservation(ReservationVO vo) throws RemoteException {
		
		return reserDao.deleteReservation(vo);
	}

	@Override
	public List<ReserOptionVO> selectComOption(String com_id) throws RemoteException {
		
		return reserDao.selectComOption(com_id);
	}

	@Override
	public List<ComVO> chiceComResOption(String com_id) throws RemoteException {
		
		return reserDao.chiceComResOption(com_id);
	}

	@Override
	public List<ComVO> selectComFirstOption(String com_id) throws RemoteException {
		
		return reserDao.selectComFirstOption(com_id);
	}
	
	

	
	 
	 
}
