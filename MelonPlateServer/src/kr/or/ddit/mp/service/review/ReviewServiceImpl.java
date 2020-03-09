package kr.or.ddit.mp.service.review;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.mp.dao.review.ReviewDaoImpl;
import kr.or.ddit.mp.vo.review.ReviewVO;

public class ReviewServiceImpl extends UnicastRemoteObject implements IReviewService{

	ReviewDaoImpl riviewDao; //사용할 Dao의  멤버변수를 선언
	
	private static ReviewServiceImpl service;//Singleton패턴
	
	private ReviewServiceImpl() throws RemoteException {
		super();
		riviewDao =  ReviewDaoImpl.getInstance();//Singleton패턴
	}
	
	public static ReviewServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new ReviewServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<ReviewVO> selectReviewAll(String com_id) throws RemoteException {
		
		return riviewDao.selectReviewAll(com_id);
	}

	@Override
	public List<ReviewVO> selectReview(ReviewVO com_id) throws RemoteException {
		
		return riviewDao.selectReview(com_id);
	}

	@Override
	public List<ReviewVO> selectMyReview(ReviewVO mem_no) throws RemoteException {
		
		return riviewDao.selectMyReview(mem_no);
	}

	@Override
	public int insertReview(ReviewVO vo) throws RemoteException {
		
		return riviewDao.insertReview(vo);
	}

	@Override
	public int deleteReview(ReviewVO vo) throws RemoteException {
		
		return riviewDao.deleteReview(vo);
	}

	@Override
	public int updateReview(ReviewVO vo) throws RemoteException {
		
		return riviewDao.updateReview(vo);
	}

	@Override
	public int upReview(String re_up) throws RemoteException {
		
		return riviewDao.upReview(re_up);
	}

	@Override
	public int downReview(String re_down) throws RemoteException {
		
		return riviewDao.downReview(re_down);
	}

	@Override
	public List<ReviewVO> adminReview() throws RemoteException {

		return riviewDao.adminReview();
	}

	@Override
	public int deleteAdminReview(ReviewVO vo) throws RemoteException {

		return riviewDao.deleteAdminReview(vo);
	}

	@Override
	public List<ReviewVO> checkHolic(ReviewVO vo) throws RemoteException {

		return riviewDao.checkHolic(vo);
	}

	@Override
	public List<ReviewVO> clickedReviewNo(String word) throws RemoteException {
		
		return riviewDao.clickedReviewNo(word);
	}
	
	
	 
	 
}
