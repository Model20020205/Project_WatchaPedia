package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// [QA 게시판] : 상품문의 작성글 삭제 (UPDATE 사용)
public class UpdateQAidxDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	void deleteUpdateDao(int productInquiryIdx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE qa_bulletin_board "
				+ "SET order_idx = null, "
				+ "gubun = null, title = null, content = null, "
				+ "product_image = null, secret_post = null, register_date = null, "
				+ "del_yn = null, answer = null, answer_date = null "
				+ "WHERE product_inquiry_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productInquiryIdx);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 상품문의 작성글IDX 입력 : ");
		int productInquiryIdx = sc.nextInt();
		UpdateQAidxDao obj = new UpdateQAidxDao();
		obj.deleteUpdateDao(productInquiryIdx);
	}
}
