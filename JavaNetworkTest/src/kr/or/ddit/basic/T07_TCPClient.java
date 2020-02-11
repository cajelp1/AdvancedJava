package kr.or.ddit.basic;

import java.net.Socket;

public class T07_TCPClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8888); //("localhost", 8888);
			System.out.println("서버에 연결되었습니다.");
			
			Sender sender = new Sender(socket);
			Receiver reciever = new Receiver(socket);
			
			sender.start();
			reciever.start();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
