package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.basic.H04_MemberVO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class H04_Controller implements Initializable{
	
	@FXML TextField id;
	@FXML TextField name;
	@FXML TextField tel;
	@FXML TextField addr;

	@FXML TableView<H04_MemberVO> tableview;
	
	//컬럼에 각각 들어갈 제네릭 타입을 함께 정의해준다
	@FXML TableColumn<H04_MemberVO, String> colId;
	@FXML TableColumn<H04_MemberVO, String> colName;
	@FXML TableColumn<H04_MemberVO, String> colTel;
	@FXML TableColumn<H04_MemberVO, String> colAddr;
	
	@FXML Button btnAdd;
	@FXML Button btnEdit;
	@FXML Button btnDel;
	@FXML Button btnOk;
	@FXML Button btnNo;
	
	//확인 버튼을 눌렀을 때 실행할 메소드를 구별하기 위한 전역변수
	private int check;
	
	//테이블에 보여줄 데이터 리스트
	ObservableList<H04_MemberVO> data = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//테스트용 데이터
		data.add(new H04_MemberVO("1","이예림","010-0000-0000","대전"));
		
		//테이블에 리스트 세팅
		tableview.setItems(data);
		
		//컬럼 정보 매칭
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
		colAddr.setCellValueFactory(new PropertyValueFactory<>("addr"));
		
		//버튼 두개 disable
		btnOk.setDisable(true);
		btnNo.setDisable(true);
		
		//텍스트필드 비활성화
		id.setEditable(false);
		name.setEditable(false);
		tel.setEditable(false);
		addr.setEditable(false);
		
		//테이블의 값 선택시 텍스트 필드에 값이 나타나게 하는 메소드
		tableview.setOnMouseClicked(e->{
			//tabelView에서 선택한 줄의 데이터를 가져온다
			H04_MemberVO mem = tableview.getSelectionModel().getSelectedItem();
			
			id.setText(mem.getId());
			name.setText(mem.getName());
			tel.setText(mem.getTel());
			addr.setText(mem.getAddr());
		});
	}

	//추가
	@FXML public void btnAddClick(ActionEvent event) {
		
		//텍스트 필드에 값이 있을 때 자동으로 삭제
		id.clear();
		name.clear();
		tel.clear();
		addr.clear();
		
		//버튼 세개 비활성화
		btnAdd.setDisable(true);
		btnDel.setDisable(true);
		btnEdit.setDisable(true);
		
		//버튼 두개 활성화
		btnOk.setDisable(false);
		btnNo.setDisable(false);
		
		//텍스트필드 모두 활성화
		id.setEditable(true);
		name.setEditable(true);
		tel.setEditable(true);
		addr.setEditable(true);
		
		//전역변수 값을 1로 바꾼다
		check = 1;
	}

	//수정
	@FXML public void btnEditClick(ActionEvent event) {
		
		if(tableview.getSelectionModel().isEmpty()){
			errMsg("작업오류","수정할 자료를 선택한 후 수정하세요");
			return;
		}
		
		//버튼 세개 비활성화
		btnAdd.setDisable(true);
		btnDel.setDisable(true);
		btnEdit.setDisable(true);
		
		//버튼 두개 활성화
		btnOk.setDisable(false);
		btnNo.setDisable(false);
		
		//텍스트필드 모두 활성화
		id.setEditable(true);
		name.setEditable(true);
		tel.setEditable(true);
		addr.setEditable(true);
		
		//전역변수 값을 2로 바꾼다
		check = 2;
	}

	//삭제
	@FXML public void btnDelClick(ActionEvent event) {
		
		//버튼 세개 비활성화
		btnAdd.setDisable(true);
		btnDel.setDisable(true);
		btnEdit.setDisable(true);
		
		//버튼 두개 활성화
		btnOk.setDisable(false);
		btnNo.setDisable(false);
		
		//전역변수 값을 3으로 바꾼다
		check = 3;
	}

	//확인
	@FXML public void btnOkClick(ActionEvent event) {
		//전역변수가 1일때, 텍스트 필드에 있는 값 테이블에 추가
		if(check == 1) {
			
			if(id.getText().isEmpty() || name.getText().isEmpty() || tel.getText().isEmpty() || addr.getText().isEmpty()) {
				
				errMsg("작업오류", "빈 항목이 있습니다");
				return;
			}
			
			data.add(new H04_MemberVO(id.getText(), name.getText(), tel.getText(), addr.getText()));
			infoMsg("작업 결과", "정보 추가가 완료되었습니다");
		}
		
		//전역변수가 2일때, 텍스트 필드에 있는 값의 인덱스 찾아서 데이터 수정
		if(check == 2) {
			
			if(id.getText().isEmpty() || name.getText().isEmpty() || tel.getText().isEmpty() || addr.getText().isEmpty()) {
				
				errMsg("작업오류", "빈 항목이 있습니다");
				return;
			}
			
			data.set(tableview.getSelectionModel().getSelectedIndex(), 
					new H04_MemberVO(id.getText(), name.getText(), tel.getText(), addr.getText()));
			infoMsg("작업 결과", "정보 수정이 완료되었습니다");
		}
		
		//전역변수가 3일때, 텍스트 필드에 있는 값의 인덱스 찾아서 데이터 삭제
		if(check == 3) {
			
			if(tableview.getSelectionModel().isEmpty()){
				errMsg("작업오류","삭제할 자료를 선택한 후 삭제하세요");
				return;
			}
			data.remove(tableview.getSelectionModel().getSelectedIndex());
			
			infoMsg("작업 결과", name.getText()+"님 정보가 삭제되었습니다");
		}
		
		//텍스트필드 비활성화 및 기타 버튼 설정
		btnOk.setDisable(true);
		btnNo.setDisable(true);
		btnAdd.setDisable(false);
		btnDel.setDisable(false);
		btnEdit.setDisable(false);
		
		id.setEditable(false);
		name.setEditable(false);
		tel.setEditable(false);
		addr.setEditable(false);
				
		//마지막으로 전역변수 초기화
		check = 0;
	}

	//취소
	@FXML public void btnNoClick(ActionEvent event) {
		
		//텍스트 필드에 있는 값 모두 삭제
		id.clear();
		name.clear();
		tel.clear();
		addr.clear();
		
		//버튼 세개 활성화
		btnAdd.setDisable(false);
		btnDel.setDisable(false);
		btnEdit.setDisable(false);
		
		//버튼 두개 비활성화
		btnOk.setDisable(true);
		btnNo.setDisable(true);
		
		//텍스트 필드 비활성화
		id.setEditable(false);
		name.setEditable(false);
		tel.setEditable(false);
		addr.setEditable(false);
		
		//전역변수 초기화
		check = 0;
	}
	
	//오류 알림 메소드
	public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}
	
	//정보 알림 메소드
	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("알림");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}
}
