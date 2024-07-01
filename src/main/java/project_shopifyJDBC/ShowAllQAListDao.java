package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
// [QA게시판] : 게시판 상품문의 작성글 목록 전체 출력
public class ShowAllQAListDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<ShowAllQAListDto> showAllList() throws Exception {
		ArrayList<ShowAllQAListDto> showAllSelect = new ArrayList<ShowAllQAListDto>();
		Connection conn = getConnection();
		String sql = "SELECT qa.product_inquiry_idx, " +
                "CASE WHEN qa.answer IS NULL THEN '답변대기중' ELSE '답변완료' END AS answer, " +
                "qa.secret_post, " +
                "qa.gubun, " +
                "qa.title, " +
                "cm.email, " +
                "qa.register_date " +
                "FROM qa_bulletin_board qa " +
                "INNER JOIN orders o ON qa.order_idx = o.order_idx " +
                "INNER JOIN customer_member cm ON o.mm_idx = cm.mm_idx " +
                "ORDER BY qa.register_date DESC, qa.product_inquiry_idx DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int productInquiryIdx = rs.getInt("product_inquiry_idx");
			String answer = rs.getString("answer");
			int secretPost = rs.getInt("secret_post");
			String gubun = rs.getString("gubun");
			String title = rs.getString("title");
			String email = rs.getString("email");
			String registerDate = rs.getString("register_date");
			
			ShowAllQAListDto obj = new ShowAllQAListDto(productInquiryIdx, answer, secretPost, gubun,
														title, email, registerDate);
			showAllSelect.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return showAllSelect;
	}
	public static void main(String[] args) throws Exception {
		ShowAllQAListDao obj = new ShowAllQAListDao();
		ArrayList<ShowAllQAListDto> showlistall = obj.showAllList();
		System.out.println("<< 상품문의 작성글 전체 출력 >>");
		for(int i=0; i<=showlistall.size()-1; i++) {
			System.out.println(showlistall.get(i).getProductInquiryIdx());
			System.out.println(showlistall.get(i).getAnswer());
			System.out.println(showlistall.get(i).getSecretPost());
			System.out.println(showlistall.get(i).getGubun());
			System.out.println(showlistall.get(i).getTitle());
			System.out.println(showlistall.get(i).getEmail());
			System.out.println(showlistall.get(i).getRegisterDate());
		}
	}
}
