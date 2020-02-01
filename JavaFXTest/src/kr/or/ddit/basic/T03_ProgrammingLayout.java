package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T03_ProgrammingLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		//HBox 컨테이너 생성
		//가로로 배열해줌
		HBox hbox = new HBox();
		
		// 안쪽 여백 설정하기
		// Insert객체는 값을 주는 순서가 위, 오른쪽, 아래, 왼쪽 순임
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setSpacing(50); //컨트롤러와 컨트롤러 사이의 간격
		
		// 한 줄의 데이터를 입력하는 컨트롤 : TextField 객체
		TextField textfield = new TextField();
		textfield.setPrefWidth(200); // textField의 너비 설정
		
		Button btn = new Button(" 확 인 "); //버튼 객체 생성
		
		// HBox에 추가하기
		hbox.getChildren().addAll(textfield, btn);
		
		//Scene 객체 생성
		Scene scene = new Scene(hbox);
		
		primaryStage.setTitle("자바코드를 이용한 레이아웃 생성하기");
		primaryStage.setScene(scene); //scene추가
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
