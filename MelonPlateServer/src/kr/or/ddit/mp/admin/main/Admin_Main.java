package kr.or.ddit.mp.admin.main;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.admin.AdminService;
import kr.or.ddit.mp.service.admin.AdminServiceImpl;

public class Admin_Main {
	public static void main(String[] args) {
		try {
			AdminService as = AdminServiceImpl.getInstance();	
					
			Registry reg = LocateRegistry.createRegistry(8429);
			
			reg.rebind("server", as);
			
			System.out.println("석양이 진다...");
			
		} catch (Exception e) {
			System.out.println("에러ㅋ");
			e.printStackTrace();
		}
	}
}
