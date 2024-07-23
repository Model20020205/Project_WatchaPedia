package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TemplateCollectionDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	public void updateTemplateCollection(String title, int numberOfField, int storeIdx) throws Exception {
        Connection conn = getConnection();;

            String sql = "UPDATE template_collection_ " + 
                    "SET title = ?, number_of_field = ? " + 
                    "WHERE store_idx = ?";
            
        PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setInt(2, numberOfField);
            pstmt.setInt(3, storeIdx);
            
            pstmt.executeUpdate();
       
            pstmt.close();
            conn.close();
        }

    public static void main(String[] args) throws Exception {
        TemplateCollectionDao dao = new TemplateCollectionDao();

        Scanner sc = new Scanner(System.in);
        
        System.out.print("새로운 제목을 입력하세요: ");
        String title = sc.nextLine();
        
        System.out.print("데스크톱의 열 수를 입력하세요: ");
        int numberOfField = sc.nextInt();
        
        System.out.print("스토어 IDX를 입력하세요: ");
        int storeIdx = sc.nextInt();
        
        dao.updateTemplateCollection(title, numberOfField, storeIdx);
        
        // 스캐너 닫기
        sc.close();
    }
}
