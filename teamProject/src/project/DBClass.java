package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
	public Connection conn;
	
	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","java4jo","4444");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int modify(String ID,String BOOK_SEAT) {
		int result = 0;
		String sql = "update book_member set BOOK_SEAT = ? where ID = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, BOOK_SEAT);
			ps.setString(2, ID);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
public ArrayList<SeatDTO> usedCheck() {
		
		String sql = "select * from book_member";
		ArrayList<SeatDTO> list = new ArrayList<SeatDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SeatDTO dto = new SeatDTO();
				dto.setBOOK_SEAT(rs.getString("BOOK_SEAT"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
}
