package kr.or.ddit.hl.view.review;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.hl.service.review.IReviewService;
import kr.or.ddit.hl.vo.ReportVO;
import kr.or.ddit.hl.vo.ReviewVO;
import kr.or.ddit.hl.vo.SessionVO;

public class ReviewShow {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    
    @FXML    private Button btnReport;
    @FXML    private Button btnBack;
    @FXML    private Button btnEdit;
    @FXML    private Button btnDelete;
    
    @FXML    private Label score;
    @FXML    private Label title;
    @FXML    private Label writer;
    @FXML    private TextArea contents;
    @FXML    private Label date;
    
    private Registry reg;
    private IReviewService service;
    private boolean isLogin;
    private String id;
    
    private Stage stage;
    private ReviewController rc;
    private ReviewShow rs;
    private ReviewEdit rEdit;
    private ReviewVO vo;

	@FXML
    void initialize(ReviewVO rv) {
    	
		//세션에서 값 가져오기
		id = SessionVO.id;
		isLogin = SessionVO.isLogin;
		
		
		
		vo = rv;
		rs = this;
		
		//본인글이 아닐경우 수정 및 삭제 비활성화
		if(!isLogin || !id.equals(rv.getReview_writer_id())) {
			btnEdit.setDisable(true);
			btnDelete.setDisable(true);
		}
		//로그인을 안 했거나 본인글일 경우 신고 비활성화
		if(!isLogin || id.equals(rv.getReview_writer_id())) {
			btnReport.setDisable(true);
		}
		
    	title.setText(rv.getReview_title());
    	writer.setText(rv.getReview_writer());
    	contents.setText(rv.getReview_content());
    	date.setText(rv.getReview_date());
    	
    	String val = "";
    	if(rv.getReview_grade() == 1)val = "평점 : ★☆☆☆☆";
    	if(rv.getReview_grade() == 2)val = "평점 : ★★☆☆☆";
    	if(rv.getReview_grade() == 3)val = "평점 : ★★★☆☆";
    	if(rv.getReview_grade() == 4)val = "평점 : ★★★★☆";
    	if(rv.getReview_grade() == 5)val = "평점 : ★★★★★";
    	score.setText(val);
    	
    	try {
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (IReviewService) reg.lookup("Review");
			
		}catch(RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	//신고버튼 액션
	@FXML
	void report(ActionEvent event) {
    	
		// 1. state객체 사용
    	Stage reportReview = new Stage();
    	reportReview.setTitle("리뷰 신고");
    	
    	// 2. 모딜창 여부 설정
    	//모딜창은 자식창이 나타나면 부모창을 사용할 수 없다.
    	//reportReview.initModality(Modality.APPLICATION_MODAL);
    	// 3. 부모창 지정
    	//reportReview.initOwner(stage); 
    	
    	// 4. 자식창이 나타날 컨테이너 객체 생성
    	Parent parent = null;
    	
    	try {
    		parent = FXMLLoader.load(getClass().getResource("review_report.fxml"));
    	}catch(IOException ex) {ex.printStackTrace();}
    	
    	
    	//부모창에서 FXML로 만든 자식창의 컨트롤객체 얻기
    	TextArea txtReason = (TextArea) parent.lookup("#reason");
    	Button btnOk = (Button) parent.lookup("#btnOk");
    	Button btnCancel = (Button) parent.lookup("#btnCancel");
    	
    	// 5. Scene 객체 생성해서 컨테이너 객체 추가 
    	Scene scene = new Scene(parent);
    	
    	// 6. Stage객체에 Scene추가
    	reportReview.setScene(scene);
    	reportReview.setResizable(false); //크기고정
    	reportReview.show();
    	
    	//버튼 액션
    	btnOk.setOnAction(btnInsertReport -> {
    		ReportVO rvo = new ReportVO();
    		
    		String txt = txtReason.getText();
    		if(txt.length() > 200) {errMsg("오류","200자 이내로 내용을 입력하세요");}
    		else {
    			
    			rvo.setReview_no(vo.getReview_no());
    			rvo.setReport_id(vo.getReview_writer_id());
    			rvo.setReport_reason(txt);
    			
    			boolean res = false;
    			try {
					res = service.insertReport(rvo);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			if(res) {
    				infoMsg("성공", "신고가 성공적으로 접수되었습니다");
    				reportReview.close();
    			}else {
    				errMsg("실패", "신고 접수에 실패했습니다");
    			}
    			
    		}
    	});
    	btnCancel.setOnAction(btnCancelScore -> {
    		reportReview.close();
    	});
    }
	
	//메뉴로 돌아가기
    @FXML
    void toList(ActionEvent event) {
    	//Stage as = (Stage)btnBack.getScene().getWindow();
    	
    	Parent parent = null;
    	
    	try {
			FXMLLoader fx = new FXMLLoader(getClass().getResource("review_main.fxml"));
			parent = fx.load();
			ReviewController rc = fx.getController();
			
			rc.setStage(stage);
			
    		//parent = FXMLLoader.load(getClass().getResource("qna_main.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Scene scene = new Scene(parent);
    	stage.setTitle("Review");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    //수정버튼 액션
    @FXML
    void edit(ActionEvent event) {
    	
    	Stage st = new Stage();
    	Parent parent = null;
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("review_edit.fxml"));
			parent = loader.load();
			rEdit = loader.getController();
			rEdit.initialize(vo);
			rEdit.setRs(rs);
			
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
    
    
    //삭제버튼 액션
    @FXML
    void delete(ActionEvent event) {
    	
    	boolean ans = confMsg("알림","정말로 글을 삭제하시겠습니까?");
    	
    	if(ans) {
    		
    		boolean ans2 = false;
    		try {
				ans2 = service.deleteReview(vo.getReview_no());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		if(ans2) {
    			infoMsg("완료","글이 삭제되었습니다");
    			
    			//메인 화면으로 넘어감
    			Parent parent = null;
    	    	
    	    	try {
    				FXMLLoader fx = new FXMLLoader(getClass().getResource("review_main.fxml"));
    				parent = fx.load();
    				ReviewController rc = fx.getController();
    				rc.setStage(stage);
    				
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    	    	
    	    	Scene scene = new Scene(parent);
    	    	stage.setTitle("Review");
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
