package kr.or.ddit.board.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class BoardCont {

    @FXML private ResourceBundle resources;
    
    @FXML private URL location;
    
    @FXML private Button btnCancel;
    @FXML private Button btnClose;
    @FXML private Button btnOk;
    @FXML private Button btnDelete;
    @FXML private Button btnEdit;
    
    @FXML private TextField board_title;
    @FXML private TextField board_writer;
    @FXML private TextArea board_content;
    
    BoardServiceImpl service = BoardServiceImpl.getInstance();
    BoardVO bv;
    int flag;
    
    //메인컨트롤러를 새로고침하기 위해 일단 객체를 저장할 변수 선언, getter와 setter 생성
    MainCont main;
    public MainCont getMain() {
		return main;
	}
	public void setMain(MainCont main) {
		this.main = main;
	}
	
	
	@FXML
    void initialize() {
        
    	btnDelete.setDisable(true);
    	btnEdit.setDisable(true);
    	
    	flag = 1;
    }
    
    void initialize(BoardVO board) {
    	
    	bv = board;
    	
    	board_title.setText(board.getBoard_title());
    	board_writer.setText(board.getBoard_writer());
    	board_content.setText(board.getBoard_content());
    	
    	btnDelete.setDisable(false);
    	btnEdit.setDisable(false);
    	btnOk.setDisable(true);
    	btnCancel.setDisable(true);
    	
    	board_title.setEditable(false);;
    	board_writer.setEditable(false);
    	board_content.setEditable(false);
    	
    	flag = 0;
    }
    
    
    @FXML void editBoard(ActionEvent event) {
    	

		board_title.setEditable(true);;
    	board_writer.setEditable(true);
    	board_content.setEditable(true);

    	btnDelete.setDisable(true);
    	btnEdit.setDisable(true);
    	btnOk.setDisable(false);
    	btnCancel.setDisable(false);
		
    	flag = 2;
    }

    @FXML
    void deleteBoard(ActionEvent event) {
    	
    	boolean ans = confMsg("정말로 글을 삭제하시겠습니까?","삭제된 글은 복원할 수 없습니다");
    	
    	if(ans) {
    		int result = service.deletBoard(bv.getBoard_no());
    		if(result > 0) {
    			infoMsg("게시글이 삭제되었습니다","알림");
    			main.setData();
		    	close(null);
		    	
    		}else {
    			errMsg("게시글 삭제에 실패했습니다!","오류");
    		}
    	}
    }

    @FXML
    void ok(ActionEvent event) {
    	
    	//글작성 후 확인을 누를 경우
    	if(flag == 1) {
    		BoardVO bv2 = new BoardVO();
    		
    		if(board_title.getText().trim().isEmpty()) {
    			errMsg("제목을 입력하세요","오류입니다"); return;
    		}else if(board_writer.getText().trim().isEmpty()) {
    			errMsg("작성자 이름을 입력하세요","오류입니다"); return;
    		}else if(board_content.getText().trim().isEmpty()) {
    			errMsg("내용을 입력하세요","오류입니다"); return;
    		}else {
    			bv2.setBoard_title(board_title.getText());
    			bv2.setBoard_writer(board_writer.getText());
    			bv2.setBoard_content(board_content.getText());
    			
    			int result = service.insertBoard(bv2);
    			if(result == 0) {
    				infoMsg("게시글이 등록되었습니다", "성공");
    				main.setData();
    		    	close(null);
    		    	
    			}else {
    				errMsg("게시글 등록에 실패했습니다", "오류");
    			}
    		}
    	}
    	
    	//글수정 후 확인을 누를 경우
    	if(flag == 2) {
    		
    		if(board_title.getText().trim().isEmpty()) {
    			errMsg("제목을 입력하세요","오류입니다"); return;
    		}else if(board_writer.getText().trim().isEmpty()) {
    			errMsg("작성자 이름을 입력하세요","오류입니다"); return;
    		}else if(board_content.getText().trim().isEmpty()) {
    			errMsg("내용을 입력하세요","오류입니다"); return;
    		}else {
    			bv.setBoard_title(board_title.getText());
    			bv.setBoard_writer(board_writer.getText());
    			bv.setBoard_content(board_content.getText());
    			
    			int result = service.updateBoard(bv);
    			if(result > 0) {
    				infoMsg("게시글이 수정되었습니다", "성공");
    		    	main.setData();
    		    	close(null);
    		    	
    			}else {
    				errMsg("게시글 수정에 실패했습니다", "오류");
    			}
    		}
    	}
    }

    @FXML
    void cancel(ActionEvent event) {
    	
    	btnDelete.setDisable(false);
    	btnEdit.setDisable(false);
    	
    	btnOk.setDisable(true);
    	btnCancel.setDisable(true);
    	
    	
    }

    @FXML
    void close(ActionEvent event) {
    	
    	Stage stage = (Stage)btnClose.getScene().getWindow();
    	stage.close();
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
