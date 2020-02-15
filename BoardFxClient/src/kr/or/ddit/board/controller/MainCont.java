package kr.or.ddit.board.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class MainCont {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML private ComboBox<String> combo;
    @FXML private TextField txtField;
    @FXML private Button btnSearch;
    @FXML private Button btnWrite;
    
    @FXML private Pagination pagination;
    
    @FXML private TableView<BoardVO> table;
    @FXML private TableColumn<BoardVO, String> board_title;
    @FXML private TableColumn<BoardVO, Date> board_date;
    @FXML private TableColumn<BoardVO, Integer> board_no;
    @FXML private TableColumn<BoardVO, String> board_writer;
    
    BoardServiceImpl service = BoardServiceImpl.getInstance();
    
    private int from, to, itemsForPage;
    ObservableList<BoardVO> allTableData, currentPageData;
    
    @FXML
    void initialize() {
    	final MainCont main = this;
    	board_title.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    	board_date.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    	board_writer.setCellValueFactory(new PropertyValueFactory<>("board_writer"));
    	board_no.setCellValueFactory(new PropertyValueFactory<>("board_no"));
    	
    	setData();
    	
    	//검색부분 세팅
    	combo.getItems().addAll("All","번호","제목","작성자","내용");
    	combo.setValue("All");
    	txtField.setPromptText("검색창. All을 선택하고 검색할 시 전체게시물 조회.");
    	
    	
    	//테이블에서 마우스 더블클릭
    	table.setOnMouseClicked(new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
    	            if(mouseEvent.getClickCount() == 2){
    	                
    	            	//새로운 컨트롤러 및 창소환
    	            	Stage boardCont = new Stage(StageStyle.UTILITY);
    	            	boardCont.initModality(Modality.APPLICATION_MODAL);
    	            	
    	            	Parent parent = null;
    	            	
    	            	try {
    	            		// 다른 컨트롤러를 사용하기위해 호출
    	        			FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
    	        			// fxml 로드
    	        			parent = loader.load();
    	        			// 해당 fxml에 연결된 컨트롤러 호출
    	        			BoardCont bCont = loader.getController();
    	        			
    	        			// 컨트롤러 시작시 선택된 객체 넘겨주기
    	        			bCont.initialize(table.getSelectionModel().getSelectedItem());
    	        			bCont.setMain(main);
    	            		
    	        			// 창띄우기
    	        			Scene scene = new Scene(parent);
    	        	    	
    	        	    	// Stage객체에 Scene추가
    	        	    	boardCont.setScene(scene);
    	        	    	boardCont.setResizable(false); //크기고정
    	        	    	boardCont.show();
    	            		
    	            	}catch(IOException ex) {ex.printStackTrace();}
    	            }
    	        }
    	    }
    	});
    	
    	
    	
    }
    
    void setData() {
    	//테이블 세팅
    	allTableData = FXCollections.observableArrayList(service.getAllBoardList());
    	
    	table.setItems(allTableData);
       	paging();
            	
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
				table.setItems(getTableViewData(from, to));
				return table;
			}
		});
    }
    protected ObservableList<BoardVO> getTableViewData(int from, int to) {
		
		//현재 페이지의 데이터 초기화
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i = from; i <= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}
    
    
    
    @FXML
    void searchBoard(ActionEvent event) {
    	BoardVO bv = new BoardVO();
    	
    	//입력값에 따라 VO객체의 값 설정
    	if(combo.getValue().equals("번호") && txtField.getText().matches("^[0-9]+$")) {
    		bv.setBoard_no(Integer.parseInt(txtField.getText()));
    		
    	}else if(combo.getValue().equals("제목") && !txtField.getText().isEmpty()) {
    		bv.setBoard_title(txtField.getText());
    		
    	}else if(combo.getValue().equals("작성자") && !txtField.getText().isEmpty()) {
    		bv.setBoard_writer(txtField.getText());
    		
    	}else if(combo.getValue().equals("내용") && !txtField.getText().isEmpty()) {
    		bv.setBoard_content(txtField.getText());
    		
    	}else if(combo.getValue().equals("All")) {
    		allTableData = FXCollections.observableArrayList(service.getAllBoardList());
        	paging();
        	return;
    	}
    	
    	List<BoardVO> newlist = service.getSearchBoard(bv);
    	
    	allTableData = FXCollections.observableArrayList(newlist);
    	paging();
    }
    
    
    @FXML
    void WriteBoard(ActionEvent event) {
    	
    	//새로운 컨트롤러 및 창소환
    	Stage boardCont = new Stage(StageStyle.UTILITY);
    	boardCont.initModality(Modality.APPLICATION_MODAL);
    	
    	Parent parent = null;
    	
    	try {
    		// 다른 컨트롤러를 사용하기위해 호출
			FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
			// fxml 로드
			parent = loader.load();
			// 해당 fxml에 연결된 컨트롤러 호출
			BoardCont bCont = loader.getController();
			
			bCont.setMain(this);
    		
			// 창띄우기
			Scene scene = new Scene(parent);
	    	
	    	// Stage객체에 Scene추가
	    	boardCont.setScene(scene);
	    	boardCont.setResizable(false); //크기고정
	    	boardCont.show();
    		
    	}catch(IOException ex) {ex.printStackTrace();}
    	
    	
    }
    
    
}
