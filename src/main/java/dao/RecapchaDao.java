package dao;

import java.sql.*;

public class RecapchaDao {
	public int recaptchaCheck(int store_idx) throws Exception{
		Connection conn = JdbcCommon.getConnection();
		String sql = "SELECT recaptcha FROM preferences"
				+ " WHERE store_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, store_idx);
		ResultSet rs = pstmt.executeQuery();
		
		int Recaptcha = -1;
		while(rs.next()) {
			Recaptcha = rs.getInt(1);
		}
		JdbcCommon.close(rs, pstmt, conn);
		return Recaptcha;
	}	//기능 연우 - 10
	
	public void recaptchaUpdate(int recaptcha, int storeIdx) throws Exception{
		Connection conn = JdbcCommon.getConnection();
		String sql = "UPDATE preferences SET recaptcha = ?"
				+ " WHERE store_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, recaptcha);
		pstmt.setInt(2, storeIdx);
		pstmt.executeUpdate();
		JdbcCommon.close(null, pstmt, conn);
	}	//기능 연우 - 11
}
