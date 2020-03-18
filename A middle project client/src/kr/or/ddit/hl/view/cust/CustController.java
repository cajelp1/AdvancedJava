package kr.or.ddit.hl.view.cust;

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
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import kr.or.ddit.hl.service.cust.ICustService;
import kr.or.ddit.hl.vo.CustomerCenterVO;

public class CustController {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;

    @FXML    private TableView<CustomerCenterVO> tableview;
    @FXML    private TableColumn<CustomerCenterVO, String> writer;
    @FXML    private TableColumn<CustomerCenterVO, String> title;
    @FXML    private TableColumn<CustomerCenterVO, String> secret_yn;
    @FXML    private TableColumn<CustomerCenterVO, String> date;
    @FXML    private TableColumn<CustomerCenterVO, String> no;
    
    @FXML    private Button btnSearch;
    @FXML    private Button btnWrite;
    @FXML    private Pagination pagination;
    @FXML    private ComboBox<String> combo;
    @FXML    private TextField fieldSearch;
    
    private Registry reg;
    private ICustService service;
    
    private int from, to, itemsForPage;
	private ObservableList<CustomerCenterVO> allTableData, currentPageData;
    
	
    @FXML
    void initialize() {
        
    	try {
			// 등록된 원격객체를 찾기위해 Registry객체를 생성한 후 사용할 객체를 불러온다.
			reg = LocateRegistry.getRegistry("localhost", 7777);
			service = (ICustService) reg.lookup("Customer");
			
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
    	
    	//테이블에서 글 선택하면 새로운 컨트롤러로 창 띄우기...?
    	
    }
    
	
	//테이블세팅 메소드
    private void tableSetting() {
    	
    	no.setCellValueFactory(new PropertyValueFactory<>("no"));
		title.setCellValueFactory(new PropertyValueFactory<>("cust_title"));
		writer.setCellValueFactory(new PropertyValueFactory<>("cust_writer"));
		date.setCellValueFactory(new PropertyValueFactory<>("cust_date"));
		List<CustomerCenterVO> custList = null;
		
		try {
			custList = service.getAllCustList();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < custList.size(); i++) {
			CustomerCenterVO bv = custList.get(i);
			if(!bv.getNo().equals(String.valueOf(bv.getCust_group()))) {
				//bv.setNo("");
				bv.setCust_title("\t▶  "+bv.getCust_title());
			}
		}
		
		allTableData = FXCollections.observableArrayList(custList);
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
    protected ObservableList<CustomerCenterVO> getTableViewData(int from, int to) {
		
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
    	
    }
    
    
    @FXML
    void search(ActionEvent event) {
    	CustomerCenterVO cv = new CustomerCenterVO();
    	
    	if(combo.getValue().equals("제목") && !fieldSearch.getText().isEmpty()) {
    		cv.setCust_title(fieldSearch.getText());
    		
    	}else if(combo.getValue().equals("내용") && !fieldSearch.getText().isEmpty()) {
    		cv.setCust_content(fieldSearch.getText());
    		
    	}else if(combo.getValue().equals("작성자") && !fieldSearch.getText().isEmpty()) {
    		cv.setCust_writer(fieldSearch.getText());
    	}
    	
    	List<CustomerCenterVO> newlist = null;
		try {
			newlist = service.getSearchCust(cv);
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

}

















