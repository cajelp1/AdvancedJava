package kr.or.dditl.hl.service.review;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.hl.dao.review.IReviewDao;
import kr.or.ddit.hl.dao.review.ReviewDaoImpl;
import kr.or.ddit.hl.vo.ReportVO;
import kr.or.ddit.hl.vo.ReservationVO;
import kr.or.ddit.hl.vo.ReviewVO;

public class ReviewServiceImpl extends UnicastRemoteObject implements IReviewService {
	
	private static IReviewService service;
	private IReviewDao dao;
	
	protected ReviewServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		dao = ReviewDaoImpl.getInstance();
	}
	
	public static IReviewService getInstance() throws RemoteException {
		if(service == null) {
			service = new ReviewServiceImpl();
		}
		return service;
	}
	
	@Override
	public boolean insertReview(ReviewVO rv, int res_no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.insertReview(rv, res_no);
	}

	@Override
	public boolean insertReport(ReportVO rv) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.insertReport(rv);
	}

	@Override
	public boolean updateReview(ReviewVO rv) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.updateReview(rv);
	}

	@Override
	public boolean deleteReview(int review_no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.deleteReview(review_no);
	}

	@Override
	public ReviewVO selectReview(int review_no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectReview(review_no);
	}

	@Override
	public List<ReservationVO> getReservationList(String mem_id) throws RemoteException{
		
		return dao.getReservationList(mem_id);
	}
		
	
	@Override
	public List<ReviewVO> getAllReviewList() throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getAllReviewList();
	}

	@Override
	public List<ReviewVO> myReviewList(String review_writer_id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.myReviewList(review_writer_id);
	}

	@Override
	public List<ReviewVO> getSearchReview(ReviewVO rv) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getSearchReview(rv);
	}

	@Override
	public boolean reservToComp(int res_no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.reservToComp(res_no);
	}

	@Override
	public boolean reservToDel(int res_no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.reservToDel(res_no);
	}

}
