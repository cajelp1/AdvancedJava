package application;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import thread.ChatServerRunnable;
import vo.ClientVO;

public class MainController implements Initializable{
	
	// 클라이언트들의 ip를 적을 listview, 그 listview에 들어갈 list, 클라이언트 정보를 담을 map
	@FXML private ListView<String> lvClient;
	private ObservableList<String> clientList;
	private Map<String, ClientVO> clientMap;
	
	//채팅 참여하는 클라이언트를 list에 추가해 줄 쓰레드
	private ChatServerRunnable chatServerRunnable = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//리스트를 테이블에 새팅
		clientList = FXCollections.observableArrayList();
		lvClient.setItems(clientList);
		
		clientMap = Collections.synchronizedMap(new HashMap<>());
	}
	
	@FXML
	public void turnOnServer(ActionEvent event){
		System.out.println("서버가 시작되었음...");
		
		//서버실행 버튼을 누르면 클라이언트의 ip주소를 추가하고 메시지를 주고받는 쓰레드 시작
		chatServerRunnable = new ChatServerRunnable(clientList, clientMap);
		Thread thread = new Thread(chatServerRunnable);
		thread.setDaemon(true);
		thread.start();
	}
	
	@FXML
	public void turnOffServer(ActionEvent event){
		
		//서버를 종료하는 메서드 실행. 스레드의 조건문의 변수를 false로.
		chatServerRunnable.turnOffServer();
		//서버가 종료시 클라이언트 리스트 초기화
		clientList.clear();
	}
	
}
