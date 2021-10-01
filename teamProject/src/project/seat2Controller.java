package project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class seat2Controller implements Initializable{
	Parent root;
	DBClass Seat;
	public static String id;
	public void setRoot(Parent root) {
		this.root=root;
		try {
			selectseatb1 = (TextField)root.lookup("#selectseatb1");
			selectseatb1.setText("좌석 선택");
			seat2 = selectseatb1.getText(); 
			b1=(Button)root.lookup("#b1");
			b2=(Button)root.lookup("#b2");
			b3=(Button)root.lookup("#b3");
			b4=(Button)root.lookup("#b4");
			b5=(Button)root.lookup("#b5");
			b6=(Button)root.lookup("#b6");
			b7=(Button)root.lookup("#b7");
			b8=(Button)root.lookup("#b8");
			b9=(Button)root.lookup("#b9");
			b10=(Button)root.lookup("#b10");
			b11=(Button)root.lookup("#b11");
			b12=(Button)root.lookup("#b12");
			b13=(Button)root.lookup("#b13");
			b14=(Button)root.lookup("#b14");
			b15=(Button)root.lookup("#b15");
			b16=(Button)root.lookup("#b16");
			b17=(Button)root.lookup("#b17");
			b18=(Button)root.lookup("#b18");
			b19=(Button)root.lookup("#b19");
			b20=(Button)root.lookup("#b20");
			b21=(Button)root.lookup("#b21");
			b22=(Button)root.lookup("#b22");
			b23=(Button)root.lookup("#b23");
			b24=(Button)root.lookup("#b24");
			for(int i=0; i<10; i++) {
				int set = d1.getarrayvalue1(i);
				if(set==1) b1.setDisable(true); if(set==2) b2.setDisable(true); if(set==3) b3.setDisable(true); if(set==4) b4.setDisable(true);
				if(set==5) b5.setDisable(true); if (set==6) b6.setDisable(true); if(set==7) b7.setDisable(true); if(set==8) b8.setDisable(true);
				if(set==9) b9.setDisable(true); if(set==10) b10.setDisable(true); if(set==11) b11.setDisable(true); if(set==12) b12.setDisable(true);
				if(set==13) b13.setDisable(true); if(set==14) b14.setDisable(true); if(set==15) b15.setDisable(true); if(set==16) b16.setDisable(true);
				if(set==17) b17.setDisable(true); if(set==18) b18.setDisable(true); if(set==19) b19.setDisable(true); if(set==20) b20.setDisable(true);
				if(set==21) b21.setDisable(true); if(set==22) b22.setDisable(true); if(set==23) b23.setDisable(true); if(set==24) b24.setDisable(true);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	public void setId(String id) {
		this.id=id;
	}
	Button btnBack;
	Button gofrom2to1;
	Button gofrom2to3;
	Button goselectRoom;
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15 ,b16 ,b17, b18, b19, b20, b21, b22, b23, b24;
	TextField selectseatb1;
	Button exit;
	Button done;
	static String seat2;
	String getseat2() {
		return seat2;
	}
	static int people;
	dup1 d1 = new dup1();
	@Override
	public void initialize(URL location, ResourceBundle resources){
		DBClass Seat = new DBClass();
		ArrayList<SeatDTO> dto = new ArrayList<SeatDTO>();
		dto = Seat.usedCheck();
		String str = null;
		
		for(int i=0; i<dto.size(); i++) {
			str=dto.get(i).getBOOK_SEAT();
			
			if(str.equals("2-1")) {
				b1.setDisable(true);
			}
			if(str.equals("2-2")) {
				b2.setDisable(true);
			}
			if(str.equals("2-3")) {
				b3.setDisable(true);
			}
			if(str.equals("2-4")) {
				b4.setDisable(true);
			}
			if(str.equals("2-5")) {
				b5.setDisable(true);
			}
			if(str.equals("2-6")) {
				b6.setDisable(true);
			}
			if(str.equals("2-7")) {
				b7.setDisable(true);
			}
			if(str.equals("2-8")) {
				b8.setDisable(true);
			}
			if(str.equals("2-9")) {
				b9.setDisable(true);
			}
			if(str.equals("2-10")) {
				b10.setDisable(true);
			}
			if(str.equals("2-11")) {
				b11.setDisable(true);
			}
			if(str.equals("2-12")) {
				b12.setDisable(true);
			}
			if(str.equals("2-13")) {
				b13.setDisable(true);
			}
			if(str.equals("2-14")) {
				b14.setDisable(true);
			}
			if(str.equals("2-15")) {
				b15.setDisable(true);
			}
			if(str.equals("2-16")) {
				b16.setDisable(true);
			}
			if(str.equals("2-17")) {
				b17.setDisable(true);
			}
			if(str.equals("2-18")) {
				b18.setDisable(true);
			}
			if(str.equals("2-19")) {
				b19.setDisable(true);
			}
			if(str.equals("2-20")) {
				b20.setDisable(true);
			}
			if(str.equals("2-21")) {
				b21.setDisable(true);
			}
			if(str.equals("2-22")) {
				b22.setDisable(true);
			}
			if(str.equals("2-23")) {
				b23.setDisable(true);
			}
			if(str.equals("2-24")) {
				b24.setDisable(true);
			}
		}
		
		
	}
		public void handleb1(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 1번 좌석 선택");
			alert.show();
			b1=((Button)event.getSource());
			b1.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-1");
			
		}

		public void handleb2(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 2번 좌석 선택");
			alert.show();
			b2=((Button)event.getSource());
			b2.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-2");
		}
		public void handleb3(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 3번 좌석 선택");
			alert.show();
			b3=((Button)event.getSource());
			b3.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-3");
			}
		public void handleb4(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 4번 좌석 선택");
			alert.show();
			b4=((Button)event.getSource());
			b4.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-4");
			}
		public void handleb5(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 5번 좌석 선택");
			alert.show();
			b5=((Button)event.getSource());
			b5.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-5");
			}
		public void handleb6(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 6번 좌석 선택");
			alert.show();
			b6=((Button)event.getSource());
			b6.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-6");
			}
		public void handleb7(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 7번 좌석 선택");
			alert.show();
			b7=((Button)event.getSource());
			b7.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-7");
			}
		public void handleb8(ActionEvent event) {	
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 8번 좌석 선택");
			alert.show();
			b8=((Button)event.getSource());
			b8.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-8");
			}
		public void handleb9(ActionEvent event) {	
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 9번 좌석 선택");
			alert.show();
			b9=((Button)event.getSource());
			b9.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-9");
			}
		public void handleb10(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 10번 좌석 선택");
			alert.show();
			b10=((Button)event.getSource());
			b10.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-10");
			}
		public void handleb11(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 11번 좌석 선택");
			alert.show();
			b11=((Button)event.getSource());
			b11.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-11");
			}
		public void handleb12(ActionEvent event) {	
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 12번 좌석 선택");
			alert.show();
			b12=((Button)event.getSource());
			b12.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-12");
			}
		public void handleb13(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 13번 좌석 선택");
			alert.show();
			b13=((Button)event.getSource());
			b13.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-13");
			}
		public void handleb14(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 14번 좌석 선택");
			alert.show();
			b14=((Button)event.getSource());
			b14.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-14");
			}
		public void handleb15(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 15번 좌석 선택");
			alert.show();
			b15=((Button)event.getSource());
			b15.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-15");
			}
		public void handleb16(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 16번 좌석 선택");
			alert.show();
			b16=((Button)event.getSource());
			b16.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-16");
			}
		public void handleb17(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 17번 좌석 선택");
			alert.show();
			b17=((Button)event.getSource());
			b17.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-17");
			}
		public void handleb18(ActionEvent event) {	
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 18번 좌석 선택");
			alert.show();
			b18=((Button)event.getSource());
			b18.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-18");
			}
		public void handleb19(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 19번 좌석 선택");
			alert.show();
			b19=((Button)event.getSource());
			b19.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-19");
			}
		public void handleb20(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 20번 좌석 선택");
			alert.show();
			b20=((Button)event.getSource());
			b20.setDisable(true); 
			Seat= new DBClass();
			Seat.modify(id, "2-20");
			}
		public void handleb21(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 21번 좌석 선택");
			alert.show();
			b21=((Button)event.getSource());
			b21.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-21");
			}
		public void handleb22(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 22번 좌석 선택");
			alert.show();
			b22=((Button)event.getSource());
			b22.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-22");
			}
		public void handleb23(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 23번 좌석 선택");
			alert.show();
			b23=((Button)event.getSource());
			b23.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-23");
			}
		public void handleb24(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("2호실 24번 좌석 선택");
			alert.show();
			b24=((Button)event.getSource());
			b24.setDisable(true);
			Seat= new DBClass();
			Seat.modify(id, "2-24");
			}
	
		public void goselectRoom(ActionEvent event) {
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
		
		public void done(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("메시지");
			alert.setContentText("사용 시작");
			alert.show();
		}
		
		public void exit(ActionEvent event) {
			Platform.exit();
		}
	}
