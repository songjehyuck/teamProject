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

public class seat3Controller implements Initializable{
	Parent root;
	DBClass Seat;
	public static String id;
	public void setRoot(Parent root) {
		this.root=root;
		try {
			selectseatc1 = (TextField)root.lookup("#selectseatc1");
			selectseatc1.setText("좌석 선택");
			seat3 = selectseatc1.getText(); 
			c1=(Button)root.lookup("#c1");
			c2=(Button)root.lookup("#c2");
			c3=(Button)root.lookup("#c3");
			c4=(Button)root.lookup("#c4");
			c5=(Button)root.lookup("#c5");
			c6=(Button)root.lookup("#c6");
			c7=(Button)root.lookup("#c7");
			c8=(Button)root.lookup("#c8");
			c9=(Button)root.lookup("#c9");
			c10=(Button)root.lookup("#c10");
			c11=(Button)root.lookup("#c11");
			c12=(Button)root.lookup("#c12");
			c13=(Button)root.lookup("#c13");
			c14=(Button)root.lookup("#c14");
			c15=(Button)root.lookup("#c15");
			c16=(Button)root.lookup("#c16");
			c17=(Button)root.lookup("#c17");
			c18=(Button)root.lookup("#c18");
			c19=(Button)root.lookup("#c19");
			c20=(Button)root.lookup("#c20");
			c21=(Button)root.lookup("#c21");
			c22=(Button)root.lookup("#c22");
			c23=(Button)root.lookup("#c23");
			c24=(Button)root.lookup("#c24");
			for(int i=0; i<10; i++) {
				int set = d1.getarrayvalue1(i);
				if(set==1) c1.setDisable(true); if(set==2) c2.setDisable(true); if(set==3) c3.setDisable(true); if(set==4) c4.setDisable(true);
				if(set==5) c5.setDisable(true); if (set==6) c6.setDisable(true); if(set==7) c7.setDisable(true); if(set==8) c8.setDisable(true);
				if(set==9) c9.setDisable(true); if(set==10) c10.setDisable(true); if(set==11) c11.setDisable(true); if(set==12) c12.setDisable(true);
				if(set==13) c13.setDisable(true); if(set==14) c14.setDisable(true); if(set==15) c15.setDisable(true); if(set==16) c16.setDisable(true);
				if(set==17) c17.setDisable(true); if(set==18) c18.setDisable(true); if(set==19) c19.setDisable(true); if(set==20) c20.setDisable(true);
				if(set==21) c21.setDisable(true); if(set==22) c22.setDisable(true); if(set==23) c23.setDisable(true); if(set==24) c24.setDisable(true);
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
	Button gofrom3to1;
	Button gofrom3to2;
	Button goselectRoom;
	Button c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15 ,c16 ,c17, c18, c19, c20, c21, c22, c23, c24;
	TextField selectseatc1;
	Button exit;
	Button done;
	static int people;
	static String seat3;
	String getseat3() {
		return seat3;
	}
	dup1 d1 = new dup1();
	@Override
	public void initialize(URL location, ResourceBundle resources){
		DBClass Seat = new DBClass();
		ArrayList<SeatDTO> dto = new ArrayList<SeatDTO>();
		dto = Seat.usedCheck();
		String str = null;
		
		for(int i=0; i<dto.size(); i++) {
			str=dto.get(i).getBOOK_SEAT();
			
			if(str.equals("3-1")) {
				c1.setDisable(true);
			}
			if(str.equals("3-2")) {
				c2.setDisable(true);
			}
			if(str.equals("3-3")) {
				c3.setDisable(true);
			}
			if(str.equals("3-4")) {
				c4.setDisable(true);
			}
			if(str.equals("3-5")) {
				c5.setDisable(true);
			}
			if(str.equals("3-6")) {
				c6.setDisable(true);
			}
			if(str.equals("3-7")) {
				c7.setDisable(true);
			}
			if(str.equals("3-8")) {
				c8.setDisable(true);
			}
			if(str.equals("3-9")) {
				c9.setDisable(true);
			}
			if(str.equals("3-10")) {
				c10.setDisable(true);
			}
			if(str.equals("3-11")) {
				c11.setDisable(true);
			}
			if(str.equals("3-12")) {
				c12.setDisable(true);
			}
			if(str.equals("3-13")) {
				c13.setDisable(true);
			}
			if(str.equals("3-14")) {
				c14.setDisable(true);
			}
			if(str.equals("3-15")) {
				c15.setDisable(true);
			}
			if(str.equals("3-16")) {
				c16.setDisable(true);
			}
			if(str.equals("3-17")) {
				c17.setDisable(true);
			}
			if(str.equals("3-18")) {
				c18.setDisable(true);
			}
			if(str.equals("3-19")) {
				c19.setDisable(true);
			}
			if(str.equals("3-20")) {
				c20.setDisable(true);
			}
			if(str.equals("3-21")) {
				c21.setDisable(true);
			}
			if(str.equals("3-22")) {
				c22.setDisable(true);
			}
			if(str.equals("3-23")) {
				c23.setDisable(true);
			}
			if(str.equals("3-24")) {
				c24.setDisable(true);
			}
		}
		
	}
	public void handlec1(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 1번 좌석 선택");
		alert.show();
		c1=((Button)event.getSource());
		c1.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-1");
		
	}

	public void handlec2(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 2번 좌석 선택");
		alert.show();
		c2=((Button)event.getSource());
		c2.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "3-2");
	}
	public void handlec3(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 3번 좌석 선택");
		alert.show();
		c3=((Button)event.getSource());
		c3.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-3");
		}
	public void handlec4(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 4번 좌석 선택");
		alert.show();
		c4=((Button)event.getSource());
		c4.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-4");
		}
	public void handlec5(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 5번 좌석 선택");
		alert.show();
		c5=((Button)event.getSource());
		c5.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-5");
		}
	public void handlec6(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 6번 좌석 선택");
		alert.show();
		c6=((Button)event.getSource());
		c6.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-6");
		}
	public void handlec7(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 7번 좌석 선택");
		alert.show();
		c7=((Button)event.getSource());
		c7.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-7");
		}
	public void handlec8(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 8번 좌석 선택");
		alert.show();
		c8=((Button)event.getSource());
		c8.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-8");
		}
	public void handlec9(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 9번 좌석 선택");
		alert.show();
		c9=((Button)event.getSource());
		c9.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-9");
		}
	public void handlec10(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 10번 좌석 선택");
		alert.show();
		c10=((Button)event.getSource());
		c10.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-10");
		}
	public void handlec11(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 11번 좌석 선택");
		alert.show();
		c11=((Button)event.getSource());
		c11.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "3-11");
		}
	public void handlec12(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 12번 좌석 선택");
		alert.show();
		c12=((Button)event.getSource());
		c12.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-12");
		}
	public void handlec13(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 13번 좌석 선택");
		alert.show();
		c13=((Button)event.getSource());
		c13.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-13");
		}
	public void handlec14(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 14번 좌석 선택");
		alert.show();
		c14=((Button)event.getSource());
		c14.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-14");
		}
	public void handlec15(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 15번 좌석 선택");
		alert.show();
		c15=((Button)event.getSource());
		c15.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-15");
		}
	public void handlec16(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 16번 좌석 선택");
		alert.show();
		c16=((Button)event.getSource());
		c16.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-16");
		}
	public void handlec17(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 17번 좌석 선택");
		alert.show();
		c17=((Button)event.getSource());
		c17.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-17");
		}
	public void handlec18(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 18번 좌석 선택");
		alert.show();
		c18=((Button)event.getSource());
		c18.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-18");
		}
	public void handlec19(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 19번 좌석 선택");
		alert.show();
		c19=((Button)event.getSource());
		c19.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-19");
		}
	public void handlec20(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 20번 좌석 선택");
		alert.show();
		c20=((Button)event.getSource());
		c20.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "3-20");
		}
	public void handlec21(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 21번 좌석 선택");
		alert.show();
		c21=((Button)event.getSource());
		c21.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "3-21");
		}
	public void handlec22(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 22번 좌석 선택");
		alert.show();
		c22=((Button)event.getSource());
		c22.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "3-22");
		}
	public void handlec23(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 23번 좌석 선택");
		alert.show();
		c23=((Button)event.getSource());
		c23.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "3-23");
		}
	public void handlec24(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("3호실 24번 좌석 선택");
		alert.show();
		c24=((Button)event.getSource());
		c24.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "3-24");
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
