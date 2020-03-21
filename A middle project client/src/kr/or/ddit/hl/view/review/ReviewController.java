package kr.or.ddit.hl.view.review;


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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.hl.service.review.IReviewService;
import kr.or.ddit.hl.vo.ReviewVO;
import kr.or.ddit.hl.vo.SessionVO;

public class ReviewController {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;

    @FXML    private AnchorPane reviewPane;
    
    @FXML    private TableView<ReviewVO> tableview;
    @FXML    private TableColumn<ReviewVO, String> writer;
    @FXML    private TableColumn<ReviewVO, String> date;
    @FXML    private TableColumn<ReviewVO, Integer> no;
    @FXML    private TableColumn<ReviewVO, String> title;
    @FXML    private TableColumn<ReviewVO, String> score;
    @FXML    private Pagination pagination;

    @FXML    private Button btnSearch;
    @FXML    private Button btnmenu;
    @FXML    private Button btnWrite;

    @FXML    private ComboBox<String> combo1;
    @FXML    private ComboBox<String> combo2;
    @FXML    private TextField fieldSearch;
    
    private Registry reg;
    private IReviewService service;
    private int from, to, itemsForPage;
	private ObservableList<ReviewVO> allTableData, currentPageData;
    
    private boolean isLogin;
    private String id;
    
    private ReviewController rc;
    private ReviewShow rs;
    private Stage stage;
    
    private int res_no;
    
