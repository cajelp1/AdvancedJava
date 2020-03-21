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
import javafx.stage.Stage;
import kr.or.ddit.hl.service.cust.ICustService;
import kr.or.ddit.hl.vo.CustomerCenterVO;

public class CustShow {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;

    @FXML    private Button fileAdd;
    @FXML    private Button btnBack;
    @FXML    private Button btnEdit;
    @FXML    private Button btnDelete;
    
    @FXML    private TextField title;
    @FXML    private TextField writer;
    @FXML    private TextArea contents;
    @FXML    private TextField date;
    
    private Stage stage;
    private CustShow cs;
    private CustEdit ce;
    private CustController cc;
    private CustomerCenterVO vo;
    
    private Registry reg;
    private ICustService service;
    private String id;
    
    @FXML
    void initialize(CustomerCenterVO ccv) {
    	
    	//세션에서 값 가져오기
    	id = "asdf";
    	
    	vo = ccv;
    	cs = this;
    	
    	//으애ㅐ애ㅐㅇ 컬럼추가ㅏㅏㅏㅏㅏ
//    	if(!id.equals(ccv.getCust_writer_id())) {
//			btnEdit.setDisable(true);
//			btnDelete.setDisable(true);
//		}
		
    	title.setText(ccv.getCust_title());
    	writer.setText(ccv.getCust_writer());
    	contents.setText(ccv.getCust_content());
    	date.setText(ccv.getCust_date());
    	
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
    void toList(ActionEvent event) {
    	
    }

    @FXML
    void edit(ActionEvent event) {
    	
    }

    @FXML
    void delete(ActionEvent event) {
    	
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

	public CustShow getCs() {
		return cs;
	}
	public void setCs(CustShow cs) {
		this.cs = cs;
	}
	public CustEdit getCe() {
		return ce;
	}
	public void setCe(CustEdit ce) {
		this.ce = ce;
	}
	public CustController getCc() {
		return cc;
	}
	public void setCc(CustController cc) {
		this.cc = cc;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
    
    
}

