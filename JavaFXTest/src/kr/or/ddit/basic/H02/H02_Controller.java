package kr.or.ddit.basic.H02;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class H02_Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private TableView<H02_ZipVO> tableView;
    @FXML private TableColumn<H02_ZipVO, String> zipcode;
    @FXML private TableColumn<H02_ZipVO, String> gugun;
    @FXML private TableColumn<H02_ZipVO, String> bunji;
    @FXML private TableColumn<H02_ZipVO, String> sido;
    @FXML private TableColumn<H02_ZipVO, String> dong;
    @FXML private ComboBox<String> combo;
    @FXML private TextField txtField;
    @FXML private Button btn;
    
    H02_Service service = H02_ServiceImpl.getInstance();
    
    @FXML
    void initialize() {
        //콤보버튼 세팅
    	combo.getItems().addAll("동 이름", "우편번호");
    	combo.setValue("동 이름");
    }

    @FXML
    void btnClicked(ActionEvent event) {
    	String txt = txtField.getText();
    	String action = combo.getValue();
    	List<H02_ZipVO> list = new ArrayList<>();
    	
    	if(txt != null && !txt.equals("") && action == "동 이름") {
    		list = service.searchDong(txt);
    	}
    	else if(txt != null && !txt.equals("") && action == "우편번호") {
    		list = service.searchZipcode(txt);
    	}
    	
    	//테이블 세팅
    	tableView.setItems(FXCollections.observableArrayList(list));
    	zipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
    	sido.setCellValueFactory(new PropertyValueFactory<>("sido"));
    	gugun.setCellValueFactory(new PropertyValueFactory<>("gugun"));
    	dong.setCellValueFactory(new PropertyValueFactory<>("dong"));
    	bunji.setCellValueFactory(new PropertyValueFactory<>("bunji"));
    	
    }

}
