package kr.or.ddit.mp.dao.cart;

import java.util.List;

import kr.or.ddit.mp.vo.cart.CartVO;
import kr.or.ddit.mp.vo.cart.EatdealVO;
import kr.or.ddit.mp.vo.cart.MileageVO;
import kr.or.ddit.mp.vo.cart.RequestVO;
import kr.or.ddit.mp.vo.cart.PayVO;


public interface ICartDao {
	
	
	/**
	 * eat딜 이름을 받아서 삭제 성공결과 반환
	 * @param cv(DB에 저장된 정보와 비교 가능한 정보가 담긴 객체)
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int deleteCart(CartVO cvo);
	
	/**
	 * 카트멤버변수를 가진 객체를 받아서 인서트 성공(장바구니에 관심 eat딜 추가)결과 값을 인트로 받는 메서드
	 * @param cv (DB에 저장할 정보가 담긴 객체)
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertCart(CartVO cvo);
	
	/**
	 * 테이블의 데이터를 가져와서 장바구니 리스트에 반환하는 메서드
	 * @return CartVO 정보를 담고 있는 list객체
	 */
	public List<CartVO> getAllCartList(CartVO cvo);
	
	/**
	 * eat딜 테이블에서 eat딜 이름을 가져옴
	 * @param cvo
	 * @return
	 */
	public List<CartVO> getEatdealName(CartVO cvo);
	
	
	/**
	 * 마일리지 테이블에서 해당 회원의 마일리지 가져옴
	 * @param mvo
	 * @return
	 */
	public List<MileageVO> getMileage(MileageVO mvo);
	
	/**
	 * eat딜 테이블에서 eat딜 가격을 가져옴
	 * @param cvo
	 * @return
	 */
	public List<CartVO> getEatdealprice(CartVO cvo);
	
	
	public List<RequestVO> requestSelect(String word);
	
	/**
	 * getEatdealName으로 가져온 eat딜 네임으로 해당 eat딜의 전체 정보를 가져온다
	 * @param cvo
	 * @return List<EatdealVO>
	 */
	public List<EatdealVO> getEatdealInfo(CartVO cvo);
	
	public int requestPayInsert(RequestVO revo);
	
	public int payInsert(PayVO pvo);
	/**
	 * 마일리지를 사용하지 않았을 때 MileageVO의 정보를 마일리지 테이블에 인서트
	 * @param mvo
	 * @return
	 */
	public int mileNotuseInsert(MileageVO mvo);
	
	/**
	 * 마일리지를 사용했을 때 MileageVO의 정보를 마일리지 테이블에 인서트
	 * @param mvo
	 * @return
	 */
	public int mileUseInsert(MileageVO mvo);
	
	/**
	 * 결제한 eat딜 수량만큼 eat딜 테이블의 해당 eat딜에서 차감
	 * @param evo
	 * @return
	 */
	public int eatdealQtyDown(EatdealVO evo);
}
