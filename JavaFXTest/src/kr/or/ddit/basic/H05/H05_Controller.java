package kr.or.ddit.basic.H05;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class H05_Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML private TableView<?> tableView;
    @FXML private TableColumn<?, ?> name;
    @FXML private TableColumn<?, ?> korean;
    @FXML private TableColumn<?, ?> math;
    @FXML private TableColumn<?, ?> english;
    
    @FXML private Button add;
    @FXML private Button barGraph;
    @FXML private Button pieGraph;


    @FXML
    void initialize() {
       
    }
    
    @FXML
    void addScore(ActionEvent event) {
    	// 1. state객체 사용
    	Stage addScore = new Stage(StageStyle.UTILITY);
    	
    	// 2. 모딜창 여부 설정
    	// 모딜창은 자식창이 나타나면 부모창을 사용할 수 없다.
    	addScore.initModality(Modality.APPLICATION_MODAL);
    	
    	// 3. 부모창 지정
    	//dialog.initOwner(primaryStage); //뭐야 primaryStage 안 해줘도 일단 동작은 하는데요? 부모창이 없을 뿐.
    	addScore.setTitle("사용자 정의 창");
    	
    	// 4. 자식창이 나타날 컨테이너 객체 생성
    	Parent parent = null;
    	
    	try {
    		parent = FXMLLoader.load(getClass().getResource("H05_add.fxml"));
    	}catch(IOException ex) {ex.printStackTrace();}
    	
    	
    	//부모창에서 FXML로 만든 자식창의 컨트롤객체 얻기
    	TextField txtName = (TextField) parent.lookup("#txtName");
    	TextField txtKorean = (TextField) parent.lookup("#txtKorean");
    	TextField txtMath = (TextField) parent.lookup("#txtMath");
    	TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
    	
    	//뭐야.. 버튼 액션을 다 일일이 써야하네 ㅡㅡ
    	Button btnAdd = (Button) parent.lookup("#btnAdd");
    	btnAdd.setOnAction(btnAddScore -> {
    		System.out.println("이름 : "+txtName.getText());
    		System.out.println("국어 : "+txtKorean.getText());
    		System.out.println("수학 : "+txtMath.getText());
    		System.out.println("영어 : "+txtEnglish.getText());
    		addScore.close();
    	});
    	
    	Button btnCancel = (Button) parent.lookup("#btnCancel");
    	btnCancel.setOnAction(btnCancelScore -> {
    		addScore.close();
    	});
    	
    	// 5. Scene 객체 생성해서 컨테이너 객체 추가 
    	Scene scene = new Scene(parent);
    	
    	// 6. Stage객체에 Scene추가
    	addScore.setScene(scene);
    	addScore.setResizable(false); //크기고정
    	addScore.show();
    }
    
    @FXML
    void showBar(ActionEvent event) {

    }

    @FXML
    void showPie(ActionEvent event) {

    }

}
