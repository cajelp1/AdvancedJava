package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class H01_Controller implements Initializable{

	@FXML private RadioButton male;
	@FXML private RadioButton female;
	@FXML private Button btn;
	@FXML private TextField textfield;
	@FXML private TextArea textarea;
	@FXML private CheckBox ck1;
	@FXML private CheckBox ck2;
	@FXML private CheckBox ck3;
	@FXML private CheckBox ck4;
	@FXML private CheckBox ck5;
	@FXML private CheckBox ck6;
	@FXML private CheckBox ck7;
	@FXML private CheckBox ck8;
	
	//체크박스 배열화
	private CheckBox[] chkbox;

	//성별선택 토글 생성
	private ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//체크박스 배열에 객체추가
		chkbox = new CheckBox[]{ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8};
		
		//토글 설정 및 정리
		male.setToggleGroup(group);
		male.setUserData("남자");
		male.setSelected(true);
		female.setToggleGroup(group);
		female.setUserData("여자");
	}

	
	//보기 버튼을 눌렀을 때의 액션
	@FXML public void btnClicked(ActionEvent event) {
		
		String hobby = "";
		boolean chk = false;
		
		for(int i = 0; i < chkbox.length; i++) {
			if(chkbox[i].isSelected()) { 
				hobby += chkbox[i].getText() + " ";
				chk = true;
			}
		}
		hobby +="입니다.";
		if(!chk) { hobby = "없습니다."; }
		
		textarea.setText("제 이름은 "+textfield.getText()+"입니다.\n");
		textarea.appendText("성별은 "+group.getSelectedToggle().getUserData()+"이고,\n"); //getUserDate는 오브젝트로 가져온다고?
		textarea.appendText("취미는 "+hobby);
		
	}
	
}
