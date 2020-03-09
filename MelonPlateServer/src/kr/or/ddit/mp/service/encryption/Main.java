package kr.or.ddit.mp.service.encryption;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Encryption ee = new Encryption();
		String str = "멜론플레이트";
		
		String encode =ee.aesEncode(str);
		System.out.println("암호화대상 : "+ str);
		
		System.out.println("==============================================");
		System.out.println("-암호화당-");
		System.out.println(encode);
		System.out.println("==============================================");
		
		String decode = ee.aesDecode(encode);
		System.out.println("-복호화당-");
		System.out.println(decode);
		System.out.println("==============================================");



	}
	
	
}
