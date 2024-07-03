package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.SpecialProductDetailsDto;
import dto.SpecialProductDto;

public class SpecialProductDao {
	 public SpecialProductDto getSpecialProduct(int storeIdx, int specialProductIdx) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "SELECT p.pd_name, p.sl_idx, ts.color_idx, sp.width, sp.location, sp.zoom, sp.tionop, sp.button " +
	                     "FROM special_products sp " +
	                     "INNER JOIN template_sunseo ts ON sp.sp_idx = ts.sp_idx " +
	                     "INNER JOIN product p ON sp.pd_idx = p.pd_idx " +
	                     "WHERE ts.store_idx = ? AND ts.sp_idx = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, storeIdx);
	        pstmt.setInt(2, specialProductIdx);
	        ResultSet rs = pstmt.executeQuery();

	        SpecialProductDto specialProduct = null;
	        if (rs.next()) {
	            specialProduct = new SpecialProductDto(
	                rs.getString("pd_name"),
	                rs.getInt("sl_idx"),
	                rs.getInt("color_idx"),
	                rs.getInt("width"),
	                rs.getInt("location"),
	                rs.getInt("zoom"),
	                rs.getInt("tionop"),
	                rs.getInt("button")
	            );
	        }
	        JdbcCommon.close(rs, pstmt, conn);
	        return specialProduct;
	    }	//	기능 연우-12

	    public void updateSpecialProduct(int spIdx, int pdIdx, int width, int location, int zoom, int tionop, int button) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "UPDATE special_products SET pd_idx = ?, width = ?, location = ?, zoom = ?, tionop = ?, button = ? WHERE sp_idx = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, pdIdx);
	        pstmt.setInt(2, width);
	        pstmt.setInt(3, location);
	        pstmt.setInt(4, zoom);
	        pstmt.setInt(5, tionop);
	        pstmt.setInt(6, button);
	        pstmt.setInt(7, spIdx);
	        pstmt.executeUpdate();
	        JdbcCommon.close(null, pstmt, conn);
	    }	// 기능 연우-13

	    public void updateTemplateSunseo(int storeIdx, int spIdx, int colorIdx) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "UPDATE template_sunseo SET color_idx = ? WHERE store_idx = ? AND sp_idx = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, colorIdx);
	        pstmt.setInt(2, storeIdx);
	        pstmt.setInt(3, spIdx);
	        pstmt.executeUpdate();
	        JdbcCommon.close(null, pstmt, conn);
	    }	// 기능 연우-14

	    public void insertSpecialProduct(int pdIdx, int width, int location, int zoom, int tionop, int button) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "INSERT INTO special_products(sp_idx, pd_idx, width, location, zoom, tionop, button) VALUES (special_products_seq.nextval, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, pdIdx);
	        pstmt.setInt(2, width);
	        pstmt.setInt(3, location);
	        pstmt.setInt(4, zoom);
	        pstmt.setInt(5, tionop);
	        pstmt.setInt(6, button);
	        pstmt.executeUpdate();
	        JdbcCommon.close(null, pstmt, conn);
	    }	// 기능 연우-15

	    public void insertTemplateSunseo(int storeIdx, int spIdx, int colorIdx) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "INSERT INTO template_sunseo (store_idx, sunseo, sp_idx, color_idx) " +
	                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM template_sunseo WHERE store_idx = ?), ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, storeIdx);
	        pstmt.setInt(2, storeIdx);
	        pstmt.setInt(3, spIdx);
	        pstmt.setInt(4, colorIdx);
	        pstmt.executeUpdate();
	        JdbcCommon.close(null, pstmt, conn);
	    }	// 기능 연우-16

	    public List<SpecialProductDetailsDto> getSpecialProductDetails(int specialProductIdx, int storeIdx) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "SELECT p.pd_name AS \"제품명\", p.sl_idx AS \"제품사진\", p.price AS \"가격\", l1.lop1_type, l2.lop2_type, l3.lop3_type, po.amount " +
	                     "FROM special_products sp " +
	                     "INNER JOIN product p ON sp.pd_idx = p.pd_idx " +
	                     "INNER JOIN productoption po ON p.pd_idx = po.pd_idx " +
	                     "INNER JOIN lowtionop1 l1 ON po.lop1_idx = l1.lop1_idx " +
	                     "INNER JOIN lowtionop2 l2 ON po.lop2_idx = l2.lop2_idx " +
	                     "INNER JOIN lowtionop3 l3 ON po.lop3_idx = l3.lop3_idx " +
	                     "INNER JOIN store_library sl ON p.sl_idx = sl.sl_idx " +
	                     "WHERE sp.sp_idx = ? AND store_idx = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, specialProductIdx);
	        pstmt.setInt(2, storeIdx);
	        ResultSet rs = pstmt.executeQuery();

	        List<SpecialProductDetailsDto> detailsList = new ArrayList<>();
	        while (rs.next()) {
	            SpecialProductDetailsDto details = new SpecialProductDetailsDto(
	                rs.getString("제품명"),
	                rs.getInt("제품사진"),
	                rs.getInt("가격"),
	                rs.getString("lop1_type"),
	                rs.getString("lop2_type"),
	                rs.getString("lop3_type"),
	                rs.getInt("amount")
	            );
	            detailsList.add(details);
	        }
	        JdbcCommon.close(rs, pstmt, conn);
	        return detailsList;
	    }	// 기능 연우-17
}