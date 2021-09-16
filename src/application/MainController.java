package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController implements Initializable{
	
	@FXML
	private TextField Username;
	
	@FXML 
	private Label lbl_title;
	
	@FXML
	private PasswordField Password;
	
	public void Login(ActionEvent event) throws Exception{
		if ( Username.getText().equals("test") && Password.getText().equals("test") ) {
			((Node) event.getSource()).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("LibraryUi.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();	
		}else {
			lbl_title.setText("Loign Error");
		}
		
	}
	
	public void register(ActionEvent event) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	public void r_cancel(ActionEvent event) throws Exception{
		((Node) event.getSource()).getScene().getWindow().hide();
	}
	
	public void r_success(ActionEvent event) throws Exception{
		System.out.println("aa");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
