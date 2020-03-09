package kr.or.ddit.mp.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.Login.ILoginService;
import kr.or.ddit.mp.service.Login.LoginServiceImpl;
import kr.or.ddit.mp.service.admin.AdminService;
import kr.or.ddit.mp.service.admin.AdminServiceImpl;
import kr.or.ddit.mp.service.alleatdeal.AllEatdealServiceImpl;
import kr.or.ddit.mp.service.alleatdeal.IAllEatdealService;
import kr.or.ddit.mp.service.buylist.BuylistServiceImpl;
import kr.or.ddit.mp.service.cart.CartServiceImpl;
import kr.or.ddit.mp.service.chat.ChatServerImpl;
import kr.or.ddit.mp.service.comInfoUpdate.ComInfoUpdateImpl;
import kr.or.ddit.mp.service.comInfoUpdate.ComInfoUpdateService;
import kr.or.ddit.mp.service.comeatdeal.ComEatdealServiceImpl;
import kr.or.ddit.mp.service.comeatdeal.IComEatdealService;
import kr.or.ddit.mp.service.eatdealQA.EatdealQAServiceImpl;
import kr.or.ddit.mp.service.eatdealQA.IEatdealQAService;
import kr.or.ddit.mp.service.eatdealhome.EatdealHomeServiceImpl;
import kr.or.ddit.mp.service.eatdealhome.IEatdealHomeService;
import kr.or.ddit.mp.service.goodcom.GoodcomServiceImpl;
import kr.or.ddit.mp.service.goodcom.IGoodcomService;
import kr.or.ddit.mp.service.home.HomeServiceImpl;
import kr.or.ddit.mp.service.home.IHomeService;
import kr.or.ddit.mp.service.join.ComJoinServiceImpl;
import kr.or.ddit.mp.service.join.IComJoinService;
import kr.or.ddit.mp.service.join.IJoinService;
import kr.or.ddit.mp.service.join.JoinServiceImpl;
import kr.or.ddit.mp.service.matZip.MatZipService;
import kr.or.ddit.mp.service.matZip.MatZipServiceImpl;
import kr.or.ddit.mp.service.melonageCheck.MileageCheckService;
import kr.or.ddit.mp.service.melonageCheck.MileageCheckServiceImpl;
import kr.or.ddit.mp.service.memInfoUpdate.MemInfoUpdateImpl;
import kr.or.ddit.mp.service.memInfoUpdate.MemInfoUpdateService;
import kr.or.ddit.mp.service.mypageEatDealQnA.MypageEatDealQnAService;
import kr.or.ddit.mp.service.mypageEatDealQnA.MypageEatDealQnAServiceImpl;
import kr.or.ddit.mp.service.paydeal.IPaydealService;
import kr.or.ddit.mp.service.paydeal.PaydealServiceImpl;
import kr.or.ddit.mp.service.qnacomeatdeal.IQnacomEatdealService;
import kr.or.ddit.mp.service.qnacomeatdeal.QnacomEatdealServiceImpl;
import kr.or.ddit.mp.service.recogeatdeal.RecogeatdealServiceImpl;
import kr.or.ddit.mp.service.reservation.IReservationService;
import kr.or.ddit.mp.service.reservation.ReservationServiceImpl;
import kr.or.ddit.mp.service.review.IReviewService;
import kr.or.ddit.mp.service.review.ReviewServiceImpl;
import kr.or.ddit.mp.service.salescom.ISalesComService;
import kr.or.ddit.mp.service.salescom.SalesComServiceImpl;
import kr.or.ddit.mp.service.searchgoodcom.ISearchGoodcomService;
import kr.or.ddit.mp.service.searchgoodcom.SearchGoodcomServiceImpl;
import kr.or.ddit.mp.service.wantgo.IWantgoService;
import kr.or.ddit.mp.service.wantgo.WantgoServiceImpl;
import kr.or.ddit.mp.service.zone.IZoneService;
import kr.or.ddit.mp.service.zone.ZoneServiceImpl;

