package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T13_DataIOStreamTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("e:/D_Other/test.dat");
			
			//DataOutputStream은 출력용 데이터를 자요형에 맞게 출력해준다
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeUTF("홍길동");	// 문자열 데이터 출력(UTF-8)
			dout.writeInt(18); 		//정수형 데이터 출력
			dout.writeFloat(3.14f);	//실수형 float 데이터 출력
			dout.writeDouble(3.14); //실수형 double 데이터 출력
			dout.writeBoolean(true);//논리형으로 출력
			dout.writeUTF("홍sef길동ehdsdf");	// 이것도 읽어올 수 있나?
			
			System.out.println("출력완료");
			
			//---------------------------------------------
			//출력자료 읽어오기
			
			FileInputStream fin = new FileInputStream("e://D_Other/test.dat");
			
			DataInputStream din = new DataInputStream(fin);
			
			// 뭐야 읽어오는거 자료형 순서틀리면 못 읽어오네... 자료형 크기가 틀려서 그런가봐... 
			System.out.println("문자열 자료 : " + din.readUTF());
			System.out.println("정수형 자료 : " + din.readInt());
			System.out.println("실수float형 자료 : " + din.readFloat());
			System.out.println("실수double형 자료 : " + din.readDouble());
			System.out.println("논리형 자료 : " + din.readBoolean());
			
			din.close();
			dout.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
