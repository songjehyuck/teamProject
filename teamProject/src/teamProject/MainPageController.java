package teamProject;

import java.net.URL;
import java.util.ResourceBundle;

import bookbooking.Main;
import commonService.CommonServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import project.MainClass1;
import project.seat1Controller;
import project.seat2Controller;
import project.seat3Controller;
import wonjiun.MainClass;
import wonjiun.func.Borrow_func;
import wonjiun.func.Member_func;

public class MainPageController implements Initializable {
	Parent root;
	MainPageService mps;
	Label userID;
	CommonServiceImpl cs;
	int arrClk;
	int voteCK = 0;
	MainClass wju = new MainClass();
	Borrow_func wju_b;
	Member_func wju_m;
	Main hoon = new Main();
	MainClass1 jehyuck = new MainClass1();
	seat1Controller sjh1;
	seat2Controller sjh2;
	seat3Controller sjh3;

	public void setRoot(Parent root) {
		this.root = root;
		mps.setRoot(root);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mps = new MainPageService();
		userID = new Label();
		cs = new CommonServiceImpl();
		wju_b = new Borrow_func();
		wju_m = new Member_func();
		sjh1= new seat1Controller();
		sjh2= new seat2Controller();
		sjh3= new seat3Controller();

	}

	public void userIdViewer(String userId) {
		userID = (Label) root.lookup("#userIdViewer");
		userID.setText(userId);
	}

	public void arrowLeft() {
		arrClk = 0;
		mps.arrowClick(arrClk);

	}

	public void arrowRight() {
		arrClk = 1;
		mps.arrowClick(arrClk);
	}

	// ================팀원 기능 연결
	public void goBooking() {
		hoon.start();
	}

	public void goRRoom() {
		sjh1.setId(userID.getText());
		sjh2.setId(userID.getText());
		sjh3.setId(userID.getText());
		jehyuck.start();
	}

	public void goSearch() {
		wju_b.setId(userID.getText());
		wju_m.setId(userID.getText());
		wju.SearchOpen();
	}
	//// =============================

	public void vote() {
		if (voteCK == 0 && mps.bookNum != 0) {
			mps.voted();
			voteCK = 1;
		} else if (mps.bookNum == 0) {
			cs.alert("화살표를 누르면 추천 도서들을 보실 수 있습니다", "책을 먼저 골라 주세요");
		} else {
			cs.alert("한 권의 책에만 투표를 하실 수 있습니다", "이미 투표 하셨습니다");
		}

	}
}
