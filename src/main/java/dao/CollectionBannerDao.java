package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.CollectionBannerDto;

public class CollectionBannerDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//컬렉션 배너 설정 변경
	void CollectionBannerColorUpdate(int new_color_idx, int cc_idx, int color_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE collection_banner " + 
				"SET color_idx = ?, cc_idx = ? " + 
				"WHERE color_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, new_color_idx);
		pstmt.setInt(2, cc_idx);
		pstmt.setInt(3, color_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	// 컬렉션 배너 데이터 출력
	public ArrayList<CollectionBannerDto> collection_banner(int cc_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<CollectionBannerDto> listRet = new ArrayList<CollectionBannerDto>();
		String sql = "SELECT cb.color_idx, c.name, c.sl_idx " + 
				"FROM collection_banner cb, collection c " + 
				"WHERE c.cc_idx = ? " + 
				"AND cb.cc_idx = c.cc_idx";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cc_idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int color_idx = rs.getInt("color_idx");
			String name = rs.getString("name");
			int sl_idx = rs.getInt("sl_idx");
			CollectionBannerDto dto = new CollectionBannerDto(color_idx, name, sl_idx);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//컬렉션 배너 설정창 출력
	public int CollectionBannerOption(int cc_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT color_idx " + 
				"FROM collection_banner " + 
				"WHERE cc_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cc_idx);
		ResultSet rs = pstmt.executeQuery();
		int color_idx = 0;
		if(rs.next()) {
			color_idx = rs.getInt("color_idx");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return color_idx;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
//		int new_color_idx = sc.nextInt();
		int cc_idx = sc.nextInt();
//		int color_idx = sc.nextInt();
		
		CollectionBannerDao dao = new CollectionBannerDao();
//		dao.CollectionBannerColorUpdate(new_color_idx, cc_idx, color_idx);
//		ArrayList<collection_bannerDto> option = dao.collection_banner(cc_idx);
//		for(collection_bannerDto dto : option) {
//			System.out.println(dto.getColor_idx());
//			System.out.println(dto.getName());
//			System.out.println(dto.getSl_idx());
//		}
		System.out.print(dao.CollectionBannerOption(cc_idx));
	}
}
