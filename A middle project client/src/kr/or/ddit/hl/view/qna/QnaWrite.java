package kr.or.ddit.hl.view.qna;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import kr.or.ddit.hl.service.qna.IQnaService;
import kr.or.ddit.hl.vo.QnaBoardVO;

public class QnaWrite {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;

    @FXML    private TextField title;
    @FXML    private TextArea contents;

    @FXML    private CheckBox check;

    @FXML    private Button fileAdd;
    @FXML    private Button btnCancel;
    @FXML    private Button btnAdd;
    
    private String id;
    private String nickname;
    private Registry reg;
    private IQnaService service;
    
    private QnaController qnaCont;
    
    @FXML
    void initialize() {
    	
    	//세션이 없으므로 일단 임의의 값을 준다
    	id = "asdf";
    	nickname = "asdf";
    	
    	try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (IQnaService) reg.lookup("QnA");
			
		}catch(RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void initializee(QnaBoardVO vo) {
    	
    	//세션이 없으므로 일단 임의의 값을 준다
    	id = "asdf";
    	nickname = "asdf";
    	
    	try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (IQnaService) reg.lookup("QnA");
			
		}catch(RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void addFile(ActionEvent event) {
    	
    }

    @FXML
    void cancelArticle(ActionEvent event) {
    	Stage stage = (Stage)btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void writeArticle(ActionEvent event) {
    	QnaBoardVO qna = new QnaBoardVO();
    	String state = "n";
    	if(check.isSelected()) {
    		state = "y";
    	}
    	
    	if(title.getText().trim().isEmpty()) {
    		errMsg("오류","제목을 입력하세요");
    	}else if(contents.getText().trim().isEmpty()) {
    		errMsg("오류","내용을 입력하세요");
    	}else {
    		qna.setQna_writer(nickname);
    		qna.setQna_writer_id(id);
    		qna.setQna_title(title.getText());
    		qna.setQna_content(contents.getText());
    		qna.setQna_secret_yn(state);
    		qna.setQna_delete_yn("n");
    		
    		try {
				boolean a = service.insertQna(qna);
				if(a) {
					infoMsg("성공","새 글 작성이 완료되었습니다");
					
					qnaCont.tableSetting();
					qnaCont.paging();
					
					Stage stage = (Stage)btnCancel.getScene().getWindow();
			    	stage.close();
				}else {
					errMsg("오류", "글 작성에 실패했습니다");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
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
    
	public QnaController getQnaCont() {
		return qnaCont;
	}
	public void setQnaCont(QnaController qnaCont) {
		this.qnaCont = qnaCont;
	}
	
}
