package kr.or.ddit.hl.view.qna;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import kr.or.ddit.hl.service.qna.IQnaService;
import kr.or.ddit.hl.vo.QnaBoardVO;

public class QnaShow {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    
    @FXML    private Button btnBack;
    @FXML    private Button btnEdit;
    @FXML    private Button btnDelete;
    
    @FXML    private TextField title;
    @FXML    private TextField writer;
    @FXML    private TextArea contents;
    @FXML    private TextField date;
    
    private Registry reg;
    private IQnaService service;
    private String id;
    
    private Stage stage;
    private QnaController qc;
    private QnaShow qs;
    private QnaEdit qEdit;
    private QnaBoardVO vo;

	@FXML
    void initialize(QnaBoardVO qv) {
    	
		//세션에서 값 가져오기
		id = "asdf";
		
		vo = qv;
		qs = this;
		
		//본인글이 아닐경우 수정 및 삭제 비활성화
		if(!id.equals(qv.getQna_writer_id())) {
			btnEdit.setDisable(true);
			btnDelete.setDisable(true);
		}
		
    	title.setText(qv.getQna_title());
    	writer.setText(qv.getQna_writer());
    	contents.setText(qv.getQna_content());
    	date.setText(qv.getQna_date());
    	
    	try {
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
    void toList(ActionEvent event) {
    	//Stage as = (Stage)btnBack.getScene().getWindow();
    	
    	Parent parent = null;
    	
    	try {
			FXMLLoader fx = new FXMLLoader(getClass().getResource("qna_main.fxml"));
			parent = fx.load();
			QnaController qn = fx.getController();
			
			qn.setStage(stage);
			
    		//parent = FXMLLoader.load(getClass().getResource("qna_main.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	Scene scene = new Scene(parent);
    	stage.setTitle("Qna메인");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    @FXML
    void edit(ActionEvent event) {
    	
    	Stage st = new Stage();
    	Parent parent = null;
    	try {
			//parent = FXMLLoader.load(getClass().getResource("qna_write.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("qna_edit.fxml"));
			parent = loader.load();
			qEdit = loader.getController();
			qEdit.initialize(vo);
			qEdit.setQnaShow(qs);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Scene sc = new Scene(parent);
    	st.setScene(sc);
    	st.show();
    	
    }
    
    void disable() {
    	btnEdit.setDisable(true);
    }
    
    
    @FXML
    void delete(ActionEvent event) {
    	
    	boolean ans = confMsg("알림","정말로 글을 삭제하시겠습니까?");
    	
    	if(ans) {
    		
    		boolean ans2 = false;
    		try {
				ans2 = service.deleteQna(vo.getNo());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		if(ans2) {
    			infoMsg("완료","글이 삭제되었습니다");
    			
    			//메인 화면으로 넘어감
    			Parent parent = null;
    	    	
    	    	try {
    				FXMLLoader fx = new FXMLLoader(getClass().getResource("qna_main.fxml"));
    				parent = fx.load();
    				QnaController qn = fx.getController();
    				qn.setStage(stage);
    				
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    	    	
    	    	Scene scene = new Scene(parent);
    	    	stage.setTitle("QnA");
    	    	stage.setScene(scene);
    	    	stage.show();
    			
    		}else {
    			errMsg("오류","글 삭제에 실패했습니다");
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
		infoAlert.setTitle("확인");
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
    
    
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public QnaShow getQs() {
		return qs;
	}
	public void setQs(QnaShow qs) {
		this.qs = qs;
	}
	public QnaController getQc() {
		return qc;
	}
	public void setQc(QnaController qc) {
		this.qc = qc;
	}
    
	
}
