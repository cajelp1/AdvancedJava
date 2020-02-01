package kr.or.ddit.basic.H03;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class H03_Controller {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private ComboBox<H03_LprodVO> box1;
    @FXML    private ComboBox<H03_ProdVO> box2;
    
    @FXML    private TableView<H03_ProdVO> tableview;
    
    @FXML    private TableColumn<H03_ProdVO, Integer> prod_sale;
    @FXML    private TableColumn<H03_ProdVO, String> prod_lgu;
    @FXML    private TableColumn<H03_ProdVO, String> prod_detail;
    @FXML    private TableColumn<H03_ProdVO, Integer> prod_price;
    @FXML    private TableColumn<H03_ProdVO, String> prod_outline;
    @FXML    private TableColumn<H03_ProdVO, Integer> prod_cost;
    @FXML    private TableColumn<H03_ProdVO, String> prod_id;
    @FXML    private TableColumn<H03_ProdVO, String> prod_name;
    @FXML    private TableColumn<H03_ProdVO, String> prod_buyer;
    
    H03_Service service = H03_ServiceImpl.getInstance();
    
    @FXML
    void initialize() {
    	
        // 첫번째 콤보박스 세팅
    	// 콤보박스의 리스트
    	box1.setCellFactory(new Callback<ListView<H03_LprodVO>, ListCell<H03_LprodVO>>() {
			
			@Override
			public ListCell<H03_LprodVO> call(ListView<H03_LprodVO> param) {
				
				return new ListCell<H03_LprodVO>() {
					@Override
					protected void updateItem(H03_LprodVO item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getLprod_nm());
						}
					}
				};
			}
		});
    	// 콤보박스의 보여지는 부분
    	box1.setButtonCell(new ListCell<H03_LprodVO>() {
    		@Override
    		protected void updateItem(H03_LprodVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(!empty) {
    				setText(item.getLprod_nm());
    			}
    		}
    	});
    	
    	// 두번째 콤보박스 세팅
    	box2.setCellFactory(new Callback<ListView<H03_ProdVO>, ListCell<H03_ProdVO>>() {
			
			@Override
			public ListCell<H03_ProdVO> call(ListView<H03_ProdVO> param) {
				
				return new ListCell<H03_ProdVO>() {
					@Override
					protected void updateItem(H03_ProdVO item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getProd_name());
						}
					}
				};
			}
		});
    	
    	box2.setButtonCell(new ListCell<H03_ProdVO>() {
    		@Override
    		protected void updateItem(H03_ProdVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(!empty) {
    				setText(item.getProd_name());
    			}
    		}
    	});
    	
    	// 첫번째 콤보박스 데이터 가져오기
    	ObservableList<H03_LprodVO> llist = 
    			FXCollections.observableArrayList(service.getCombo1()); 
    	box1.setItems(llist);
    	
    }

    @FXML
    void box1Changed(ActionEvent event) {
    	
    	// 두번째 콤보박스 데이터 가져오기
    	H03_LprodVO lvo  = box1.getValue();
    	ObservableList<H03_ProdVO> plist = 
    			FXCollections.observableArrayList(service.getCombo2(lvo.getLprod_gu()));
    	box2.setItems(plist);
    	
    }

    @FXML
    void box2Changed(ActionEvent event) {
    	// 세팅된 값을 가져옴
    	H03_ProdVO pvo = box2.getValue();
    	
    	//값이 있을경우 두번째 컬럼세팅
    	if(pvo != null) {
    	ObservableList<H03_ProdVO> plist = 
    			FXCollections.observableArrayList(service.getRealVO(pvo.getProd_id()));
    	
    	// 테이블 뷰에 데이터 세팅
    	tableview.setItems(plist);
    	// 컬럼값 매칭
    	prod_id.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
    	prod_name.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
    	prod_lgu.setCellValueFactory(new PropertyValueFactory<>("prod_lgu"));
    	prod_buyer.setCellValueFactory(new PropertyValueFactory<>("prod_buyer"));
    	prod_cost.setCellValueFactory(new PropertyValueFactory<>("prod_cost"));
    	prod_price.setCellValueFactory(new PropertyValueFactory<>("prod_price"));
    	prod_sale.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
    	prod_outline.setCellValueFactory(new PropertyValueFactory<>("prod_outline"));
    	prod_detail.setCellValueFactory(new PropertyValueFactory<>("prod_detail"));
    	}
    	
    }

}
