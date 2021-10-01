package bookbooking;

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
				dto.setappo_list(rs.getString("appo_list"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//대출해간 책의 정보를 Book_Member DB에 저장
	public int modify_brlist(String id, String appo_list) {
		int result = 0;
		String sql = "update book_member set appo_list = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, appo_list);
			ps.setString(2, id);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	public String WhatBorrow(String id) {
		
		String sql = "select * from book_member where id = '" + id + "'";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setappo_list(rs.getString("appo_list"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list.get(0).getappo_list();
	}
	
}
