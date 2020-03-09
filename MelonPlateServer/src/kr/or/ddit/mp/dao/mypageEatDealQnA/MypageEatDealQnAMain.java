package kr.or.ddit.mp.dao.mypageEatDealQnA;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.mypageEatDealQnA.MypageEatDealQnAService;
import kr.or.ddit.mp.service.mypageEatDealQnA.MypageEatDealQnAServiceImpl;

public class MypageEatDealQnAMain {
	public static void main(String[] args) {
		try {
			MypageEatDealQnAService melonage = MypageEatDealQnAServiceImpl.getInstance();	
					
			Registry reg = LocateRegistry.createRegistry(8429);
			
			reg.rebind("server", melonage);
			
			System.out.println("QnA 확인");
			
		} catch (Exception e) {
			System.out.println("에러ㅋ");
			e.printStackTrace();
		}
	}
}
