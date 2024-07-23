package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ProductGridDto;
import dto.ProductGridOptionDto;

public class ProductGridDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//제품 그리드 설정 변경
	void ProductGridOptionUpdate(int maximum, int number_of_field, int color_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE product_grid " + 
				"SET maximum = ?, number_of_field = ? " + 
				"WHERE color_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, maximum);
		pstmt.setInt(2, number_of_field);
		pstmt.setInt(3, color_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//제품 그리드 설정창 출력
	public ArrayList<ProductGridOptionDto> ProductGrindOption(int cc_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<ProductGridOptionDto> listRet = new ArrayList<ProductGridOptionDto>();
		String sql = "SELECT maximum, number_of_field, color_idx " + 
				"FROM product_grid " + 
				"WHERE cc_idx= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cc_idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int maximum = rs.getInt("maximum");
			int number_of_field = rs.getInt("number_of_field");
			int color_idx = rs.getInt("color_idx");
			ProductGridOptionDto dto = new ProductGridOptionDto(maximum, number_of_field, color_idx);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//제품 그리드 화면 출력
	public ArrayList<ProductGridDto> getProductGrid(int collectionIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ProductGridDto> productList = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT pg.maximum, pg.number_of_field, pg.color_idx, " +
                         "p.pd_name, p.price, p.pd_content, p.pd_state, p.sl_idx, " +
                         "po.lop1_idx, po.lop2_idx, po.lop3_idx, pg.cc_idx " +
                         "FROM product_grid pg, collection c, product p, productoption po " +
                         "WHERE pg.cc_idx = ? " +
                         "AND pg.cc_idx = c.cc_idx " +
                         "AND c.cc_idx = p.cc_idx " +
                         "AND p.pd_idx = po.pd_idx";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, collectionIdx);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductGridDto dto = new ProductGridDto(
                    rs.getInt("maximum"),
                    rs.getInt("number_of_field"),
                    rs.getInt("color_idx"),
                    rs.getString("pd_name"),
                    rs.getInt("price"),
                    rs.getString("pd_content"),
                    rs.getString("pd_state"),
                    rs.getInt("sl_idx"),
                    rs.getInt("lop1_idx"),
                    rs.getInt("lop2_idx"),
                    rs.getInt("lop3_idx"),
                    rs.getInt("cc_idx")
                );
                productList.add(dto);
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

        return productList;
    }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
//		int maximum = sc.nextInt();
//		int number_of_field = sc.nextInt();
//		int color_idx = sc.nextInt();
		
//		int cc_idx = sc.nextInt();
		ProductGridDao dao = new ProductGridDao();
//		dao.ProductGridOptionUpdate(maximum, number_of_field, color_idx);
//		ArrayList<Product_gridOptionDto> option = dao.ProductGrindOption(cc_idx);
//		for(Product_gridOptionDto dto : option) {
//			System.out.println(dto.getMaximum());
//			System.out.println(dto.getNumber_of_field());
//			System.out.println(dto.getColor_idx());
//		}
		int collectionIdx = 1; // 컬렉션 IDX

        ArrayList<ProductGridDto> productList = dao.getProductGrid(collectionIdx);
        for (ProductGridDto dto : productList) {
            System.out.println("컬렉션 IDX: " + dto.getCcIdx());
            System.out.println("제품명: " + dto.getProductName());
            System.out.println("제품 설명: " + dto.getProductDescription());
            System.out.println("제품 가격: " + dto.getPrice());
            System.out.println("제품 상태: " + dto.getProductState());
            System.out.println("제품 이미지: " + dto.getProductImage());
            System.out.println("옵션1: " + dto.getOption1());
            System.out.println("옵션2: " + dto.getOption2());
            System.out.println("옵션3: " + dto.getOption3());
            System.out.println("색상배합 IDX: " + dto.getColorIdx());
            System.out.println("===============================");
        }
	}
}