    @FXML
    void initialize() {
    	
    	rc = this;
    	
    	//세션에서 값 가져오기
    	isLogin = SessionVO.isLogin;
    	id = SessionVO.id;
    	
    	
    	
    	//로그인 안 한 상태에서는 글쓰기 불가능
    	if(!isLogin)btnWrite.setDisable(true);
    	
    	//예약글 가져오는데 연관된 변수. 일단 마이너스로 세팅하고 이후 값이 바뀌면 새로운 기능 시작
    	res_no = -1;
    	
    	//콤보세팅
    	combo1.getItems().addAll("제목", "작성자", "내용", "--All--");
    	combo1.setValue("조건선택");
    	combo2.getItems().addAll("★☆☆☆☆ 이상", "★★☆☆☆ 이상", "★★★☆☆ 이상", "★★★★☆ 이상", "★★★★★ 이상", "--All--");
    	combo2.setValue("평점선택");
    	
    	//rmi 접속
    	try {
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (IReviewService) reg.lookup("Review");
		}catch(RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//테이블 세팅 및 페이징
    	tableSetting();
    	paging();
    	
    	//클릭했을 때 
    	tableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
    	            if(mouseEvent.getClickCount() == 2){
    	            	
    	            	Parent parent = null;
    	            	
    	            	try {
    	            		
    	        			FXMLLoader loader = new FXMLLoader(getClass().getResource("review_Show.fxml"));
    	        			parent = loader.load();
    	        			rs = loader.getController();
    	        			
    	        			// 컨트롤러 시작시 선택된 객체 넘겨주기
    	        			rs.initialize(tableview.getSelectionModel().getSelectedItem());
    	        			rs.setRc(rc);//컨트롤러 넘기기
    	            		rs.setStage(stage);
    	        			
    	        			Scene scene = new Scene(parent);
    	        	    	
    	        	    	stage.setScene(scene);
    	        	    	stage.show();
    	            		
    	            	}catch(IOException ex) {ex.printStackTrace();}
    	            }
    	        }
    	    }
    	});
    }
    
    //테이블세팅 메소드
    void tableSetting() {
    	
    	no.setCellValueFactory(new PropertyValueFactory<>("review_no"));
		title.setCellValueFactory(new PropertyValueFactory<>("review_title"));
		score.setCellValueFactory(new PropertyValueFactory<>("review_grade_st"));
		writer.setCellValueFactory(new PropertyValueFactory<>("review_writer"));
		date.setCellValueFactory(new PropertyValueFactory<>("review_date"));
		List<ReviewVO> list = null;
		
		try {
			list = service.getAllReviewList();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		if(list.size() != 0) {
		for (int i = 0; i < list.size(); i++) {
			ReviewVO rv = list.get(i);
			if(rv.getReview_grade() == 1) {
				rv.setReview_grade_st("★☆☆☆☆");
			}else if(rv.getReview_grade() == 2) {
				rv.setReview_grade_st("★★☆☆☆");
			}else if(rv.getReview_grade() == 3) {
				rv.setReview_grade_st("★★★☆☆");
			}else if(rv.getReview_grade() == 4) {
				rv.setReview_grade_st("★★★★☆");
			}else if(rv.getReview_grade() == 5) {
				rv.setReview_grade_st("★★★★★");
			}else {
				rv.setReview_grade_st("unknown");
			}
		}
		}
		
		allTableData = FXCollections.observableArrayList(list);
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
    protected ObservableList<ReviewVO> getTableViewData(int from, int to) {
		
		//현재 페이지의 데이터 초기화
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i = from; i <= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}
    
    
    
    
    @FXML    void search(ActionEvent event) {
    	
    	ReviewVO rv = new ReviewVO();
    	
    	if(combo1.getValue().equals("제목") && !fieldSearch.getText().isEmpty()) {
    		rv.setReview_title(fieldSearch.getText());
    		
    	}else if(combo1.getValue().equals("내용") && !fieldSearch.getText().isEmpty()) {
    		rv.setReview_content(fieldSearch.getText());
    		
    	}else if(combo1.getValue().equals("작성자") && !fieldSearch.getText().isEmpty()) {
    		rv.setReview_writer(fieldSearch.getText());
    	}
    	
    	if(combo2.getValue().equals("★☆☆☆☆ 이상")) {
    		rv.setReview_grade(1);
    		
    	}else if(combo2.getValue().equals("★★☆☆☆ 이상")) {
    		rv.setReview_grade(2);
    		
    	}else if(combo2.getValue().equals("★★★☆☆ 이상")) {
    		rv.setReview_grade(3);
    		
    	}else if(combo2.getValue().equals("★★★★☆ 이상")) {
    		rv.setReview_grade(4);
    		
    	}else if(combo2.getValue().equals("★★★★★ 이상")) {
    		rv.setReview_grade(5);
    	}
    	System.out.println(rv.getReview_grade());
    	
    	
    	List<ReviewVO> list2 = null;
    	
    	try {
			list2 = service.getSearchReview(rv);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//검색결과에서 스코어 점수에 따른 컬럼값 바꿔주기
    	if(list2.size() != 0) {
    		for (int i = 0; i < list2.size(); i++) {
    			ReviewVO rv2 = list2.get(i);
    			if(rv2.getReview_grade() == 1) {
    				rv2.setReview_grade_st("★☆☆☆☆");
    			}else if(rv2.getReview_grade() == 2) {
    				rv2.setReview_grade_st("★★☆☆☆");
    			}else if(rv2.getReview_grade() == 3) {
    				rv2.setReview_grade_st("★★★☆☆");
    			}else if(rv2.getReview_grade() == 4) {
    				rv2.setReview_grade_st("★★★★☆");
    			}else if(rv2.getReview_grade() == 5) {
    				rv2.setReview_grade_st("★★★★★");
    			}else {
    				rv2.setReview_grade_st("unknown");
    			}
    		}
    	}
    	
    	allTableData = FXCollections.observableArrayList(list2);
    	paging();
    }
    
    @FXML    void write(ActionEvent event) {
    	
    	//글 작성이 가능한 예약완료가 있는지 검색해서 띄워준다
    	Parent parent = null;
    	
    	Stage st = new Stage();
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("review_reserv.fxml"));
			parent = loader.load();
			ReviewReserv rr = loader.getController();
			
			rr.initialize();
			rr.setRc(rc);//컨트롤러 넘기기
    		rr.setStage(stage);
			
			Scene scene = new Scene(parent);
	    	
	    	st.setScene(scene);
	    	st.show();
    		
    	}catch(IOException ex) {ex.printStackTrace();}
    	
    }


    
    @FXML    void toMenu(ActionEvent event) {
    	
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
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	
}
