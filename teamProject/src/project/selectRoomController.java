package project;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class selectRoomController implements Initializable {
	@FXML Button btnroom1;
	@FXML Button btnroom2;
	@FXML Button btnroom3;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void  handleBtnRoom1(ActionEvent event) {
		try {
			Parent login= FXMLLoader.load(getClass().getResource("seat1.fxml"));
			AnchorPane root = (AnchorPane)btnroom1.getScene().getRoot();
			root.getChildren().add(login);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void  handleBtnRoom2(ActionEvent event) {
		try {
			Parent login= FXMLLoader.load(getClass().getResource("seat2.fxml"));
			AnchorPane root = (AnchorPane)btnroom2.getScene().getRoot();
			root.getChildren().add(login);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  handleBtnRoom3(ActionEvent event) {
		try {
			Parent login= FXMLLoader.load(getClass().getResource("seat3.fxml"));
			AnchorPane root = (AnchorPane)btnroom3.getScene().getRoot();
			root.getChildren().add(login);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}