package teamProject;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import bookbooking.Main;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import memberService.MemberDTO;

import wonjiun.MainClass;
import wonjiun.func.Borrow_func;
import wonjiun.func.Member_func;

public class MainPageController implements Initializable{
	Parent root;
	MainPageService mps;
	int arrClk;
	Label userID;
	//MemberDTO dto;
	MainClass wju = new MainClass();
	Borrow_func wju_b;
	Member_func wju_m;
	Main hoon = new Main();
	//ImageView fxImageView;
	
	public void setRoot(Parent root) {
		this.root = root;
		//userIdViewer();
		mps.setRoot(root);
		//fxImageView = (ImageView)root.lookup("#viewBook");
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mps = new MainPageService();
		userID = new Label();
		//dto = new MemberDTO();
		wju_b = new Borrow_func();
		wju_m = new Member_func();
		
	}
	public void userIdViewer(String userId) {
		userID = (Label)root.lookup("#userIdViewer");
		userID.setText(userId);
	}
	
	public void arrowLeft() {
		arrClk = 0;
		mps.arrowClick(arrClk);
//		Image image = new Image(getClass().getResource("/teamProject/book2.png").toExternalForm());
//		fxImageView.setImage(image);
	}
	public void arrowRight() {
		arrClk = 1;
		mps.arrowClick(arrClk);
	}
	
	public void goBooking() {
		//System.out.println("goBooking");
		hoon.start();
	}
	
	public void goRRoom() {
		System.out.println("goRRoom");		
	}
	
	public void goSearch() {
		//System.out.println("goSearch");
		wju_b.setId(userID.getText());
		wju_m.setId(userID.getText());
		wju.SearchOpen();
		
	}
}
