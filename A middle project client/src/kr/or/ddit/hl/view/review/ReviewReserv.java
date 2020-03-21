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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.hl.service.review.IReviewService;
import kr.or.ddit.hl.vo.ReservationVO;
import kr.or.ddit.hl.vo.SessionVO;

public class ReviewReserv {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;

    @FXML    private TableView<ReservationVO> tableview;
    @FXML    private TableColumn<ReservationVO, String> res_type;
    @FXML    private TableColumn<ReservationVO, String> res_lawer_id;
    @FXML    private TableColumn<ReservationVO, Integer> res_no;
    @FXML    private TableColumn<ReservationVO, String> res_date;

    @FXML    private Pagination pagination;
    
    private ReviewController rc;
    private Stage stage;
    
    private Registry reg;
    private IReviewService service;
    private int from, to, itemsForPage;
	private ObservableList<ReservationVO> allTableData, currentPageData;
    
    
    @FXML
    void initialize() {
        
    	String mem_id = SessionVO.id;
    	mem_id = "user1";
    	
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
    	tableSetting(mem_id);
    	paging();
    	
    	//클릭했을 때
    	tableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
    	            if(mouseEvent.getClickCount() == 2){
    	            	
    	            	//글쓰기 창을 띄운다
    	            	Stage st = new Stage();
    	            	Parent parent = null;
    	            	try {
    	        			FXMLLoader loader = new FXMLLoader(getClass().getResource("review_write.fxml"));
    	        			parent = loader.load();
    	        			ReviewWrite rr = loader.getController();
    	        			rr.setRc(rc);
    	        			rr.initialize(tableview.getSelectionModel().getSelectedItem().getRes_no());
    	        			
    	        		} catch (IOException e) {
    	        			// TODO Auto-generated catch block
    	        			e.printStackTrace();
    	        		}
    	            	
    	            	Scene sc = new Scene(parent);
    	            	st.setScene(sc);
    	            	st.show();
    	            	
    	            	//창닫기
    	            	Stage stage = (Stage)tableview.getScene().getWindow();
    			    	stage.close();
    	            }
    	        }
    	    }
    	});
    	
    }
    
  //테이블세팅 메소드
    void tableSetting(String mem_id) {
    	
    	res_no.setCellValueFactory(new PropertyValueFactory<>("res_no"));
		res_lawer_id.setCellValueFactory(new PropertyValueFactory<>("res_lawyer_id"));
		res_type.setCellValueFactory(new PropertyValueFactory<>("res_type"));
		res_date.setCellValueFactory(new PropertyValueFactory<>("res_date"));
		
		List<ReservationVO> list = null;
		
		try {
			list = service.getReservationList(mem_id);
		} catch (RemoteException e1) {
			e1.printStackTrace();
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
    protected ObservableList<ReservationVO> getTableViewData(int from, int to) {
		
		//현재 페이지의 데이터 초기화
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i = from; i <= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}

    
    
	public ReviewController getRc() {
		return rc;
	}
	public void setRc(ReviewController rc) {
		this.rc = rc;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
    
}
