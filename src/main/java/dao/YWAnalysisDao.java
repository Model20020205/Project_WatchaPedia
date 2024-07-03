package dao;

import java.sql.*;

public class YWAnalysisDao {
	public int avgPrice(int store_idx, String startdate, String enddate) throws Exception {
		Connection conn = YWJdbcCommon.getConnection();
		String sql = "SELECT TRUNC(AVG(o.total_price)) AS Avgtotalprice FROM orders o"
				+ " INNER JOIN customer_member cm ON o.mm_idx = cm.mm_idx"
				+ " WHERE cm.store_idx = ? AND o.naljja BETWEEN TO_DATE(?) AND TO_DATE(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, store_idx);
		pstmt.setString(2, startdate);
		pstmt.setString(3, enddate);
		ResultSet rs = pstmt.executeQuery();
		
		int avgtotalPrice = -1;
		while(rs.next()) {
			avgtotalPrice = rs.getInt("Avgtotalprice");
		}
		YWJdbcCommon.close(rs, pstmt, conn);
		return avgtotalPrice;
	}	// 기능 연우-04
	
	public int totalOrders(int store_idx, String startdate, String enddate) throws Exception{
		Connection conn = YWJdbcCommon.getConnection();
		String sql = "SELECT COUNT(o.order_idx) AS totalorders FROM orders o"
				+ " INNER JOIN customer_member cm ON o.mm_idx = cm.mm_idx"
				+ " WHERE cm.store_idx = ? AND o.naljja BETWEEN TO_DATE(?) AND TO_DATE(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, store_idx);
		pstmt.setString(2, startdate);
		pstmt.setString(3, enddate);
		ResultSet rs = pstmt.executeQuery();
		int totalorders = -1;
		while(rs.next()) {
			totalorders = rs.getInt("totalorders");
		}
		YWJdbcCommon.close(rs, pstmt, conn);
		return totalorders;
	}	// 기능 연우-05
	
	public int totalPrice(int storeIdx, String startdate, String enddate) throws Exception{
		Connection conn = YWJdbcCommon.getConnection();
		String sql = "SELECT SUM(o.total_price) AS totalprice FROM orders o"
				+ " INNER JOIN customer_member cm ON o.mm_idx = cm.mm_idx"
				+ " WHERE cm.store_idx = ? AND o.naljja BETWEEN TO_DATE(?) AND TO_DATE(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, storeIdx);
		pstmt.setString(2, startdate);
		pstmt.setString(3, enddate);
		ResultSet rs = pstmt.executeQuery();
		int totalprice = -1;
		while(rs.next()) {
			totalprice = rs.getInt("totalprice");
		}
		YWJdbcCommon.close(rs, pstmt, conn);
		return totalprice;
	}	// 기능 연우-06
}