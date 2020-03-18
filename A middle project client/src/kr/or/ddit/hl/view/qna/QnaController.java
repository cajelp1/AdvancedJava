package kr.or.ddit.hl.view.qna;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.hl.service.qna.IQnaService;
import kr.or.ddit.hl.vo.QnaBoardVO;

public class QnaController {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    
    @FXML    private TableView<QnaBoardVO> tableview;
    @FXML    private TableColumn<QnaBoardVO, String> writer;
    @FXML    private TableColumn<QnaBoardVO, String> title;
    @FXML    private TableColumn<QnaBoardVO, String> secret_yn;
    @FXML    private TableColumn<QnaBoardVO, String> date;
    @FXML    private TableColumn<QnaBoardVO, String> no;
    
    @FXML    private Button btnSearch;
    @FXML    private Button btnWrite;
    @FXML    private Pagination pagination;
    @FXML    private ComboBox<String> combo;
    @FXML    private TextField fieldSearch;
    
    private int role_code;
    private String id;
    
    private Stage stage;
    private QnaShow qnaShow;
    private QnaShow2 qnaShow2;
    private QnaWrite qnaWrite;
    private QnaController qnaCont;
    
    private Registry reg;
    private IQnaService service;
    
    private int from, to, itemsForPage;
	private ObservableList<QnaBoardVO> allTableData, currentPageData;
    
	
    @FXML
    void initialize() {
        
    	//세션에서 회원인지 변호사인지 값을 가져와야 하는데 지금은 세션이 없으니 로컬 변수로 저장
    	role_code = 1;
    	id = "asdfasdf";
    	
    	qnaCont = this;
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
    	
    	//콤보박스 세팅
    	combo.getItems().addAll("제목", "내용", "작성자");
    	combo.setValue("제목");
    	
    	//테이블 세팅
    	tableSetting();
    	paging();
    	
    	
    	//테이블에서 글 선택하면 창 바꿔서 보여주기
    	tableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
    	            if(mouseEvent.getClickCount() == 2){
    	                
    	            	//새로운 컨트롤러 및 창소환
    	            	//Stage boardCont = new Stage(StageStyle.UTILITY);
    	            	//boardCont.initModality(Modality.APPLICATION_MODAL);
    	            	
    	            	
    	            	//접근한 게시글의 비밀글여부 가져오기
    	            	String isSecret = 
    	            			tableview.getSelectionModel().getSelectedItem().getQna_secret_yn();
    	            	//비밀글 접근여부를 비교할 값 가져오기
    	            	String secretCheck = "";
    	            	
    	            	try {
    	            		secretCheck = service.secretCheck
    	            				(tableview.getSelectionModel().getSelectedItem().getNo());
    	            	} catch (RemoteException e) {
    	            		// TODO Auto-generated catch block
    	            		e.printStackTrace();
    	            	}
    	            	Parent parent = null;
    	            	
    	            	
    	            	//회원이 비밀글에 접근할 경우
    	            	if(role_code == 1 && isSecret.equals("y") && id.equals(secretCheck)) {
        	            
    	            	try {
    	            		
    	        			FXMLLoader loader = new FXMLLoader(getClass().getResource("qna_Show.fxml"));
    	        			parent = loader.load();
    	        			qnaShow = loader.getController();
    	        			
    	        			// 컨트롤러 시작시 선택된 객체 넘겨주기
    	        			qnaShow.initialize(tableview.getSelectionModel().getSelectedItem());
    	        			qnaShow.setQc(qnaCont);//컨트롤러 넘기기
    	            		qnaShow.setStage(stage);
    	        			
    	        			Scene scene = new Scene(parent);
    	        	    	
    	        	    	stage.setScene(scene);
    	        	    	stage.show();
    	            		
    	            	}catch(IOException ex) {ex.printStackTrace();}
    	            	}else if(role_code == 1 && isSecret.equals("y")){
    	            		errMsg("에러","접근권한이 없습니다");
    	            	}
    	            	

    	            	//회원이 아닌 변호사나 관리자일 경우
    	            	if(role_code != 1) {
    	            	
    	            	try {
    	            		
    	        			FXMLLoader loader = new FXMLLoader(getClass().getResource("qna_Show2.fxml"));
    	        			parent = loader.load();
    	        			qnaShow2 = loader.getController();
    	        			
    	        			// 컨트롤러 시작시 선택된 객체 넘겨주기
    	        			qnaShow2.initialize(tableview.getSelectionModel().getSelectedItem());
    	        			qnaShow2.setQc(qnaCont);//컨트롤러 넘기기
    	            		qnaShow2.setStage(stage);
    	        			
    	        			Scene scene = new Scene(parent);
    	        	    	
    	        	    	stage.setScene(scene);
    	        	    	stage.show();
    	            		
    	            		
    	            		/*
    	            		Stage as = (Stage)btnSearch.getScene().getWindow();
    	                	
    	                	Parent root = null;
    	                	try {
    	            			root = FXMLLoader.load(getClass().getResource("qna_show.fxml"));
    	            		} catch (IOException e) {
    	            			e.printStackTrace();
    	            		}
    	                	Scene scene = new Scene(root);
    	                	as.setTitle("Qna 글보기");
    	                	as.setScene(scene);
    	                	as.show();
    	            		*/
    	        	    	
    	            		
    	            	}catch(IOException ex) {ex.printStackTrace();}
    	            	}
    	            	
    	            	
    	            	//그외 보통 회원이 공개글에 접속할 경우
    	            	if(role_code == 1
        	            	&& isSecret.equals("n")) {
    	            	try {
    	            		
    	        			FXMLLoader loader = new FXMLLoader(getClass().getResource("qna_Show.fxml"));
    	        			parent = loader.load();
    	        			qnaShow = loader.getController();
    	        			
    	        			// 컨트롤러 시작시 선택된 객체 넘겨주기
    	        			qnaShow.initialize(tableview.getSelectionModel().getSelectedItem());
    	        			qnaShow.setQc(qnaCont);//컨트롤러 넘기기
    	            		qnaShow.setStage(stage);
    	        			
    	        			Scene scene = new Scene(parent);
    	        	    	
    	        	    	stage.setScene(scene);
    	        	    	stage.show();
    	            		
    	            	}catch(IOException ex) {ex.printStackTrace();}
    	            	}
    	            }
    	        }
    	    }
    	});
    	
    }
    
	
	//테이블세팅 메소드
    void tableSetting() {
    	
    	no.setCellValueFactory(new PropertyValueFactory<>("no"));
		title.setCellValueFactory(new PropertyValueFactory<>("qna_title"));
		secret_yn.setCellValueFactory(new PropertyValueFactory<>("qna_secret_yn"));
		writer.setCellValueFactory(new PropertyValueFactory<>("qna_writer"));
		date.setCellValueFactory(new PropertyValueFactory<>("qna_date"));
		List<QnaBoardVO> qnaList = null;
		
		try {
			qnaList = service.getAllQnaList();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < qnaList.size(); i++) {
			QnaBoardVO bv = qnaList.get(i);
			if(bv.getNo() != bv.getQna_group()) {
				//bv.setNo(null);
				bv.setQna_title("\t▶  "+bv.getQna_title());
			}
		}
		
		allTableData = FXCollections.observableArrayList(qnaList);
		tableview.setItems(allTableData);
    }
    
    
    //페이징 메소드
    void paging() {
    	
    	itemsForPage = 10; // 한 페이지에 보여줄 항목 수
		int toPageCount = allTableData.size()%itemsForPage == 0 ?
				allTableData.size()/itemsForPage : 
					allTableData.size()/itemsForPage +1 ;
		pagination.setPageCount(toPageCount); //전체 페이지수 설정
		
		pagination.setPageFactory(new Callback<Integer, Node>() {
			
			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * itemsForPage;
				to = from + itemsForPage -1;
				tableview.setItems(getTableViewData(from, to));
				return tableview;
			}
		});
    }
    protected ObservableList<QnaBoardVO> getTableViewData(int from, int to) {
		
		//현재 페이지의 데이터 초기화
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i = from; i <= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}
    
	
    @FXML
    void write(ActionEvent event) {
    	
    	Stage st = new Stage();
    	Parent parent = null;
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("qna_write.fxml"));
			parent = loader.load();
			qnaWrite = loader.getController();
			qnaWrite.setQnaCont(qnaCont);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Scene sc = new Scene(parent);
    	st.setScene(sc);
    	st.show();
    	
    }
    
    
    
    @FXML
    void search(ActionEvent event) {
    	QnaBoardVO qv = new QnaBoardVO();
    	
    	if(combo.getValue().equals("제목") && !fieldSearch.getText().isEmpty()) {
    		qv.setQna_title(fieldSearch.getText());
    		
    	}else if(combo.getValue().equals("내용") && !fieldSearch.getText().isEmpty()) {
    		qv.setQna_content(fieldSearch.getText());
    		
    	}else if(combo.getValue().equals("작성자") && !fieldSearch.getText().isEmpty()) {
    		qv.setQna_writer(fieldSearch.getText());
    	}
    	
    	List<QnaBoardVO> newlist = null;
		try {
			newlist = service.getSearchQna(qv);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	allTableData = FXCollections.observableArrayList(newlist);
    	paging();
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


	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
//	public QnaController getQnaCont() {
//		return qnaCont;
//	}
//	public void setQnaCont(QnaController qnaCont) {
//		this.qnaCont = qnaCont;
//	}
	public QnaShow getQnaShow() {
		return qnaShow;
	}
	public void setQnaShow(QnaShow qnaShow) {
		this.qnaShow = qnaShow;
	}
	
	
	
}

















