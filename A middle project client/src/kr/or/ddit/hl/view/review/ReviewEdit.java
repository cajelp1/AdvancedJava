package kr.or.ddit.hl.view.review;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import kr.or.ddit.hl.service.review.IReviewService;
import kr.or.ddit.hl.vo.ReviewVO;

public class ReviewEdit {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;

    @FXML    private TextField title;
    @FXML    private TextArea contents;
    
    @FXML    private ComboBox<String> score;
    @FXML    private Button fileAdd;
    @FXML    private Button btnCancel;
    @FXML    private Button btnAdd;
    
    //private String nickname;
    
    private Registry reg;
    private IReviewService service;
    
    private ReviewVO vo;
    
    private ReviewShow rs;
    private ReviewController rc;
    
    @FXML
    void initialize(ReviewVO rv) {
    	
    	vo = rv;
    	
    	score.getItems().addAll("★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★");
    	
    	//내용과 제목 및 콤보박스 설정
    	title.setText(rv.getReview_title());
    	contents.setText(rv.getReview_content());
    	score.setValue(rv.getReview_grade_st());
    	
    	try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (IReviewService) reg.lookup("Review");
			
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
    	
    	if(title.getText().trim().isEmpty()) {
    		errMsg("오류","제목을 입력하세요");
    	}else if(contents.getText().trim().isEmpty()) {
    		errMsg("오류","내용을 입력하세요");
    	}else {
    		
    		if(score.getValue().equals("★☆☆☆☆")) {
        		vo.setReview_grade(1);
        		
        	}else if(score.getValue().equals("★★☆☆☆")) {
        		vo.setReview_grade(2);
        		
        	}else if(score.getValue().equals("★★★☆☆")) {
        		vo.setReview_grade(3);
        		
        	}else if(score.getValue().equals("★★★★☆")) {
        		vo.setReview_grade(4);
        		
        	}else if(score.getValue().equals("★★★★★")) {
        		vo.setReview_grade(5);
        	}
    		
    		vo.setReview_title(title.getText());
    		vo.setReview_content(contents.getText());
    		
    		try {
				boolean a = service.updateReview(vo);
				if(a) {
					infoMsg("성공","글 수정이 완료되었습니다");
					
					if(rs != null)rs.disable();
					
					Stage stage = (Stage)btnCancel.getScene().getWindow();
			    	stage.close();
				}else {
					errMsg("오류", "글 수정에 실패했습니다");
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
    
	public ReviewShow getRs() {
		return rs;
	}
	public void setRs(ReviewShow rs) {
		this.rs = rs;
	}
	public ReviewController getRc() {
		return rc;
	}
	public void setRc(ReviewController rc) {
		this.rc = rc;
	}
    
}
