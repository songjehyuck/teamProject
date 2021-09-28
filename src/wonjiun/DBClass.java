package wonjiun;

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
	
	public int insert(BookDTO dto) {
		String sql = "insert into book(name,origin,write,age,appo,br) values(?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getOrigin());
			ps.setString(3, dto.getWrite());
			ps.setInt(4, dto.getAge());
			ps.setString(5, "True");
			ps.setString(6, "True");
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<BookDTO> Search_all() {
		
		String sql = "select * from book";
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setName(rs.getString("name"));
				dto.setOrigin(rs.getString("origin"));
				dto.setWrite(rs.getString("write"));
				dto.setAge(rs.getInt("age"));
				dto.setAppo(rs.getString("appo"));
				dto.setBr(rs.getString("br"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public int modify(String name, String write, String br) {
		int result = 0;
		String sql = "update book set br = ? where name = ? and write = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, br);
			ps.setString(2, name);
			ps.setString(3, write);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public ArrayList<BookDTO> Search_name(String name) {
		
		String sql = "select * from book where name like '%" + name + "%'";
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setName(rs.getString("name"));
				dto.setOrigin(rs.getString("origin"));
				dto.setWrite(rs.getString("write"));
				dto.setAge(rs.getInt("age"));
				dto.setAppo(rs.getString("appo"));
				dto.setBr(rs.getString("br"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<BookDTO> Search_writer(String writer) {
		
		String sql = "select * from book where write like '%" + writer + "%'";
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setName(rs.getString("name"));
				dto.setOrigin(rs.getString("origin"));
				dto.setWrite(rs.getString("write"));
				dto.setAge(rs.getInt("age"));
				dto.setAppo(rs.getString("appo"));
				dto.setBr(rs.getString("br"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<BookDTO> Search_double(String name, String writer) {
		
		String sql = "select * from book where (name like '%" + name + "%' and write like '%" + writer + "%')";
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setName(rs.getString("name"));
				dto.setOrigin(rs.getString("origin"));
				dto.setWrite(rs.getString("write"));
				dto.setAge(rs.getInt("age"));
				dto.setAppo(rs.getString("appo"));
				dto.setBr(rs.getString("br"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//매개변수의 id, pwd를 이용해 로그인한 사람의 정보를 가져옴
	public ArrayList<MemberDTO> LoginMember(String id) {
		
		String sql = "select * from book_member where id = '" + id + "'";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setBr_list(rs.getString("br_list"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//대출해간 책의 정보를 Book_Member DB에 저장
	public int modify_brlist(String id, String br_list) {
		int result = 0;
		String sql = "update book_member set br_list = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, br_list);
			ps.setString(2, id);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	public String CanBorrow(String name) {
		
		String sql = "select * from book where name = '" + name + "'";
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBr(rs.getString("br"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list.get(0).getBr();
	}
	public String WhatBorrow(String id) {
		
		String sql = "select * from book_member where id = '" + id + "'";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setBr_list(rs.getString("br_list"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list.get(0).getBr_list();
	}
	
}
