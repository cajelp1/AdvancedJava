package thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

import javafx.scene.control.TextArea;

public class ChatClientRunnable implements Runnable{
	
	//메인 컨트롤러의 요소 및 패킷에 필요한 변수 생성
	private TextArea txArea;
	private DatagramSocket socket = null;
	private byte[] msg = new byte[1000];
	
	public ChatClientRunnable(TextArea textArea_chatList, DatagramSocket socket){
		this.txArea = textArea_chatList;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		while(true){
			DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
			try {
				socket.receive(inPacket); // 이 메서드는 패킷을 수신할때까지 BLOCK 됨. 패킷 안 에 msg.
				System.out.println(new String(inPacket.getData()));
				txArea.appendText(new String(inPacket.getData())+"\n");
				
			}catch (SocketTimeoutException e){
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
