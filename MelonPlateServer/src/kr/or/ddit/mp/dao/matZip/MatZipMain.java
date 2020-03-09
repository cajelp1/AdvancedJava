package kr.or.ddit.mp.dao.matZip;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.matZip.MatZipService;
import kr.or.ddit.mp.service.matZip.MatZipServiceImpl;

public class MatZipMain {
	public static void main(String[] args) {
		try {
			MatZipService melonage = MatZipServiceImpl.getInstance();	
					
			Registry reg = LocateRegistry.createRegistry(8429);
			
			reg.rebind("server", melonage);
			
			System.out.println("goodcom 확인");
			
		} catch (Exception e) {
			System.out.println("에러ㅋ");
			e.printStackTrace();
		}
	}
}
