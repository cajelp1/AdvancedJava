package kr.or.ddit.hl.view.cust;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kr.or.ddit.hl.view.qna.QnaController;

public class CustMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fx = new FXMLLoader(getClass().getResource("cust_main.fxml"));
		Parent root = fx.load();
		CustController cc = fx.getController();
		cc.setStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("CustomerCenter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
