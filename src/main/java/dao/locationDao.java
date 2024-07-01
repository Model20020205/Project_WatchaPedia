package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.locationDto;

public class locationDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<locationDto> locationShow() throws Exception {
		ArrayList<locationDto> extendLocation = new ArrayList<locationDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM locations";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int locationId = rs.getInt("location_id");
			String streetAddress = rs.getString("street_address");
			String postalCode = rs.getString("postal_code");
			String city = rs.getString("city");
			String stateProvince = rs.getString("state_province");
			String countryId = rs.getString("country_id");
			
			locationDto obj = new locationDto(locationId, streetAddress, postalCode, city, stateProvince,
												countryId);
			extendLocation.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return extendLocation;
	}
}
