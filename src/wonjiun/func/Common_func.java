package wonjiun.func;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Common_func {
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void AlertFunc(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	public void Close() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
}
