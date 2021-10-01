package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass1 {

	public void start(){
		try {
			Stage arg1 = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("login.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			loginController ctl = loader.getController();
			ctl.setRoot(root);
			
			arg1.setScene(scene);
			arg1.show();
		}catch(Exception e) {
			
		}
		
	}
}
		
		
	


