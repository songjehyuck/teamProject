package application;	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    
	static MemberList mb_info 	 = new MemberList();
    static BookList books 	= new BookList();
    static BookItem[] item = books.getCurrentAll();
    
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFrm.fxml"));
			loader.setController(new ControllerMain());
			Parent root = (Parent)loader.load();
			root.setStyle("-fx-background-color:#fff");
			Scene scene = new Scene(root); 
			primaryStage.setTitle("Library Booking System");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	 
	public static MemberList getMemberList() {
		return mb_info;
	}
	
    
	public static void showAlert(String msg) { 
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("알림");
	    alert.setHeaderText(null);
	    alert.setContentText(msg);
	    alert.showAndWait();
	    
	    return;
	}
    
	
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
}
