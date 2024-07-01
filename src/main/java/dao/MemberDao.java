package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	// getConnection() : Connection 객체를 리턴.
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "user0416";
		String dbPw = "pass1234";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
		return conn;
	}
	
	public boolean loginCheck(String id, String pw) throws Exception {
		Connection conn = getConnection();
		
		// "SELECT COUNT(*) FROM member WHERE id=? AND pw=?"
		String sql = "SELECT COUNT(*) FROM member1 WHERE id=? AND pw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		
		int result = 0;
		if(rs.next()) {
			result = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result==1;
	}

	public void registerMember(String id, String pw, String name) throws Exception {
		Connection conn = getConnection();
		String sql = "INSERT INTO member1(id, pw, name) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}