public class ServerMain {
	public static void main(String[] args) {
		try {
			
			Registry reg = LocateRegistry.createRegistry(8429);
			
			/**
			 * 은혜
			 */
			IGoodcomService goodcom 	  	= GoodcomServiceImpl.getInstance();	
			IWantgoService wantgo 		  	= WantgoServiceImpl.getInstance();	
			ISearchGoodcomService searchcom = SearchGoodcomServiceImpl.getInstance();
			IComEatdealService comEat 		= ComEatdealServiceImpl.getInstance();
			IQnacomEatdealService qnaCom 	= QnacomEatdealServiceImpl.getInstance();
			ISalesComService salesCom 		= SalesComServiceImpl.getInstance();
			IEatdealHomeService eatdealHome = EatdealHomeServiceImpl.getInstance();
			IPaydealService paydeal 		= PaydealServiceImpl.getInstance();
			IHomeService home				= HomeServiceImpl.getInstance();
			IAllEatdealService alleat		= AllEatdealServiceImpl.getInstance();
			ChatServerImpl Server = new ChatServerImpl(); 
			
			
			
			
			BuylistServiceImpl blist = BuylistServiceImpl.getInstance(); // 병규
			CartServiceImpl cartEatDeal = CartServiceImpl.getInstance(); // 병규
			RecogeatdealServiceImpl recogEatDeal = RecogeatdealServiceImpl.getInstance(); //병규
			/*우석*/
			AdminService admin 				= AdminServiceImpl.getInstance(); 
			MileageCheckService mileage 	= MileageCheckServiceImpl.getInstance();
			MemInfoUpdateService meminfo	= MemInfoUpdateImpl.getInstance();//실수로 이름에 service를빼놈ㅎ;
			MypageEatDealQnAService qna 	= MypageEatDealQnAServiceImpl.getInstance();
			MatZipService matzip 			= MatZipServiceImpl.getInstance();
			ComInfoUpdateService cominfo 	= ComInfoUpdateImpl.getInstance();//실수로 이름에 service를빼놈ㅎ;
			
			/* 혜영 */
			IReviewService irs = ReviewServiceImpl.getInstance(); //리뷰
			IReservationService irvs = ReservationServiceImpl.getInstance(); //예약 
			IEatdealQAService ieqas = EatdealQAServiceImpl.getInstance(); //잇딜QA	
			IZoneService izs	= ZoneServiceImpl.getInstance(); //관심지역
			
			/*진호*/
			ILoginService ils = LoginServiceImpl.getInstance(); // 로그인
			IJoinService  ijs = JoinServiceImpl.getInstance(); // 회원가입 
			IComJoinService icjs = ComJoinServiceImpl.getInstance(); // 업체 회원가입
			

			
			
			/**
			 * 은혜
			 */
			reg.rebind("goodcomService", goodcom);
			reg.rebind("wantgoService", wantgo);
			reg.rebind("searchComService", searchcom);
			reg.rebind("comEatService", comEat);
			reg.rebind("qnaComService", qnaCom);
			reg.rebind("SalesService", salesCom);
			reg.rebind("RMIChatServer", Server);
			reg.rebind("eatdealHomeService", eatdealHome);
			reg.rebind("paydealService", paydeal);
			reg.rebind("homeService", home);
			reg.rebind("alleatService", alleat);
			
			
			
			
			reg.rebind("buylist", blist);// 병규
			reg.rebind("cart", cartEatDeal);// 병규
			reg.rebind("recog", recogEatDeal);// 병규
			
			/*우석*/
			reg.rebind("AdminService", admin);
			reg.rebind("MileageCheckService", mileage);
			reg.rebind("MemInfoUpdateService", meminfo);
			reg.rebind("MypageEatDealQnAService", qna);
			reg.rebind("MatZipService", matzip);
			reg.rebind("ComInfoUpdateService", cominfo);
			
			
			/*진호*/
			reg.rebind("userlogin", ils);
			reg.rebind("userjoin", ijs);
			reg.rebind("comjoin", icjs);
			
			/* 혜영 */
			reg.rebind("review", irs); //리뷰
			reg.rebind("reservation", irvs); //예약
			reg.rebind("eatdealqa", ieqas); //잇딜qa
			reg.rebind("zone", izs); //관심지역
			
		} catch (Exception e) {
			System.out.println("에러다!");
			e.printStackTrace();
		}
		System.out.println("먹고, 나누고, 행복해지세요! 멜론플레이트 서버 구동중...♥");
	}
}
