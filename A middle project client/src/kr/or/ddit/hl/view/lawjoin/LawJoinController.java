package kr.or.ddit.hl.view.lawjoin;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import kr.or.ddit.hl.service.join.ILawJoinService;
import kr.or.ddit.hl.vo.LawfirmVO;
import kr.or.ddit.hl.vo.LawyerVO;

public class LawJoinController {

    @FXML    private ResourceBundle resources;

    @FXML    private URL location;

    @FXML    private TextField lawfirm_code;
    @FXML    private TextField law_id;
    @FXML    private TextField law_jumin2;
    @FXML    private TextField law_email;
    @FXML    private TextField law_jumin1;
    @FXML    private TextField law_password2;
    @FXML    private TextField capcha;
    @FXML    private TextField law_name;
    @FXML    private TextField law_nickname;
    @FXML    private PasswordField law_password;
    @FXML    private TextField law_zipcode;
    @FXML    private TextField lawfirm_name;
    @FXML    private TextField law_addr1;
    @FXML    private TextField law_addr2;
    @FXML    private TextField law_hp;

    @FXML    private Button btnZipSearch;
    @FXML    private Button btnIdCheck;
    @FXML    private Button btnNickCheck;
    @FXML    private Button btnCancel;
    @FXML    private Button btnOk;
    @FXML    private Button btnLawfirmCheck;
    
    private static ILawJoinService service;
    
    boolean idDuple = true;			//아이디가 존재함 (중복)
    boolean nickDuple = true;		//닉네임이 존재함 (중복)
    boolean lawfirmExist = false; 	//로펌이 없음
    
    @FXML
    void cancel(ActionEvent event) {
    	
    }

    @FXML
    void ok(ActionEvent event) throws RemoteException {
    	
    	if(law_id.getText().trim().length() <= 0 ||
    			law_password.getText().trim().length() <= 0 ||
    			law_name.getText().trim().length() <= 0 ||
    			law_nickname.getText().trim().length() <= 0 ||
    			law_jumin1.getText().trim().length() <= 0 ||
    			law_jumin2.getText().trim().length() <= 0 ||
    			law_email.getText().trim().length() <= 0 ||
    			law_hp.getText().trim().length() <= 0 ||
    			lawfirm_name.getText().trim().length() <= 0 ||
    			law_addr1.getText().trim().length() <= 0 ||
    			law_addr2.getText().trim().length() <= 0 ||
    			law_zipcode.getText().trim().length() <= 0) {
        		errMsg("오류", "빈 칸이 존재합니다");
        		
        }else if(idDuple || nickDuple || !lawfirmExist) {
        	errMsg("오류","중복 및 로펌체크를 완료해주세요");
        	
        }else if(!law_password2.getText().endsWith(law_password.getText())){
        	errMsg("오류","패스워드 확인이 일치하지 않습니다");
        }else {
        	
        	LawyerVO vo = new LawyerVO();
        	
        	vo.setLaw_id(law_id.getText());
        	vo.setLaw_password(law_password.getText());
        	vo.setLaw_name(law_name.getText());
        	vo.setLaw_nickname(law_nickname.getText());
        	vo.setLaw_jumin_no(law_jumin1.getText()+law_jumin2.getText());
        	vo.setLaw_email(law_email.getText());
        	vo.setLaw_hp(law_hp.getText());
        	vo.setLaw_company_name(lawfirm_name.getText());
        	vo.setLaw_zipcode(law_zipcode.getText());
        	vo.setLaw_addr1(law_addr1.getText());
        	vo.setLaw_addr2(law_addr2.getText());
        	
        	boolean result = service.insertLawyer(vo);
        	if(result) infoMsg("완료","회원가입이 완료되었습니다");
        	else { errMsg("오류", "회원가입을 실패했습니다"); }
        	
        }
        
        
    	
    }

    @FXML
    void lawfirmCheck(ActionEvent event) throws RemoteException{
    	
    	if(lawfirm_name.getText().trim().length() > 0 &&
    			lawfirm_code.getText().trim().length() > 0) {
    		
    		LawfirmVO lfv = new LawfirmVO();
    		lfv.setLawfirm_name(lawfirm_name.getText());
    		lfv.setLawfirm_code(lawfirm_code.getText());
    		
    		boolean result = service.selectLawfirm(lfv);
    		if(result) {
    			infoMsg("완료","로펌 정보가 확인되었습니다");
    			lawfirmExist = true;
    		}else {
    			errMsg("오류","로펌 정보가 존재하지 않습니다");
    		}
    		
    	}else {
    		errMsg("로펌 값 오류","로펌 이름과 코드를 입력하세요");
    	}
    	
    }

    @FXML
    void idCheck(ActionEvent event) throws RemoteException{
    	
    	if(law_id.getText().trim().length() > 0) {
    		boolean result = service.selectId(law_id.getText());
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
    void nickCheck(ActionEvent event) throws RemoteException{
    	
    	if(law_nickname.getText().trim().length() > 0) {
    		boolean result = service.selectNick(law_nickname.getText());
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
			service = (ILawJoinService) reg.lookup("LawJoin");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
