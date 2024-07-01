package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// [로고조회] : 스토어 세부정보 첫 화면

public class StoreDetailEditDao {
	static Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}
	public static ArrayList<StoreDetailEditDto> metaMainpage(int storeIdx) throws Exception {
				 // ArrayList 대신에 원래는 void, double, boolean, int etc. 들어간 것처럼 (데이터 타입 느낌)
		ArrayList<StoreDetailEditDto> metroList = new ArrayList<StoreDetailEditDto>(); 
								/* 내가 지정한 참조변수 */
		Connection conn = getConnection();
		
		String sql = "SELECT sl.upload, p.store_name," +
				" p.store_number, p.store_email" +
				" FROM preferences p" +
				" INNER JOIN store_library sl ON" +
				" sl.store_idx = p.store_idx" +
				" WHERE p.store_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, storeIdx);	// 그러면 setInt 여기에는 웬만해서 WHERE절만 들어가면 됨? A: 대부분 그렇다
		
		ResultSet rs = pstmt.executeQuery();	
		while(rs.next()) {	// rs.next() --> 다음 행 실행하는 메서드	// SELECT 해온 값들을 저장
			 String upload = rs.getString("upload");
			 String storeName = rs.getString("store_name");
			 String storeNumber = rs.getString("store_number");
			 String storeEmail = rs.getString("store_email");
			 
			 StoreDetailEditDto metro = new StoreDetailEditDto(upload, storeName, storeNumber, storeEmail);
			 
			 metroList.add(metro);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return metroList;
	}
	public static void main(String[] args) throws Exception{
		ArrayList<StoreDetailEditDto> metro = metaMainpage(1);
		for(int i=0; i<=metro.size()-1; i++) {
			System.out.println(metro.get(i).getStoreEmail());
			System.out.println(metro.get(i).getStoreName());
			System.out.println(metro.get(i).getStoreNumber());
			System.out.println(metro.get(i).getUpload());
		}
	}
}
