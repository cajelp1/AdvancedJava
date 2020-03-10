package kr.or.ddit.hl.view.join;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import kr.or.ddit.hl.service.join.IJoinService;
import kr.or.ddit.hl.vo.MemberVO;

public class JoinController {

    @FXML    private ResourceBundle resources;

    @FXML    private URL location;

    @FXML    private TextField mem_capcha;
    @FXML    private TextField mem_nickname;
    @FXML    private TextField mem_id;
    @FXML    private TextField mem_email;
    @FXML    private TextField mem_zipcode;
    @FXML    private TextField mem_jumin2;
    @FXML    private TextField mem_hp;
    @FXML    private TextField mem_addr2;
    @FXML    private TextField mem_addr1;
    @FXML    private TextField mem_name;
    @FXML    private TextField mem_password;
    @FXML    private TextField mem_jumin;
    @FXML    private TextField mem_pwd2;

    @FXML    private Button btnIdCheck;
    @FXML    private Button btnOk;
    @FXML    private Button btnCancel;
    @FXML    private Button btnNickCheck;
    @FXML    private Button btnSearchZip;
    

    private static IJoinService service;
    
    boolean idDuple = true;		//아이디가 중복임
    boolean nickDuple = true;	//닉네임이 중복임
    
    
    @FXML
    void idCheck(ActionEvent event) throws RemoteException {
    	
    	if(mem_id.getText().trim().length() > 0) {
    		boolean result = service.selectId(mem_id.getText());
    		if(result) {
    			infoMsg("완료","사용할 수 있는 아이디입니다");
    			idDuple = false;
    		}else {
    			errMsg("오류","아이디 중복");
    		}
    		
    	}else {
    		errMsg("아이디 값 오류","아이디를 입력하세요");
    	}
    	
    	
    }

    @FXML
    void nickCheck(ActionEvent event) throws RemoteException {
    	
    	if(mem_nickname.getText().trim().length() > 0) {
    		boolean result = service.selectNick(mem_nickname.getText());
    		if(result) {
    			infoMsg("완료","사용할 수 있는 닉네임입니다");
    			nickDuple = false;
    		}else {
    			errMsg("오류","닉네임 중복");
    		}
    		
    	}else {
    		errMsg("닉네임 값 오류","닉네임을 입력하세요");
    	}
    	
    }

    @FXML
    void searchZip(ActionEvent event) throws RemoteException {
    	
    }

    @FXML
    void cancel(ActionEvent event) throws RemoteException {
    	
    	
    	
    }

    @FXML
    void ok(ActionEvent event) throws RemoteException {
    	
    	if(mem_nickname.getText().trim().length() <=0 || 
    		mem_id.getText().trim().length() <=0 || 
    		mem_email.getText().trim().length() <=0 || 
    		mem_zipcode.getText().trim().length() <=0 || 
    		mem_jumin2.getText().trim().length() <=0 || 
    		mem_hp.getText().trim().length() <=0 || 
    		mem_addr2.getText().trim().length() <=0 || 
    		mem_addr1.getText().trim().length() <=0 || 
    		mem_name.getText().trim().length() <=0 || 
    		mem_password.getText().trim().length() <=0 || 
    		mem_jumin.getText().trim().length() <=0 || 
    		mem_pwd2.getText().trim().length() <=0){
    			errMsg("오류", "빈 칸이 존재합니다");
    			
    	}else if(idDuple || nickDuple) {
    		errMsg("오류","중복체크를 완료해주세요");
    		
    	}else if(!mem_pwd2.getText().endsWith(mem_password.getText())){
    		errMsg("오류","패스워드 확인이 일치하지 않습니다");
    	}else {
    		
    		MemberVO vo = new MemberVO();
    		
    		vo.setMem_id(mem_id.getText());
    		vo.setMem_name(mem_name.getText());
    		vo.setMem_password(mem_password.getText());
    		vo.setMem_jumin_no(mem_jumin.getText()+mem_jumin2.getText());
    		vo.setMem_hp(mem_hp.getText());
    		vo.setMem_email(mem_email.getText());
    		vo.setMem_nickname(mem_nickname.getText());
    		vo.setMem_zipcode(mem_zipcode.getText());
    		
    		boolean result = service.insertMember(vo);
    		if(result) infoMsg("완료","회원가입이 완료되었습니다");
    		else { errMsg("오류", "회원가입을 실패했습니다"); }
    		
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
    
    @FXML
    void initialize() {
    	try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			Registry reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (IJoinService) reg.lookup("JoinServer");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    }
}
