package dbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bookService.BookDTO;

public class BestSellerDBService {
	public static Connection conn;
	private PreparedStatement ps;

	public BestSellerDBService() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "java4jo", "4444");
			// conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dydgns2446","evan9396");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bsCount(String bName) {

		String sql = "update book_best_seller set count = count+1 where name = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bName);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
//		 finally {
//		      try {
//		        if(ps != null ) ps.close();
//		        if(conn != null ) conn.close();
//		      } catch (SQLException e) { e.printStackTrace(); }
//		    }

	}

	public ArrayList<BookDTO> resultCount() {

		ArrayList<BookDTO> list = new ArrayList<>();
		String sql = "select * from book_best_seller";

		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookDTO nCount = new BookDTO();
				nCount.setbCount(rs.getInt("count"));
				list.add(nCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 finally {
//		      try {
//		        if(ps != null ) ps.close();
//		        if(conn != null ) conn.close();
//		      } catch (SQLException e) { e.printStackTrace(); }
//		    }
		return list;
	}
}
