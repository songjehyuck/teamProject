package wonjiun.func;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import teamProject.MainPageController;
import wonjiun.DBClass;
import wonjiun.MemberDTO;

public class Member_func {
	private Parent root;
	DBClass db;
	ArrayList<MemberDTO> list;
	public static String id;
	//나중에 여기와 Borrow_func의 아이디값 바꿔야함
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		db = new DBClass();
		list = new ArrayList<MemberDTO>();
		//아이디 비밀번호는 테스트용으로 넣어놓은 임의값임
		
		list = db.LoginMember(id);
		
		Label id = (Label)root.lookup("#id");
		Label borrowList = (Label)root.lookup("#borrowList");
		
		id.setText(list.get(0).getId());
		borrowList.setText(list.get(0).getBr_list());
	}
	
	

}
