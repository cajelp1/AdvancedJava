package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 * 프린터기능 제공 보조스트림
 */

public class T14_PrintStreamTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream("e:/D_Other/print.txt");
		FileOutputStream fout2 = new FileOutputStream("e:/D_Other/print2.txt");
		
		PrintStream out = new PrintStream(fout);
		
		out.print("안녕하세요. PrintStream입니다 \r\n");
		out.println("안녕하세요. PrintStream입니다2");
		out.println("안녕하세요. PrintStream입니다3");
		
		out.close();
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fout2, "UTF-8"));
		
		writer.print("안녕하세요. PrintWriter입니다 \r\n");
		writer.println("안녕하세요. PrintWriter입니다2");
		writer.println("안녕하세요. PrintWriter입니다3");
		
		writer.close();
		
		System.out.println("출력완료");
	}
}
