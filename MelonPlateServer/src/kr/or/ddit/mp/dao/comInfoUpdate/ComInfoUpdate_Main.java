package kr.or.ddit.mp.dao.comInfoUpdate;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.comInfoUpdate.ComInfoUpdateImpl;
import kr.or.ddit.mp.service.comInfoUpdate.ComInfoUpdateService;

public class ComInfoUpdate_Main {
	public static void main(String[] args) {
		try {
			ComInfoUpdateService comUpdate = ComInfoUpdateImpl.getInstance();
					
			Registry reg = LocateRegistry.createRegistry(8429);
			
			reg.rebind("server", comUpdate);
			
			System.out.println("업체정보 수정");
			
		} catch (Exception e) {
			System.out.println("에러ㅋ");
			e.printStackTrace();
		}
	}
}
