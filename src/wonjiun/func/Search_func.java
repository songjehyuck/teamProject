package wonjiun.func;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import wonjiun.BookDTO;
import wonjiun.DBClass;

public class Search_func {
	private Parent root;
	DBClass db;
	BookDTO dto;
	ListView<String> bookListView;
	ArrayList<BookDTO> list;
	static boolean bool = true;
	
	
	public void setRoot(Parent root) {
		this.root = root;
		bookListView = (ListView)root.lookup("#bookList");
	}
	public void SearchAll() {
		//System.out.println("전체목록버튼 클릭");
		
		db = new DBClass();
		list = db.Search_all();
		getList(list);
		
	}
	
	public void SearchOne() {
		//System.out.println("검색버튼");
		TextField searchName = (TextField)root.lookup("#searchName");
		TextField searchWriter = (TextField)root.lookup("#searchWriter");
		Label information = (Label)root.lookup("#information");
		
		
		String name = searchName.getText();
		String writer = searchWriter.getText();
		
		if(name.equals("") && writer.equals("")) {
			information.setText("항목을 하나 이상 입력해주세요");
		}else {
			information.setText("");
			if(writer.equals("")) {
			//책 제목을 입력한 경우	
				db = new DBClass();
				list = db.Search_name(name);
				getList(list);
				
			}else if(name.equals("")){
			//저자를 입력한경우
				db = new DBClass();
				list = db.Search_writer(writer);
				getList(list);
				
			}else {
			//둘다 입력한 경우	
				db = new DBClass();
				list = db.Search_double(name, writer);
				getList(list);
			}
			
		}
		
	}
	
	//아래에 있는 getList의 맨 아래쪽에 들어가있음
	public void ClickListView(ObservableList<String> bookString) {
		bookListView.setItems(bookString);
		
		if(bool) {
		//아래 코드가 두번 이상 실행되는것을 막기위함
		bool = false;
		bookListView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue)->{
			
			String appo1 = null; 
			String br1 = null;
			Label selectedBook1 = (Label)root.lookup("#selectedBook1");
			Label selectedBook2 = (Label)root.lookup("#selectedBook2");
			//전체보기 -> 리스트뷰 1회 이상 클릭 -> 전체보기 다시 클릭시 동작은 제대로 하나 콘솔창에 오류발생을 해결하기 위해 들어간 if문
			if((int)newValue != -1) {
				if(list.get((int)newValue).getAppo().equals("True")) {
					appo1 = "예약가능";
				}else {
					appo1 = "예약중";
				}
				if(list.get((int)newValue).getBr().equals("True")) {
					br1 = "대출가능";
				}else {
					br1 = "대출중";
				}
				selectedBook1.setText(list.get((int)newValue).getName() + " / " + list.get((int)newValue).getWrite());
				selectedBook2.setText(appo1 + " / " + br1);
			}
		});
		
		
		}
	}
	
	
	public void getList(ArrayList<BookDTO> list) {
		
		Label information = (Label)root.lookup("#information");
		
		this.list = list;
		
		
		ObservableList<String> bookString = FXCollections.observableArrayList();
		
		String appo = null;
		String br = null;
		if(list.size() == 0) {
			information.setText("검색결과가 없습니다");
		}else {
			
			for(int i = 0; i<list.size();i++) {
				if(list.get(i).getAppo().equals("True")) {
					appo = "예약가능";
				}else {
					appo = "예약중";
				}
				
				if(list.get(i).getBr().equals("True")) {
					br = "대출가능";
				}else {
					br = "대출중";
				}
				
				bookString.add(list.get(i).getName() + "   |   " + list.get(i).getOrigin() + "   |   " + list.get(i).getWrite() + "   |   " + list.get(i).getAge() 
						+ "   |   " + appo + "   |   " + br);
				
			}
	
		}
		ClickListView(bookString);
	}
	
	
	
	
	
	
}



