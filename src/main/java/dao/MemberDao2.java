package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MemberDto2;

public class MemberDao2 {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "user0416";
		String dbPw = "pass1234";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
		return conn;
	}
	public ArrayList<MemberDto2> listShow() throws Exception {
		ArrayList<MemberDto2> setList = new ArrayList<MemberDto2>();
		String sql = "SELECT * FROM member1";
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id");
			int pw = rs.getInt("pw");
			String name = rs.getString("name");
			
			MemberDto2 obj = new MemberDto2(id, pw, name);
			setList.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return setList;
	}
}
