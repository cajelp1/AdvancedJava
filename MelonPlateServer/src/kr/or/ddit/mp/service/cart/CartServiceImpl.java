package kr.or.ddit.mp.service.cart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.cart.CartDaoImpl;
import kr.or.ddit.mp.vo.cart.CartVO;
import kr.or.ddit.mp.vo.cart.EatdealVO;
import kr.or.ddit.mp.vo.cart.MileageVO;
import kr.or.ddit.mp.vo.cart.RequestVO;
import kr.or.ddit.mp.vo.cart.PayVO;


public class CartServiceImpl extends UnicastRemoteObject implements ICartService {

	CartDaoImpl cartDao; // 사용할 다오 멤버변수 선언
	private static CartServiceImpl service; // 싱글톤 패턴
	
	private CartServiceImpl() throws RemoteException{
		super();
		cartDao = CartDaoImpl.getInstance(); // 싱글톤 패턴
	}
	
	public static CartServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new CartServiceImpl();
		}
		return service;
	}
	
	
	
	
	@Override
	public int insertCart(CartVO cv) throws RemoteException {
		return cartDao.insertCart(cv);
	}

	@Override
	public List<CartVO> getAllCartList(CartVO cvo) throws RemoteException {
		return cartDao.getAllCartList(cvo);
	}

	@Override
	public int deleteCart(CartVO cv) throws RemoteException {
		return cartDao.deleteCart(cv);
	}

	@Override
	public List<CartVO> getEatdealName(CartVO cvo) {
		return cartDao.getEatdealName(cvo);
	}

	@Override
	public List<MileageVO> getMileage(MileageVO mvo) throws RemoteException {
		return cartDao.getMileage(mvo);
	}

	@Override
	public List<CartVO> getEatdealprice(CartVO cvo) throws RemoteException {
		return cartDao.getEatdealprice(cvo);
	}

	@Override
	public List<RequestVO> requestSelect(String word) throws RemoteException {
		return cartDao.requestSelect(word);
	}

	@Override
	public List<EatdealVO> getEatdealInfo(CartVO cvo) throws RemoteException {
		return cartDao.getEatdealInfo(cvo);
	}

	@Override
	public int requestPayInsert(RequestVO revo) throws RemoteException {
		return cartDao.requestPayInsert(revo);
	}

	@Override
	public int payInsert(PayVO pvo) throws RemoteException {
		return cartDao.payInsert(pvo);
	}

	@Override
	public int mileNotuseInsert(MileageVO mvo) throws RemoteException {
		return cartDao.mileNotuseInsert(mvo);
	}

	@Override
	public int mileUseInsert(MileageVO mvo) throws RemoteException {
		return cartDao.mileUseInsert(mvo);
	}

	@Override
	public int eatdealQtyDown(EatdealVO evo) throws RemoteException {
		return cartDao.eatdealQtyDown(evo);
	}

}
