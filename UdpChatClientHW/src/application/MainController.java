package application;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import thread.ChatClientRunnable;

public class MainController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private TextArea txArea;

    @FXML private TextField cName;
    @FXML private TextField cText;

    @FXML private Button btnSend;
    @FXML private Button btnExit;
    
    private DatagramSocket socket = null;
	private byte[] msg = new byte[100];
	InetAddress serverAddress = null;

    @FXML
    void initialize() {
    	//cName의 값 설정
    	
    	try {
			socket = new DatagramSocket();
			socket.setSoTimeout(500);
			serverAddress = InetAddress.getByName("localhost"); // 서버주소 설정
			String chatName = showPromptWindow(); // 대화명을 입력받는다.
			
			// 대화명 전송
			DatagramPacket outPacket = new DatagramPacket
					(chatName.getBytes(), chatName.getBytes().length, serverAddress, 7777);
			socket.send(outPacket);
			
			txArea.setEditable(false); // 읽기 전용 속성설정
			
			ChatClientRunnable chatClientRunnable = new ChatClientRunnable(txArea, socket);
			Thread thread = new Thread(chatClientRunnable);
			thread.start();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    @FXML
    void msgSend(ActionEvent event) {
    	String message = cText.getText();
		DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.getBytes().length, serverAddress, 7777);
		try {
			socket.send(outPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cText.setText("");
    }

    @FXML
    void chatExit(ActionEvent event) {
    	
    }
    
    
    //대화명을 입력받을 창 띄우기
    private String showPromptWindow(){
		
		String strResult = "";  // 대화가 저장될 변수 선언
		
		do{
			TextInputDialog javaPrompt = new TextInputDialog("대화명"); 
			
			javaPrompt.setTitle("대화명 입력창"); // 창 제목
			javaPrompt.setHeaderText("대화명을 입력해 주세요."); // 출력 메시지
			
			Optional<String> result = javaPrompt.showAndWait();
			
			// 입력한 값이 있는지 검사 (값 입력후 'OK'버튼 눌렀는지 검사)
			if(result.isPresent()) { 
				strResult = result.get(); // 값 읽어오기
			}
		}while(strResult.isEmpty());
		
		return strResult;
	}
}

