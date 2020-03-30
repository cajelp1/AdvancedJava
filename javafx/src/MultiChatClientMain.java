
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Observable;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MultiChatClientMain extends Application {

	private TextArea taContent;
	private TextField tfMessage;
	private Button btnSend; // 메시지 전송 버튼
	private Button btnFileSend; // 파일 수신 버튼
	private ListView<String> lvFileList; // 수신된 파일 목록
	
	private Socket socket;
	private DataOutputStream dout;
	private String name = "대화명";
	
	private ObservableList<String> sentFileList = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("MultichatClient.fxml"));

		btnSend = (Button) root.lookup("#btnSend");
		btnFileSend = (Button) root.lookup("#btnFileSend");
		lvFileList = (ListView<String>) root.lookup("#lvFileList");
		
		sentFileList.add("hello");
		
		
		lvFileList.setItems(sentFileList);
		
		taContent = (TextArea) root.lookup("#taContent");
		taContent.setEditable(false);
		tfMessage = (TextField) root.lookup("#tfMessage");
		
		
		
		
		
		btnSend.setOnAction(e->{ // 전송버튼 눌렀을때...
			
			Thread senderThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						dout = new DataOutputStream(socket.getOutputStream());
				
						if( dout != null) {
							//  메시지를 서버로 전송
							dout.writeUTF("[" + name + "] " +  tfMessage.getText() );
							tfMessage.setText(""); // 초기화
						}
					}catch(IOException e) {
						
					}
				}
			});
			
			senderThread.start();
		});
		
		
		btnFileSend.setOnAction(event -> {
			FileChooser filechooser = new FileChooser();
			filechooser.getExtensionFilters().addAll(
				new ExtensionFilter("All Files", "*.*")
			);
			
			File selFile = filechooser.showSaveDialog(primaryStage);
			if(selFile!=null) {
				// 이 곳에서 선택한 파일을 이용한 저장 작업을 수행한다.
				System.out.println("SAVE : " + selFile.getPath());
				
				fileReceiverStart(selFile.getPath());
			}
		});
		
		
		
		// ListView의 내용은 변경되지 않고 화면에 보이는 부분만
		// 변경하는 방법
		lvFileList.setCellFactory(
			new Callback<ListView<String>, ListCell<String>>() {
				@Override
				public ListCell<String> call(ListView<String> param) {
					return new ListCell<String>() {
						protected void updateItem(String item, boolean empty) {
							super.updateItem(item, empty);
							if(item!=null) { // 또는 !empty
								//setGraphic(rect);  // 값변경하기
								// 변경되는 데이터가 문자열이면 setText()메서드를
								// 사용한다.
								ImageView imageView = new ImageView("file:/D:/aaaa.jpg");
								Label lblTxt = new Label(item);
								
								HBox hb2 = new HBox(10);
								hb2.getChildren().addAll(imageView, lblTxt);
								
								setGraphic(hb2);	
							}
						}
					};
				}
			}
		);


		Scene scene = new Scene(root);

		primaryStage.setTitle("JavaFx MultiChatClient 프로그램");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		inputDialogshow(primaryStage); // 대화명 설정 다이얼로그 열기
		
	}
	
	
	public void inputDialogshow(Stage owner) {
		
		Stage inputDialog = new Stage();
		inputDialog.initOwner(owner);
		inputDialog.initModality(Modality.APPLICATION_MODAL);
		inputDialog.setTitle("대화명 설정창");
		
		HBox hbox = new HBox();
		
		TextField tfAlias = new TextField();
		Button btnSetAlias = new Button("확인");
		
		btnSetAlias.setOnAction(e->{
			
			name = tfAlias.getText();
			inputDialog.close(); // 창닫기
			
			
			new Thread(new Runnable() { // 클라이언트 쓰레드 생성 및 스타트
				
				@Override
				public void run() {
					
					clientStart();  // 클라이언트 시작
				}
			}).start();
			
		});
		
		hbox.getChildren().addAll(tfAlias, btnSetAlias);
		
		Scene scene = new Scene(hbox);
		inputDialog.setScene(scene);
		inputDialog.showAndWait();
	}
	
	// 비지니스 로직 처리
	public void clientStart() {
		
		try {
			String serverIp = "192.168.205.21"; // 서버IP
			socket = new Socket(serverIp, 7777);
			
			displayMessage("서버에 연결되었습니다.");
			
			// 대화명 전송하기
			dout = new DataOutputStream(socket.getOutputStream());
			if(dout != null) {
				dout.writeUTF(name);
			}
			
			// 수신용 쓰레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			// 수신용 쓰레드 실행
			receiver.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 수신용 Thread 클래스 정의
	class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream din;
		
		// 생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(din!=null) {
				try {
					// 서버로부터 수신한 메시지 출력하기
					displayMessage(din.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/**
	 * Platform.runLater 를 이용한 메시지 처리
	 * @param msg
	 */
	public void displayMessage(final String msg) {
		Platform.runLater(()->{
			taContent.appendText(msg + "\n");
		});
	}
	
	
	/**
	 *  클라이언트는 서버에 접속하여 서버가 보내주는 파일을 D드라이브의 C_Lib폴더에 저장한다.
	 */
	public void fileReceiverStart(String filePath) {
		Socket socket = null;
		InputStream in = null;
		FileOutputStream fout = null;
		File file = new File(filePath); // 저장할 파일 설정
		try {
			socket = new Socket("localhost", 8888);
			System.out.println("파일 다운로드 시작...");

			fout = new FileOutputStream(file);
			in = socket.getInputStream();

			byte[] tmp = new byte[1024];
			int length = 0;
			while ((length = in.read(tmp)) != -1) {
				fout.write(tmp, 0, length);
			}
			fout.flush();
			System.out.println("파일 다운로드 완료...");
			
			Platform.runLater(()->{
				displayFileInfo(filePath);
			});
			
		} catch (IOException e) {

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	
	public void displayFileInfo(String filePath) {
		//vbFileSend.getChildren().add(new Button("이미지"));
		//vbFileSend.getChildren().add(new ImageView(filePath));
	}

}
