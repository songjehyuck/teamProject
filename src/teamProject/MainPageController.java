package teamProject;

import java.net.URL;
import java.util.ResourceBundle;
import commonService.CommonServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class MainPageController implements Initializable {
	Parent root;
	MainPageService mps;
	Label userID;
	CommonServiceImpl cs;
	int arrClk;
	int voteCK = 0;

	public void setRoot(Parent root) {
		this.root = root;
		mps.setRoot(root);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mps = new MainPageService();
		userID = new Label();
		cs = new CommonServiceImpl();

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
		System.out.println("goBooking");
	}

	public void goRRoom() {
		System.out.println("goRRoom");
	}

	public void goSearch() {
		System.out.println("goSearch");
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
