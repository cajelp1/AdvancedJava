package kr.or.ddit.hl.view.qna;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QnaMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fx = new FXMLLoader(getClass().getResource("qna_main.fxml"));
		Parent root = fx.load();
		QnaController qm = fx.getController();
		qm.setStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("QnA");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
