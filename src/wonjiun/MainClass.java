package wonjiun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//${javafxCompControls},javafx.fxml
public class MainClass{

	public void SearchOpen() {
		try {
			Stage arg1 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("book_wonjiun.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			Controller ctl = loader.getController();
			ctl.setRoot(root);
			arg1.setScene(scene);
			arg1.setTitle("새 도서 등록 / 도서 대출");
			arg1.show();
		}catch(Exception e) {
			
		}
		

	}
	
}
