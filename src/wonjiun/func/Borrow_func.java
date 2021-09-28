package wonjiun.func;


import javafx.scene.Parent;
import javafx.scene.control.Label;
import wonjiun.DBClass;


public class Borrow_func {
	private Parent root;
	Search_func search_func;
	DBClass db;
	String borrowBookName;
	public static String id;
	//나중에 여기와 Member_func의 아이디값 바꿔야함
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void BorrowBook() {
		db = new DBClass();
		Label selectedBook1 = (Label)root.lookup("#selectedBook1");
		Label selectedBook2 = (Label)root.lookup("#selectedBook2");
		Label information = (Label)root.lookup("#information");
		Label borrowList = (Label)root.lookup("#borrowList");
		
		if(selectedBook1.getText().equals("")) {
			information.setText("목록에서 책을 선택해주세요");
		}else {
		
			String[] split1 = selectedBook1.getText().split(" / ");
			String[] split2 = selectedBook2.getText().split(" / ");
			borrowBookName = borrowList.getText();
			String TorF = db.CanBorrow(split1[0]);
			String whatBr = db.WhatBorrow(id);
			
			//인포메이션 텍스트 설정. 한번에 책 1개만 대출할 수 있도록 설정함
			//book 데이터베이스의 대출가능여부 값이 True이고 계정의 빌린책 목록이 null값인 경우 
			if(TorF.equals("True") && whatBr == null) {
				//book 데이터베이스의 대출 항목 False로 변경
				int result = db.modify(split1[0], split1[1], "False");
				if(result == 1) {
					information.setText("< " + selectedBook1.getText() + " > 대출되었습니다");
					//member 데이터베이스의 br_list에 대출한 책 이름 작성
					db.modify_brlist(id, selectedBook1.getText());
					borrowList.setText(split1[0] + " / " + split1[1]);
				}
				selectedBook2.setText(split2[0] + " / 대출중");
			}else {
					if(whatBr != null) {
						//빌린 책 목록이 이미 한권 있는 경우
						information.setText("한 번에 한 권씩만 대출할 수 있습니다");
					}else {
						//db의 대출가능여부 값이 False인 경우
						information.setText("대출불가!");
					
					}
			}
		}
		
		
		
	
	}
	public void ReturnBook() {
		db = new DBClass();
		Label selectedBook1 = (Label)root.lookup("#selectedBook1");
		Label selectedBook2 = (Label)root.lookup("#selectedBook2");
		Label information = (Label)root.lookup("#information");
		Label borrowList = (Label)root.lookup("#borrowList"); //계정의 빌려간 책 목록
		borrowBookName = borrowList.getText();
		
		
		if(selectedBook1.getText().equals("")) {
			//선택하지 않고 반납버튼을 눌렀을 경우
			information.setText("목록에서 책을 선택해주세요");
		}else if(borrowBookName != null) {
		//계정의 br항목이 null이 아닌경우 = 빌려간 책이 있는경우
			String[] split1 = selectedBook1.getText().split(" / ");
			String[] split2 = selectedBook2.getText().split(" / ");
			String TorF = db.CanBorrow(split1[0]);
			String whatBr = db.WhatBorrow(id);
			
			
			//인포메이션 텍스트 설정
			//book 데이터베이스의 대출가능여부 값이 True인 경우 = 아무도 대출해가지 않은 책을 반납버튼 누른 경우 
			if(TorF.equals("True")) {
				information.setText("이미 반납된 책입니다");
			}else { //book db의 br항목이 false인 경우, 이 계정이 빌려간 책과 현재 선택한 책이 일치하는지 검사
				if(whatBr.equals(split1[0] + " / " + split1[1])) {
					
					int result = db.modify(split1[0], split1[1], "True");
					if(result == 1) {
						db.modify_brlist(id, "");
						borrowList.setText(null);
						borrowBookName = null;
						
						information.setText("< " + selectedBook1.getText() + " > 반납되었습니다");
						selectedBook2.setText(split2[0] + " / 대출가능");
					}
				}else {
					information.setText("다른 사람이 대출해간 책입니다");
				}
			}
		}else {
			information.setText("빌린 책이 없습니다");
		}
		
	}
	//로그인파트 완성 후, 대출한 사람과 반납한 사람 관련 추가작업 필요
	//내가 빌린책이 아닌데 반납버튼 누르면 데이터베이스가 수정되는 오류있음
}
