package kr.or.ddit.mp.dao.memInfoUpdate;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.mp.service.memInfoUpdate.MemInfoUpdateService;
import kr.or.ddit.mp.service.memInfoUpdate.MemInfoUpdateImpl;

public class MemInfoUpdate_Main {
	public static void main(String[] args) {
		try {
			MemInfoUpdateService memUpdate = MemInfoUpdateImpl.getInstance();
					
			Registry reg = LocateRegistry.createRegistry(8429);
			
			reg.rebind("server", memUpdate);
			
			System.out.println("회원정보 수정");
			
		} catch (Exception e) {
			System.out.println("에러ㅋ");
			e.printStackTrace();
		}
	}
}
