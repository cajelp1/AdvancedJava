package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T04_FxmlLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// fxml을 읽어와 현재 stage에 적용하기
		
		// Parent 객체는 모든 컨테이너의 조상 객체
		// 방법 1
//		Parent root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
//		Scene scene = new Scene(root);
		
		// 방법2
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
		Parent root = loader.load(); 	//객체를 만들고 인스턴스 객체의 메소드를 부르는 법
		Scene scene = new Scene(root);
		
		
		primaryStage.setTitle("Fxml문서를 이용한 레이아웃 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
