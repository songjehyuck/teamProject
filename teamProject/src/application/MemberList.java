package application;

import java.util.ArrayList;
import java.util.List;


public class MemberList {
	
	List<MemberItem> item = new ArrayList<MemberItem>();
	
	MemberList(){
		item.add(new MemberItem("test","test","이세훈",312344,"자바","010-21-32"));		
		item.add(new MemberItem("hoon","hoon","훈",565454,"오전","010-****-****"));
		item.add(new MemberItem("se","se","세",20158131,"4조","010-****-****"));
	}
	
	public List<MemberItem> getCurrentAll() {
		return this.item;
	}
}
