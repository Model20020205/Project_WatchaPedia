package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.HeadTextDto;

public class HeadTextDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//머리글 색상배합 설정
	void HeadTextOptionUpdate(int new_color_idx, int color_idx2, int color_idx) throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE head_text " + 
				"SET color_idx = ?, " + 
				"color_idx2 = ? " + 
				"WHERE color_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, new_color_idx);
		pstmt.setInt(2, color_idx2);
		pstmt.setInt(3, color_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//머리글 설정창 출력
	public ArrayList<HeadTextDto> HeadTextOption(int logo) throws Exception {
		Connection conn = getConnection();
		ArrayList<HeadTextDto> listRet = new ArrayList<HeadTextDto>();
		String sql = "SELECT color_idx, color_idx2, mu_idx " + 
				"FROM head_text " + 
				"WHERE logo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, logo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int color_idx = rs.getInt("color_idx");
			int color_idx2 = rs.getInt("color_idx2");
			int mu_idx = rs.getInt("mu_idx");
			HeadTextDto dto = new HeadTextDto(color_idx, color_idx2, mu_idx);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//머리글 메뉴 변경
	void HeadTextMenuUpdate(int mu_idx, int color_idx) throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE head_text " + 
				"SET mu_idx = ? " + 
				"WHERE color_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mu_idx);
		pstmt.setInt(2, color_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
//		System.out.print("new_color_idx : ");
//		int new_color_idx = sc.nextInt();
//		System.out.print("color_idx2 : ");
//		int color_idx2 = sc.nextInt();
//		System.out.print("color_idx");
//		int color_idx = sc.nextInt();
//		
//		HeadTextDao dao = new HeadTextDao();
//		dao.HeadTextOption(new_color_idx, color_idx2, color_idx);
//		
//		System.out.println("끝");
		
//		System.out.print("logo : ");
//		int logo = sc.nextInt();
//		
//		HeadTextDao dao = new HeadTextDao();
//		ArrayList<HeadTextDto> option = dao.HeadTextOption(logo);
//		for(HeadTextDto dto : option) {
//			System.out.println(dto.getColor_idx());
//			System.out.println(dto.getColor_idx2());
//			System.out.println(dto.getMu_idx());
//		}
		int mu_idx = sc.nextInt();
		int color_idx = sc.nextInt();
		HeadTextDao dao = new HeadTextDao();
		dao.HeadTextMenuUpdate(mu_idx, color_idx);
		
		System.out.println("끝");
	}
}
