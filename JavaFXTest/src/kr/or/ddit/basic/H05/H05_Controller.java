package kr.or.ddit.basic.H05;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class H05_Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML private TableView<ScoreVO> tableView;
    @FXML private TableColumn<ScoreVO, String> name;
    @FXML private TableColumn<ScoreVO, Integer> korean;
    @FXML private TableColumn<ScoreVO, Integer> math;
    @FXML private TableColumn<ScoreVO, Integer> english;
    
    @FXML private Button add;
    @FXML private Button del;
    @FXML private Button barGraph;
    @FXML private Button pieGraph;

    ObservableList<ScoreVO> list; 
    
    @FXML
    void initialize() {
       
    	list = FXCollections.observableArrayList();
    	list.add(new ScoreVO("홍길동", 60, 60, 60));
    	
    	tableView.setItems(list);
    	
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));
    	korean.setCellValueFactory(new PropertyValueFactory<>("korean"));
    	math.setCellValueFactory(new PropertyValueFactory<>("math"));
    	english.setCellValueFactory(new PropertyValueFactory<>("english"));
    	
    }
    
    @FXML
    void addScore(ActionEvent event) {
    	// 1. state객체 사용
    	Stage addScore = new Stage(StageStyle.UTILITY);
    	
    	// 2. 모딜창 여부 설정
    	// 모딜창은 자식창이 나타나면 부모창을 사용할 수 없다.
    	addScore.initModality(Modality.APPLICATION_MODAL);
    	
    	// 3. 부모창 지정
    	//dialog.initOwner(primaryStage); //뭐야 primaryStage 안 해줘도 일단 동작은 하는데요? 부모창이 없을 뿐.
    	addScore.setTitle("사용자 정의 창");
    	
    	// 4. 자식창이 나타날 컨테이너 객체 생성
    	Parent parent = null;
    	
    	try {
    		parent = FXMLLoader.load(getClass().getResource("H05_add.fxml"));
    	}catch(IOException ex) {ex.printStackTrace();}
    	
    	
    	//부모창에서 FXML로 만든 자식창의 컨트롤객체 얻기
    	TextField txtName = (TextField) parent.lookup("#txtName");
    	TextField txtKorean = (TextField) parent.lookup("#txtKorean");
    	TextField txtMath = (TextField) parent.lookup("#txtMath");
    	TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
    	
    	//뭐야.. 버튼 액션을 다 일일이 써야하네 ㅡㅡ
    	Button btnAdd = (Button) parent.lookup("#btnAdd");
    	btnAdd.setOnAction(btnAddScore -> {
    		ScoreVO score = new ScoreVO();
    		
    		String name = txtName.getText();
    		String korean = txtKorean.getText();
    		String math = txtMath.getText();
    		String english = txtEnglish.getText();
    		int flag = 0;
    		
    		if(!name.isEmpty()) 
    			{ score.setName(name); flag++;}
    		if(!korean.isEmpty() && korean.matches("^[0-9]{1,3}$") && Integer.parseInt(korean)<101)
    			{ score.setKorean(Integer.parseInt(korean)); flag++;}
    		if(!math.isEmpty() && math.matches("^[0-9]{1,3}$") && Integer.parseInt(math)<101)
				{ score.setMath(Integer.parseInt(math)); flag++;}
    		if(!english.isEmpty() && english.matches("^[0-9]{1,3}$") && Integer.parseInt(english)<101)
				{ score.setEnglish(Integer.parseInt(english)); flag++;}
    		
    		if (flag<4){ errMsg("빈칸 혹은 성적이 아닌 값을 입력하셨습니다");}
    		if(flag == 4) {list.add(score); addScore.close();}
    	});
    	
    	Button btnCancel = (Button) parent.lookup("#btnCancel");
    	btnCancel.setOnAction(btnCancelScore -> {
    		addScore.close();
    	});
    	
    	// 5. Scene 객체 생성해서 컨테이너 객체 추가 
    	Scene scene = new Scene(parent);
    	
    	// 6. Stage객체에 Scene추가
    	addScore.setScene(scene);
    	addScore.setResizable(false); //크기고정
    	addScore.show();
    }
    
    @FXML
    void delScore(ActionEvent event) {
    	
    	if(tableView.getSelectionModel().isEmpty()) {
    		errMsg("지울 데이터를 선택하세요");
    	}else {
    		list.remove(tableView.getSelectionModel().getSelectedIndex());
    	}
    	
    }

    @FXML
    void showPie(ActionEvent event) {
    	
    	if(tableView.getSelectionModel().isEmpty()) {
    		errMsg("차트를 볼 데이터를 선택하세요");
    	}else {
    		
    		Stage showPie = new Stage(StageStyle.UTILITY);
    		showPie.initModality(Modality.APPLICATION_MODAL);
        	
        	showPie.setTitle("파이 그래프");
        	
        	Parent parent = null;
        	try {
        		parent = FXMLLoader.load(getClass().getResource("H05_pieChar.fxml"));
        	}catch(Exception e) { e.printStackTrace();}
        	
    		
    		ScoreVO score = tableView.getSelectionModel().getSelectedItem();
    		
    		PieChart pieChart = (PieChart) parent.lookup("#pieChar");
    		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
    				new PieChart.Data(korean.getText(), score.getKorean()),
    				new PieChart.Data(math.getText(), score.getMath()),
    				new PieChart.Data(english.getText(), score.getEnglish())
    			);
    		
    		pieChart.setTitle(score.getName());
    		pieChart.setData(pieChartData);
    		pieChart.setLegendSide(Side.BOTTOM);
    		
    		Scene scene = new Scene(parent);
    		showPie.setScene(scene);
    		showPie.show();
    		
    		Button btnClose = (Button) parent.lookup("#btnClose");
        	btnClose.setOnAction(btnClosed ->{
        		showPie.close();
        	});
    	}
    }
    
    @FXML
    void showBar(ActionEvent event) {
    	
    	Stage showBar = new Stage(StageStyle.UTILITY);
    	showBar.initModality(Modality.APPLICATION_MODAL);
    	
    	showBar.setTitle("막대 그래프");
    	
    	Parent parent = null;
    	try {
    		parent = FXMLLoader.load(getClass().getResource("H05_barChar.fxml"));
    	}catch(Exception e) { e.printStackTrace();}
    	
    	
    	CategoryAxis xAxis = (CategoryAxis) parent.lookup("#xAxis");
    	NumberAxis yAxis = (NumberAxis) parent.lookup("#yAxis");
    	BarChart<String, Number> bc = (BarChart<String,Number>) parent.lookup("#barChar"); //뷁
    	
    	XYChart.Series<String, Number> kChart = new XYChart.Series<>();
    	XYChart.Series<String, Number> mChart = new XYChart.Series<>();
    	XYChart.Series<String, Number> eChart = new XYChart.Series<>();
    	
    	kChart.setName("국어");
    	mChart.setName("수학");
    	eChart.setName("영어");
    	
    	for(int i =0; i < list.size(); i++) {
    		kChart.getData().add(new XYChart.Data<String, Number>
    			(list.get(i).getName(), list.get(i).getKorean()));
    		mChart.getData().add(new XYChart.Data<String, Number>
				(list.get(i).getName(), list.get(i).getMath()));
    		eChart.getData().add(new XYChart.Data<String, Number>
				(list.get(i).getName(), list.get(i).getEnglish()));
    	}
    	
    	bc.getData().addAll(kChart, mChart, eChart);
    	
    	
    	Scene scene = new Scene(parent);
    	showBar.setScene(scene);
    	showBar.show();
    	
    	Button btnClose = (Button) parent.lookup("#btnClose");
    	btnClose.setOnAction(btnClosed ->{
    		showBar.close();
    	});
    }
    
    public void errMsg(String header) {
    	Alert alt = new Alert(AlertType.ERROR);
    	alt.setHeaderText(header);
    	alt.showAndWait();
    }
    
    public class ScoreVO {
    	private String name;
    	private int korean;
    	private int math;
    	private int english;
    	
    	public ScoreVO() {}
    	
    	public ScoreVO(String name, int korean, int math, int english) {
    		super();
    		this.name = name;
    		this.korean = korean;
    		this.math = math;
    		this.english = english;
    	}
    	public String getName() {
    		return name;
    	}
    	public void setName(String name) {
    		this.name = name;
    	}
    	public int getKorean() {
    		return korean;
    	}
    	public void setKorean(int korean) {
    		this.korean = korean;
    	}
    	public int getMath() {
    		return math;
    	}
    	public void setMath(int math) {
    		this.math = math;
    	}
    	public int getEnglish() {
    		return english;
    	}
    	public void setEnglish(int english) {
    		this.english = english;
    	}
    	
    }

}


