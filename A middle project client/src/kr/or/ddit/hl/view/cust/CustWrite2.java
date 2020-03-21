package kr.or.ddit.hl.view.cust;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import kr.or.ddit.hl.service.cust.ICustService;

public class CustWrite2 {

    @FXML    private ResourceBundle resources;

    @FXML    private URL location;

    @FXML    private Button btnCancel;
    @FXML    private Button btnAdd;
    @FXML    private Button fileAdd;
   
    @FXML    private TextArea contents;
    @FXML    private TextField title;

    private Registry reg;
    private ICustService service;
    
    @FXML
    void initialize() {
        
    	try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (ICustService) reg.lookup("cust");
			
		}catch(RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void writeArticle(ActionEvent event) {
    	
    	
    	
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	
    	
    	
    }
    
    public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}
    
    public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("알림");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}
    
    public boolean confMsg(String headerText, String msg) {
    	Alert confAlert = new Alert(AlertType.CONFIRMATION);
    	confAlert.setTitle("확인");
    	confAlert.setHeaderText(headerText);
    	confAlert.setContentText(msg);
		
		// Alert창을 보여주고 사용자가 누른 버튼 값 읽어오기
		ButtonType confirmResult = confAlert.showAndWait().get();
		
		if(confirmResult == ButtonType.OK) {
			return true;
		}else {
			return false;
		}
    }
    
    
}
