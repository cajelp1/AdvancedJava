package kr.or.ddit.hl.view.review;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReviewMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fx = new FXMLLoader(getClass().getResource("review_main.fxml"));
		Parent root = fx.load();
		ReviewController rc = fx.getController();
		rc.setStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Review");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
