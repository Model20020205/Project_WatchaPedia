package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.Nomination_colletionDto;
import dto.NominationCollectionOptionDto;

public class NominationCollectionDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//추천컬렉션 옵션창 출력
	public ArrayList<NominationCollectionOptionDto> ncOption(int nc_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<NominationCollectionOptionDto> listRet = new ArrayList<NominationCollectionOptionDto>();
		String sql = "SELECT cc_idx, title, link, maximum, number_of_field, ts.color_idx " + 
				"FROM nomination_collection nc, template_sunseo ts " + 
				"WHERE nc.nc_idx = ? " + 
				"AND nc.nc_idx = ts.nc_idx";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, nc_idx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String title = rs.getString("title");
			String link = rs.getString("link");
			int cc_idx = rs.getInt("cc_idx");
			int maximum = rs.getInt("maximum");
			int number_of_field = rs.getInt("number_of_field");
			int color_idx = rs.getInt("color_idx");
			NominationCollectionOptionDto dto = new NominationCollectionOptionDto(title, link, cc_idx, maximum, number_of_field, color_idx);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//추천컬렉션 옵션 변경
	void ncOptionUpdate(int cc_idx, String title, String link, int maximum, int number_of_field, int nc_idx) throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE nomination_collection " + 
				"SET cc_idx = ?, title = ?, link = ?, maximum = ?, number_of_field = ? " + 
				"WHERE nc_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cc_idx);
		pstmt.setString(2, title);
		pstmt.setString(3, link);
		pstmt.setInt(4, maximum);
		pstmt.setInt(5, number_of_field);
		pstmt.setInt(6, nc_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//추천 컬렉션 색상배합 변경
	void ncColorOption(int color_idx, int nc_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE template_sunseo " + 
				"SET color_idx = ? " + 
				"WHERE nc_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, color_idx);
		pstmt.setInt(2, nc_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
    // 추천컬렉션 조회 메서드
    public Nomination_colletionDto getRecommendationCollection(int ccIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Nomination_colletionDto dto = null;

        try {
            conn = getConnection(); 

            String sql = "SELECT nc.title \"텍스트\", nc.link \"링크\",  nc.maximum \"최대제품\", \r\n" + 
            		"nc.number_of_field \"한줄표시제품\", ts.color_idx \"색배합\", po.lop1_idx \"옵션1\", po.lop2_idx \"옵션2\",\r\n" + 
            		"po.lop3_idx \"옵션3\" , p.pd_name \"제품 이름\", p.price \"가격\", p.pd_state \"제품 상태\", po.sl_idx \"제품 이미지\"\r\n" + 
            		"FROM nomination_collection nc, template_sunseo ts, collection c, product p, productoption po\r\n" + 
            		"WHERE nc.nc_idx = ts.nc_idx  " + 
            		"AND c.cc_idx = p.cc_idx " + 
            		"AND p.pd_idx = po.pd_idx " + 
            		"AND p.cc_idx = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ccIdx);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new Nomination_colletionDto(
                    rs.getString("텍스트"),
                    rs.getString("링크"),
                    rs.getInt("최대제품"),
                    rs.getInt("한줄표시제품"),
                    rs.getInt("색배합"),
                    rs.getInt("옵션1"),
                    rs.getInt("옵션2"),
                    rs.getInt("옵션3"),
                    rs.getString("제품 이름"),
                    rs.getInt("가격"),
                    rs.getString("제품 상태"),
                    rs.getInt("제품 이미지")
                );
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return dto;
    }
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
//		System.out.print("nc_idx : ");
//		int nc_idx = sc.nextInt();
//		
//		nomination_collection dao = new nomination_collection();
//		ArrayList<nomination_collectionOptionDto> ncOption = dao.ncOption(nc_idx);
//		for(nomination_collectionOptionDto dto : ncOption) {
//			System.out.println(dto.getCc_idx());
//			System.out.println(dto.getTitle());
//			System.out.println(dto.getLink());
//			System.out.println(dto.getMaximum());
//			System.out.println(dto.getNumber_of_field());
//		}
//		int cc_idx = sc.nextInt();
//		String title = sc.next();
//		String link = sc.next();
//		int maximum = sc.nextInt();
//		int number_of_field = sc.nextInt();
//		int nc_idx = sc.nextInt();
//		
//		nomination_collection dao = new nomination_collection();
//		dao.ncOptionUpdate(cc_idx, title, link, maximum, number_of_field, nc_idx);
		
//		int color_idx = sc.nextInt();
//		int nc_idx = sc.nextInt();
//		dao.ncColorOption(color_idx, nc_idx);
		
		 int ccIdx = sc.nextInt();
         
		 NominationCollectionDao dao = new NominationCollectionDao();
		 Nomination_colletionDto dto = dao.getRecommendationCollection(ccIdx);
		
		 System.out.println("텍스트: " + dto.getText());
         System.out.println("링크: " + dto.getLink());
         System.out.println("최대제품: " + dto.getMaximumProducts());
         System.out.println("한줄표시제품: " + dto.getNumberOfFieldProducts());
         System.out.println("색배합: " + dto.getColorCombination());
         System.out.println("옵션1: " + dto.getOption1());
         System.out.println("옵션2: " + dto.getOption2());
         System.out.println("옵션3: " + dto.getOption3());
         System.out.println("제품 이름: " + dto.getProductName());
         System.out.println("가격: " + dto.getPrice());
         System.out.println("제품 상태: " + dto.getProductState());
         System.out.println("제품 이미지: " + dto.getProductImage());
	}
}
