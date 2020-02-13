package kr.or.ddit.board.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kr.or.ddit.board.vo.BoardVO;

public class BoardCont {

    @FXML private ResourceBundle resources;

    @FXML private URL location;

    @FXML private Button btnCancel;
    @FXML private Button btnClose;
    @FXML private Button btnOk;
    @FXML private Button btnDelete;
    @FXML private Button btnEdit;

    @FXML private TextField board_title;
    @FXML private TextField board_writer;
    @FXML private TextArea board_content;
    
    BoardVO vo;

    @FXML
    void initialize() {
        
    }
    
    void initialize(BoardVO board) {
    	
    	board_title.setText(board.getBoard_title());
    	board_writer.setText(board.getBoard_writer());
    	board_content.setText(board.getBoard_content());
    	
    }
    
    
    @FXML void editBoard(ActionEvent event) {
    	
    }

    @FXML
    void deleteBoard(ActionEvent event) {
    	
    }

    @FXML
    void ok(ActionEvent event) {
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	
    }

    @FXML
    void close(ActionEvent event) {
    	
    }

}
