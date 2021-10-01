package teamProject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import register.RegisterMain;

public class LoginController implements Initializable {
	Parent root;
	RegisterMain rg;
	LoginService ls;

	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rg = new RegisterMain();
		ls = new LoginService();

	}

	public void goRegister() {
		rg.viewRegister();
	}

	public void login() {
		ls.setRoot(root);
		ls.emptyCheck();
	}
}
