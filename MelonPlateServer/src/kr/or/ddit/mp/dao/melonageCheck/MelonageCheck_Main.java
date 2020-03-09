package kr.or.ddit.mp.dao.melonageCheck;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.melonageCheck.MileageCheckService;
import kr.or.ddit.mp.service.melonageCheck.MileageCheckServiceImpl;

public class MelonageCheck_Main {
	public static void main(String[] args) {
		try {
			MileageCheckService melonage = MileageCheckServiceImpl.getInstance();	
					
			Registry reg = LocateRegistry.createRegistry(8429);
			
			reg.rebind("server", melonage);
			
			System.out.println("멜론 확인");
			
		} catch (Exception e) {
			System.out.println("에러ㅋ");
			e.printStackTrace();
		}
	}
}
