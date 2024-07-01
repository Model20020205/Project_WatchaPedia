package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
// [프로필 편집] : 프로필 편집
public class ProfileEditDao {
	public Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	void profileEditDao(String storeName, String storeNumber, String storeEmail, int storeIdx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE preferences SET store_name = ?,"
					+ "store_number = ?, store_email = ? WHERE store_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, storeName);
		pstmt.setString(2, storeNumber);
		pstmt.setString(3, storeEmail);
		pstmt.setInt(4, storeIdx);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("<< 프로필 편집 >>");
		System.out.print("<< 스토어 이름 입력 >>");
		String storeName = sc.next();	// 스토어 이름 입력
		System.out.print("<< 스토어 전화번호 입력 >>");
		String storeNumber = sc.next();	// 스토어 전화번호 입력
		System.out.print("<< 스토어 이메일 입력 >>");
		String storeEmail = sc.next();	// 스토어 이메일 입력
		System.out.print("<< 스토어IDX 입력 >>");
		int storeIdx = sc.nextInt();	// 스토어IDX 입력
		
		ProfileEditDao edit = new ProfileEditDao();	// Dao 객체 생성
		
		edit.profileEditDao(storeName, storeNumber, storeEmail, storeIdx);	// Dao 메서드 호출
	}
}
