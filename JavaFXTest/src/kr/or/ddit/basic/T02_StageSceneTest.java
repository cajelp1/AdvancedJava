package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T02_StageSceneTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(); //컨트롤러들을 세로로 배치해주는 컨테이너
		root.setPrefHeight(150); //VBox의 높이
		root.setPrefWidth(650);	 //VBOX의 너비
		root.setAlignment(Pos.CENTER); //컨트롤러 가운데 정렬
		root.setSpacing(20); //컨트롤러 사이의 간격
		
		Label label = new Label(); // label객체 생성
		label.setText("안녕하세요. JavaFX입니다");
		label.setFont(new Font(50)); // Font 객체 이용하여 글자크기 설정
		
		Button btn = new Button();
		btn.setText("확   인");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 처리할 내용을 기술하는 영역
				Platform.exit(); // 프로그램 종료. 종료할때는 platform 이라하네
				
			}
		});
		
		
		btn.setOnAction(/*(ActionEvent event*/ e/*)*/->{
			Platform.exit(); });
		// 함수적인터페이스라 이렇게 사용할 수 있다.
		btn.setOnAction(e-> Platform.exit());
		// 이렇게 줄일수도 있음.
		
		
		// VBox에 컨트롤들 추가하기
		root.getChildren().add(label);
		root.getChildren().add(btn);
		
		// VBox 를 루트 컨테이너로 하는 Scene 객체 생성
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Stage와 Scene 연습"); // 창 제목
		primaryStage.setScene(scene); // Stage에 Scene 설정
		primaryStage.show(); // 창 보이기
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
