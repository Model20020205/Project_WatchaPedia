package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.chatDto;
import dto.preferencesDto;

public class preferencesDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<preferencesDto> showPreferences() throws Exception {
		ArrayList<preferencesDto> showShop = new ArrayList<preferencesDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM preferences";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int storeIdx = rs.getInt("store_idx");
			String storeName = rs.getString("store_name");
			String storeEmail = rs.getString("store_email");
			int logo = rs.getInt("logo");
			int userIdx = rs.getInt("user_idx");
			preferencesDto obj = new preferencesDto(storeIdx, storeName, storeEmail, logo, userIdx);
			showShop.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return showShop;
	}
}
