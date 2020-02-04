package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	'd:/D_Other/'에 있는 'Tulips.jpg'파일을
	'복사본_Tulips.jpg'로 복사하는 프로그램을 작성하시오.
 */

public class H01_fileDuplication {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fin = new FileInputStream("e:/D_Other/Tulips.jpg");
		FileOutputStream fout = new FileOutputStream("e:/D_Other/복사본_Tulips.jpg");
		
		int c;
		
		while((c = fin.read()) != -1) {
			fout.write(c);
		}
		System.out.println("복사완료");
		
		fin.close();
		fout.close();
	}
}
