package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
// [로고 삭제]
public class LogoDeleteDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	void deleteLogo(int slidx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE preferences SET logo = null"
					+ " WHERE store_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, slidx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 로고 선택 : ");
		int slidx = sc.nextInt();
		LogoDeleteDao obj = new LogoDeleteDao();
		obj.deleteLogo(slidx);
	}
}
