package wonjiun;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import wonjiun.func.Borrow_func;
import wonjiun.func.Common_func;
import wonjiun.func.Member_func;
import wonjiun.func.Regist_func;
import wonjiun.func.Search_func;

public class Controller implements Initializable {
	private Parent root;
	public static DBClass db;
	Search_func search_func;
	Regist_func regist_func;
	Borrow_func borrow_func;
	Common_func common_func;
	Member_func member_func;
	
	public void setRoot(Parent root) {
		this.root = root;
		search_func.setRoot(root);
		regist_func.setRoot(root);
		borrow_func.setRoot(root);
		common_func.setRoot(root);
		member_func.setRoot(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		search_func = new Search_func();
		regist_func = new Regist_func();
		borrow_func = new Borrow_func();
		common_func = new Common_func();
		member_func = new Member_func();
	}
	public void SearchAll() {
		//전체목록버튼 클릭
		search_func.SearchAll();
	}
	public void RegistBook() {
		//새 책 등록하기
		regist_func.RegistBook();
	}
	public void SearchOne() {
		//검색버튼 클릭
		search_func.SearchOne();
	}
	public void BorrowBook() {
		//대출하기 버튼 클릭
		borrow_func.BorrowBook();
	}
	public void ReturnBook() {
		//반납하기 버튼 클릭
		borrow_func.ReturnBook();
	}
	public void Close() {
		common_func.Close();
	}

}
