package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class T16_DialogueTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(10);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		//파일열기창
		Button btnFileOpen = new Button("Open FileChooser 실행");
		btnFileOpen.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			
			//확장자별로 파일 구분하는 필터 등록하기
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files", "*.txt"),
					new ExtensionFilter("Image Files", "*.jpg","*.png","*.gif"),
					new ExtensionFilter("audio Files", "*.wav","*.mp3"),
					new ExtensionFilter("All Files", "*.*")
				);
			
			//Dialogue 창에서 '열기'버튼을 누르면 선택한 파일정보가 반환되고 '취소'버튼을 누르면 null이 반환된다.
			File selectFile = fileChooser.showOpenDialog(primaryStage);
			
			if(selectFile != null) {
				//이 영역에서 파일내용을 읽어오는 작업을 수행한다.
				System.out.println("Open : "+selectFile.getPath());
			}
		});
		
		
		Button btnFileSave = new Button("Save FileChooser 실행");
		
		btnFileSave.setOnAction(e2->{
			FileChooser fileChooser2 = new FileChooser();
			fileChooser2.getExtensionFilters().addAll(
					new ExtensionFilter("All Files", "*.*")
				);
			
			File selFile = fileChooser2.showSaveDialog(primaryStage);
			
			if(selFile != null) {
				//이곳에서 선택한 파일을 이용한 저장 작업을 수행한다
				System.out.println("Save : "+selFile.getPath());
			}
		});
		
		
		//폴더 (디렉토리)만 선택하는 Dialogue창
		Button btnDirectory = new Button("Directory Chooser 실행");
		
		btnDirectory.setOnAction(e3 -> {
			DirectoryChooser dirChooser = new DirectoryChooser();
			File selDir = dirChooser.showDialog(primaryStage);
			if(selDir != null) {
				System.out.println("Directory : "+selDir);
			}
		});
		//-----------------------------------------------------------
		
		
		Button btnPopup = new Button("Popup 실행");
		btnPopup.setOnAction(e4->{
			//Popup창에 나타낼 컨트롤들을 구성 시작...
			HBox popRoot = new HBox();
			
			ImageView imgView = new ImageView();
			imgView.setImage(new Image(getClass().
					getResource("./images/ok.png").toString()));
			imgView.setFitWidth(30);
			imgView.setFitHeight(30);
			
			Label lbMsg = new Label("메시지가 왔습니다");
			HBox.setMargin(lbMsg, new Insets(0,5,0,5));
			
			popRoot.getChildren().addAll(imgView, lbMsg);
			//구성 끝...
			
			//Popup 객체 생성 후 위에서 구성한 컨트롤들 추가 후 보이기
			
			Popup popup = new Popup();
			popup.setX(1000);
			popup.setY(400);
			popup.getContent().add(popRoot);
			popup.setAutoHide(true);
			popup.show(primaryStage);
		});
		
		//사용자가 만든 임의의 창 나타내기
		Button btnCustom = new Button("사용자 정의 창 실행");
		btnCustom.setOnAction(e->{
			//새 창 띄우기
			
			// 1. state객체 사용
			Stage dialog = new Stage(StageStyle.UTILITY);
			
			// 2. 모딜창 여부 설정
			// 모딜창은 자식창이 나타나면 부모창을 사용할 수 없다.
			dialog.initModality(Modality.APPLICATION_MODAL);
			
			// 3. 부모창 지정
			dialog.initOwner(primaryStage);
			dialog.setTitle("사용자 정의 창");
			
			// 4. 자식창이 나타날 컨테이너 객체 생성
			Parent parent = null;
			
			try {
				parent = FXMLLoader.load(getClass().getResource("myDialog.fxml"));
				
				//만약 컨트롤러가 이미 있는 애를 가져오려면...
				
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("~.fxml"));
//				loader.getController(); //이러면 이 객체의 컨트롤러를 가져올 수 있다.
				//그리구 컨트롤러 안의 메소드를 불러오라
				
				
			}catch(IOException ex) {ex.printStackTrace();}
			
			
			//부모창에서 FXML로 만든 자식창의 컨트롤객체 얻기
			TextField txtName = (TextField) parent.lookup("#txtName");
			PasswordField pass = (PasswordField) parent.lookup("#pass");
			
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(e2->{
				System.out.println("이름 : "+txtName.getText());
				System.out.println("비밀번호 : "+pass.getText());
			});
			
			Button btnCancel = (Button) parent.lookup("#btnCancel");
			btnCancel.setOnAction(e3->{
				dialog.close();
			});
			
			// 5. Scene 객체 생성해서 컨테이너 객체 추가 
			Scene scene = new Scene(parent);
			
			// 6. Stage객체에 Scene추가
			dialog.setScene(scene);
			dialog.setResizable(false); //크기고정
			dialog.show();
		});
		
		root.getChildren().addAll(btnFileOpen, btnFileSave, btnDirectory, btnPopup, btnCustom);
		
		Scene scene = new Scene(root, 800, 100);
		primaryStage.setTitle("Dialogu창 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
