package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class WriteQADao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	void writeQApostDao(int productInquiryIdx, int orderIdx, String gubun, String title, String content, String productImage, int secretPost) throws Exception {
		String sql = "INSERT INTO qa_bulletin_board(product_inquiry_idx, order_idx, gubun, title, content, product_image, secret_post, register_date)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, sysdate);";
		
		// INSERT INTO qa_bulletin_board(product_inquiry_idx, order_idx, gubun, title, content, product_image, secret_post, register_date, del_yn, answer, answer_date)
		// VALUES(qa_bulletin_board_seq.nextval, 1, '사이즈', '배송 문의', '배송이 얼마나 걸릴까요?', 'https://shop-phinf.pstatic.net/20240429_101/1714371310133seav9_JPEG/untitled.jpg?type=w860', 0, '2024-05-01', 'n', '주로 배송은 3일에서 5일 정도 소요됩니다', sysdate);
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productInquiryIdx);
		pstmt.setInt(2, orderIdx);
		pstmt.setString(3, gubun);
		pstmt.setString(4, title);
		pstmt.setString(5, content);
		pstmt.setString(6, productImage);
		pstmt.setInt(7, secretPost);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("<< 상품문의 작성글 추가 >>");
		System.out.print("상품문의 작성글IDX 입력 : ");
		int productInquiryIdx = sc.nextInt();
		sc.nextLine();
		System.out.print("제품IDX 입력 : ");
		int orderIdx = sc.nextInt();
		sc.nextLine();
		System.out.print("구분 입력 : ");
		String gubun = sc.nextLine();
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		System.out.print("내용 입력 : ");
		String content = sc.nextLine();
		System.out.print("제품 이미지 추가 : ");
		String productImage = sc.nextLine();
		System.out.print("비밀글 설정 : ");
		int secretPost = sc.nextInt();
		WriteQADao obj = new WriteQADao();
		obj.writeQApostDao(productInquiryIdx, orderIdx, gubun, title, content, productImage, secretPost);
	}
}
