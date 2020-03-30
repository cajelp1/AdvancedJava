package thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import vo.ClientVO;

public class ChatServerRunnable implements Runnable{
	
	//UDP 소켓 생성
	private DatagramSocket socket = null;
	
	//메인컨트롤러의 clientList와 clipentMap에 대응하는 변수 생성
	private ObservableList<String> clientList;
	private Map<String, ClientVO> clientMap;
	
	//서버 실행 여부를 관리하는 변수 생성
	private boolean isServerOn = true;
	
	//생성자
	public ChatServerRunnable(ObservableList<String> clientList, Map<String, ClientVO> clientMap){
		try {
			//객체가 생성될 때 소켓을 7777포트로 초기화
			this.socket = new DatagramSocket(7777);
			
			//소켓의 타임아웃을 0.5초로 설정 
			this.socket.setSoTimeout(500);
			
			//MainController로부터 받은 클라이언트 정보 매치
			this.clientList = clientList;
			this.clientMap = clientMap;
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		
		while(isServerOn){
			
			byte[] inMsg = new byte[100];
			DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			try {
				//클라이언트와 연결
				socket.receive(inPacket);
				final InetAddress address = inPacket.getAddress();
				final int port = inPacket.getPort();
				
				boolean isExist = clientList.contains(address.getHostName());
			
				if(!isExist){ // 목록에 존재하지 않는 사용자일 경우
					
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							clientList.add(address.getHostName()); // JavaFx Application 쓰레드 관련 작업
						}
					});
					
					ClientVO vo = new ClientVO(address.getHostAddress(), port, 
									new String(inPacket.getData()).trim() // 대화명에서 불필요한 공백 제거
									);
					
					clientMap.put(address.getHostName(), vo);
					
				}else{ // 목록에 존재하는 사용자일 경우(이미 채팅중인 사용자인 경우...)
				
					System.out.println(new String(inPacket.getData()));
					
					Iterator<String> it = clientMap.keySet().iterator();
					
					ClientVO senderVO =  clientMap.get(address.getHostName());
					
					while(it.hasNext()) {
						String ipAddr = it.next();
						ClientVO vo = clientMap.get(ipAddr);
						InetAddress ipAddr2 = InetAddress.getByName(vo.getIp());
						DatagramPacket outPacket = null;
						
						if(address.getHostName().equals(vo.getIp()) 
							&& (port != vo.getPort())) { // 아이피주소는 동일한데 포트번호가 다른 경우,
							vo.setPort(port);
							clientMap.put(ipAddr, vo); // 기존 정보를 갱신
						}
						
						String sendMsg = "[" + senderVO.getName() + "] " + new String(inPacket.getData());
						
						System.out.println("메시지 : " + sendMsg);
						outPacket = new DatagramPacket
								(sendMsg.getBytes(), sendMsg.getBytes().length, ipAddr2, vo.getPort());
						socket.send(outPacket); // 접속한 클라이언트에게 메시지 전송
					}
				}
				
				//Thread.sleep(500);
			} catch(SocketTimeoutException e){	
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//종료시에는 서버 실행여부를 false로 바꿈
	public void turnOffServer(){
		isServerOn = false;
	}

}
