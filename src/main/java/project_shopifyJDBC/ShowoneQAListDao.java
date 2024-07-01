package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
// [QA게시판] : 게시판 상품문의 글 내용 조회
public class ShowoneQAListDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	// [QA] 상품문의 작성글 1개 내용 조회
	public ArrayList<ShowoneQAListDto> showOnecontent(int productInquiryIdx) throws Exception {
		ArrayList<ShowoneQAListDto> getOneList = new ArrayList<ShowoneQAListDto>();
		Connection conn = getConnection();
		String sql = "SELECT p.store_name, qa.answer, qa.answer_date"
				+ " FROM qa_bulletin_board qa"
				+ " INNER JOIN orders o ON qa.order_idx = o.order_idx"
				+ " INNER JOIN customer_member cm ON o.mm_idx = cm.mm_idx"
				+ " INNER JOIN preferences p ON cm.store_idx = p.store_idx"
				+ " WHERE product_inquiry_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productInquiryIdx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String storeName = rs.getString("store_name");
			String answer = rs.getString("answer");
			String answerDate = rs.getString("answer_date");
			
			ShowoneQAListDto obj = new ShowoneQAListDto(storeName, answer, answerDate);
			getOneList.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return getOneList;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("<< 상품문의 작성글 한 개 조회 >>");
		System.out.print("상품문의 작성글의 스토어IDX 입력 : ");
		int storeidx = sc.nextInt();
		ShowoneQAListDao obj2 = new ShowoneQAListDao();
		ArrayList<ShowoneQAListDto> obj = obj2.showOnecontent(storeidx);
		for(int i=0; i<=obj.size()-1; i++) {
			System.out.println(obj.get(i).getStoreName());
			System.out.println(obj.get(i).getAnswer());
			System.out.println(obj.get(i).getAnswerDate());
		}
	}
}
