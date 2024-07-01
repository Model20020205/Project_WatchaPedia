package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.customerDto;

public class customerDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<customerDto> customerShow() throws Exception {
		ArrayList<customerDto> customerList = new ArrayList<customerDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM customer_member";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int mmIdx = rs.getInt("mm_idx");
			String name = rs.getString("NAME");
			String email = rs.getString("EMAIL");
			int password = rs.getInt("PASSWORD");
			int storeIdx = rs.getInt("store_idx");
			String address = rs.getString("ADDRESS");
			
			customerDto obj2 = new customerDto(mmIdx, name, email, password, storeIdx, address);
			customerList.add(obj2);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return customerList;
	}
}
