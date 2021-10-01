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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class loginController implements Initializable {
	@FXML Button btnLogin;
	@FXML TextField currenttime;
	@FXML Button exit;
	Parent root;
	public void setRoot(Parent root) {
		this.root=root;
		try {
		 btnLogin=(Button)root.lookup("#btnLogin");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction(e->handleBtnLogin(e));
		Thread thread = new Thread() {
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
				while(true) {
					String Time = sdf.format(new Date());
					Platform.runLater(()->{
						currenttime.setText(Time);
					});
					try {
						Thread.sleep(100);
					}
					catch (Exception e) {
					}
				}
			};
		};
		thread.setDaemon(true);
		thread.start();
	}
	
	public void  handleBtnLogin(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("selectRoom.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.show();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void exit(ActionEvent event) {
		Platform.exit();
	}
}