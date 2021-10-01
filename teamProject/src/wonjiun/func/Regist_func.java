package wonjiun.func;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import wonjiun.BookDTO;
import wonjiun.DBClass;

public class Regist_func {
	private Parent root;
	DBClass db;
	BookDTO dto;
	Common_func comm;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void RegistBook() {
		//System.out.println("버튼클릭");
		
		dto = new BookDTO();
		db = new DBClass();
		comm = new Common_func();
		
		TextField registName = (TextField)root.lookup("#registName");
		TextField registEng = (TextField)root.lookup("#registEng");
		TextField registWriter = (TextField)root.lookup("#registWriter");
		TextField registAge = (TextField)root.lookup("#registAge");
		
		
		dto.setName(registName.getText());
		dto.setOrigin(registEng.getText());
		dto.setWrite(registWriter.getText());
		
		int to = 0;
		int result = 0;
		//getText로 얻을 수 있는 값은 String 이라서 int로 형변환 필요
		if(registAge.getText() != "") {
			String from = registAge.getText();
			to = Integer.parseInt(from);
			dto.setAge(to);
			result = db.insert(dto);
		}
		
		if(result == 1) {
			comm.AlertFunc("성공적으로 등록되었습니다");
		}else {
			comm.AlertFunc("등록에 실패했습니다");
		}
		
	}
}
