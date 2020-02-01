package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.Node;
import javafx.scene.control.Pagination;

public class PagingController implements Initializable{

	@FXML TableView<MemberVO> tableView;
	@FXML TableColumn<MemberVO, String> id;
	@FXML TableColumn<MemberVO, String> name;
	@FXML TableColumn<MemberVO, String> addr;
	@FXML Pagination pagination;

	private int from, to, itemsForPage;
	
	private ObservableList<MemberVO> allTableData, currentPageData;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		addr.setCellValueFactory(new PropertyValueFactory<>("addr"));
		
		//전체 테이블 데이터 설정
		allTableData = FXCollections.observableArrayList();
		
		allTableData.add(new MemberVO("1", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("2", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("3", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("4", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("5", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("6", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("7", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("8", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("9", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("10", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("11", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("12", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("13", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("14", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("15", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("16", "이예림", "대전시 중구 대흥동 대덕인재개발원"));
		
		itemsForPage = 5; // 한 페이지에 보여줄 항목 수
		int toPageCount = allTableData.size()%itemsForPage == 0 ?
				allTableData.size()/itemsForPage : 
					allTableData.size()/itemsForPage +1 ;
		pagination.setPageCount(toPageCount); //전체 페이지수 설정
		
		pagination.setPageFactory(new Callback<Integer, Node>() {
			
			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * itemsForPage;
				to = from + itemsForPage -1;
				tableView.setItems(getTableViewData(from, to));
				return tableView;
			}
		});
	}
	
	
	//tableviw에 채워줄 데이터를 가져오는 메서드
	protected ObservableList<MemberVO> getTableViewData(int from, int to) {
		
		//현재 페이지의 데이터 초기화
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i = from; i <= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}
	
	public class MemberVO {
		private String id;
		private String name;
		private String addr;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public MemberVO(String id, String name, String addr) {
			super();
			this.id = id;
			this.name = name;
			this.addr = addr;
		}
	}
}

