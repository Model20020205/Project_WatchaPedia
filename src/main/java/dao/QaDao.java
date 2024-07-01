package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.QaDto;

public class QaDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}
	public ArrayList<QaDto> showList() throws Exception {
		ArrayList<QaDto> getList = new ArrayList<QaDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM qa_bulletin_board";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int productInquiryIdx = rs.getInt("product_inquiry_idx");
			int orderIdx = rs.getInt("order_idx");
			String gubun = rs.getString("gubun");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String productImage = rs.getString("product_image");
			int secretPost = rs.getInt("secret_post");
			String registerDate = rs.getString("register_date");
			String delYN = rs.getString("del_yn");
			String answer = rs.getString("answer");
			String answerDate = rs.getString("answer_date");
			
			QaDto obj = new QaDto(productInquiryIdx, orderIdx, gubun, title, content, productImage,
					secretPost, registerDate, delYN, answer, answerDate);
			getList.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return getList;
	}
	// 상품문의 작성글 1개 상세 내용 조회
	public QaDto showOne(int productInquiryIdx) throws Exception {
		String sql = "SELECT * FROM qa_bulletin_board WHERE product_inquiry_idx = ?";
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productInquiryIdx);
		
		QaDto dto = null;
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int orderidx = rs.getInt("order_idx");
			String gubun = rs.getString("gubun");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String productimage = rs.getString("product_image");
			int secretpost = rs.getInt("secret_post");
			String registerdate = rs.getString("register_date");
			String delyn = rs.getString("del_yn");
			String answer = rs.getString("answer");
			String answerdate = rs.getString("answer_date");
			
			dto = new QaDto(productInquiryIdx, orderidx, gubun, title, content,
					productimage, secretpost, registerdate, delyn, answer, answerdate);
			
		}
		return dto;
	}
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("상품문의 작성글 IDX 입력 : ");
//		int idx = sc.nextInt();
//		QaDao obj = new QaDao();
//		QaDto showList = obj.showOne(idx);
//		
//		System.out.println(showList.getOrderIdx());
//		System.out.println(showList.getGubun());
//		System.out.println(showList.getTitle());
//		System.out.println(showList.getContent());
//		System.err.println(showList.getProductImage());
//		System.out.println(showList.getSecretPost());
//		System.out.println(showList.getRegisterDate());
//		System.out.println(showList.getDelYN());
//		System.out.println(showList.getAnswer());
//		System.out.println(showList.getAnswerDate());
//	}
}
