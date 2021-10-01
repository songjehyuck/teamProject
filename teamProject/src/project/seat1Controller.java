package project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class seat1Controller implements Initializable{
	Parent root;
	DBClass Seat;
	public static String id;
	public void setRoot(Parent root) {
		this.root=root;
		try {
			selectseata1 = (TextField)root.lookup("#selectseata1");
			selectseata1.setText("좌석 선택");
			seat1 = selectseata1.getText(); 
			a1=(Button)root.lookup("#a1");
			a2=(Button)root.lookup("#a2");
			a3=(Button)root.lookup("#a3");
			a4=(Button)root.lookup("#a4");
			a5=(Button)root.lookup("#a5");
			a6=(Button)root.lookup("#a6");
			a7=(Button)root.lookup("#a7");
			a8=(Button)root.lookup("#a8");
			a9=(Button)root.lookup("#a9");
			a10=(Button)root.lookup("#a10");
			a11=(Button)root.lookup("#a11");
			a12=(Button)root.lookup("#a12");
			a13=(Button)root.lookup("#a13");
			a14=(Button)root.lookup("#a14");
			a15=(Button)root.lookup("#a15");
			a16=(Button)root.lookup("#a16");
			a17=(Button)root.lookup("#a17");
			a18=(Button)root.lookup("#a18");
			a19=(Button)root.lookup("#a19");
			a20=(Button)root.lookup("#a20");
			a21=(Button)root.lookup("#a21");
			a22=(Button)root.lookup("#a22");
			a23=(Button)root.lookup("#a23");
			a24=(Button)root.lookup("#a24");
			for(int i=0; i<10; i++) {
				int set = d1.getarrayvalue1(i);
				if(set==1) a1.setDisable(true); if(set==2) a2.setDisable(true); if(set==3) a3.setDisable(true); if(set==4) a4.setDisable(true);
				if(set==5) a5.setDisable(true); if (set==6) a6.setDisable(true); if(set==7) a7.setDisable(true); if(set==8) a8.setDisable(true);
				if(set==9) a9.setDisable(true); if(set==10) a10.setDisable(true); if(set==11) a11.setDisable(true); if(set==12) a12.setDisable(true);
				if(set==13) a13.setDisable(true); if(set==14) a14.setDisable(true); if(set==15) a15.setDisable(true); if(set==16) a16.setDisable(true);
				if(set==17) a17.setDisable(true); if(set==18) a18.setDisable(true); if(set==19) a19.setDisable(true); if(set==20) a20.setDisable(true);
				if(set==21) a21.setDisable(true); if(set==22) a22.setDisable(true); if(set==23) a23.setDisable(true); if(set==24) a24.setDisable(true);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	public void setId(String id) {
		this.id=id;
	}

	@FXML private Button btnBack;
	@FXML private Button gofrom1to2;
	@FXML private Button gofrom1to3;
	@FXML private Button goselectRoom;
	@FXML private Button a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 ,a16 ,a17, a18, a19, a20, a21, a22, a23, a24;
	@FXML private TextField selectseata1;
	@FXML private Button exit;
	@FXML private Button done;
	static int people;
	static String seat1;
	String getseat1() {
		return seat1;
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
			
			if(str.equals("1-1")) {
				a1.setDisable(true);
			}
			if(str.equals("1-2")) {
				a2.setDisable(true);
			}
			if(str.equals("1-3")) {
				a3.setDisable(true);
			}
			if(str.equals("1-4")) {
				a4.setDisable(true);
			}
			if(str.equals("1-5")) {
				a5.setDisable(true);
			}
			if(str.equals("1-6")) {
				a6.setDisable(true);
			}
			if(str.equals("1-7")) {
				a7.setDisable(true);
			}
			if(str.equals("1-8")) {
				a8.setDisable(true);
			}
			if(str.equals("1-9")) {
				a9.setDisable(true);
			}
			if(str.equals("1-10")) {
				a10.setDisable(true);
			}
			if(str.equals("1-11")) {
				a11.setDisable(true);
			}
			if(str.equals("1-12")) {
				a12.setDisable(true);
			}
			if(str.equals("1-13")) {
				a13.setDisable(true);
			}
			if(str.equals("1-14")) {
				a14.setDisable(true);
			}
			if(str.equals("1-15")) {
				a15.setDisable(true);
			}
			if(str.equals("1-16")) {
				a16.setDisable(true);
			}
			if(str.equals("1-17")) {
				a17.setDisable(true);
			}
			if(str.equals("1-18")) {
				a18.setDisable(true);
			}
			if(str.equals("1-19")) {
				a19.setDisable(true);
			}
			if(str.equals("1-20")) {
				a20.setDisable(true);
			}
			if(str.equals("1-21")) {
				a21.setDisable(true);
			}
			if(str.equals("1-22")) {
				a22.setDisable(true);
			}
			if(str.equals("1-23")) {
				a23.setDisable(true);
			}
			if(str.equals("1-24")) {
				a24.setDisable(true);
			}
		}
		
		
	}
	
	public void handlea1(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 1번 좌석 선택");
		alert.show();
		a1=((Button)event.getSource());
		a1.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "1-1");
	}

	public void handlea2(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 2번 좌석 선택");
		alert.show();
		a2=((Button)event.getSource());
		a2.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "1-2");
	}
	public void handlea3(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 3번 좌석 선택");
		alert.show();
		a3=((Button)event.getSource());
		a3.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-3");
		}
	public void handlea4(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 4번 좌석 선택");
		alert.show();
		a4=((Button)event.getSource());
		a4.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-4");
		}
	public void handlea5(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 5번 좌석 선택");
		alert.show();
		a5=((Button)event.getSource());
		a5.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-5");
		}
	public void handlea6(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 6번 좌석 선택");
		alert.show();
		a6=((Button)event.getSource());
		a6.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-6");
		}
	public void handlea7(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 7번 좌석 선택");
		alert.show();
		a7=((Button)event.getSource());
		a7.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-7");
		}
	public void handlea8(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 8번 좌석 선택");
		alert.show();
		a8=((Button)event.getSource());
		a8.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-8");
		}
	public void handlea9(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 9번 좌석 선택");
		alert.show();
		a9=((Button)event.getSource());
		a9.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-9");
		}
	public void handlea10(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 10번 좌석 선택");
		alert.show();
		a10=((Button)event.getSource());
		a10.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-10");
		}
	public void handlea11(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 11번 좌석 선택");
		alert.show();
		a11=((Button)event.getSource());
		a11.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-11");
		}
	public void handlea12(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 12번 좌석 선택");
		alert.show();
		a12=((Button)event.getSource());
		a12.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-12");
		}
	public void handlea13(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 13번 좌석 선택");
		alert.show();
		a13=((Button)event.getSource());
		a13.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-13");
		}
	public void handlea14(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 14번 좌석 선택");
		alert.show();
		a14=((Button)event.getSource());
		a14.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-14");
		}
	public void handlea15(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 15번 좌석 선택");
		alert.show();
		a15=((Button)event.getSource());
		a15.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-15");
		}
	public void handlea16(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 16번 좌석 선택");
		alert.show();
		a16=((Button)event.getSource());
		a16.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-16");
		}
	public void handlea17(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 17번 좌석 선택");
		alert.show();
		a17=((Button)event.getSource());
		a17.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-17");
		}
	public void handlea18(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 18번 좌석 선택");
		alert.show();
		a18=((Button)event.getSource());
		a18.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-18");
		}
	public void handlea19(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 19번 좌석 선택");
		alert.show();
		a19=((Button)event.getSource());
		a19.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-19");
		}
	public void handlea20(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 20번 좌석 선택");
		alert.show();
		a20=((Button)event.getSource());
		a20.setDisable(true); 
		Seat= new DBClass();
		Seat.modify(id, "1-20");
		}
	public void handlea21(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 21번 좌석 선택");
		alert.show();
		a21=((Button)event.getSource());
		a21.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "1-21");
		}
	public void handlea22(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 22번 좌석 선택");
		alert.show();
		a22=((Button)event.getSource());
		a22.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "1-22");
		}
	public void handlea23(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 23번 좌석 선택");
		alert.show();
		a23=((Button)event.getSource());
		a23.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "1-23");
		}
	public void handlea24(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메시지");
		alert.setContentText("1호실 24번 좌석 선택");
		alert.show();
		a24=((Button)event.getSource());
		a24.setDisable(true);
		Seat= new DBClass();
		Seat.modify(id, "1-24");
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
