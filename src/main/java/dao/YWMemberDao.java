package dao;

import java.sql.*;

import dto.YWPasswordResetDto;
import dto.YWLoginResultDto;
import dto.YWRegisterMemberDto;

public class YWMemberDao {
	Connection getConnection() throws Exception {
		return YWJdbcCommon.getConnection();
	}
	
	public void registerMember(YWRegisterMemberDto member) throws Exception {
		String sql = "Insert INTO seller_login_information(user_idx, email, name, password)"
				+ " VALUES(seller_login_information_seq.nextval, ?, ?, ?)";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setNString(1, member.getEmail());
		pstmt.setNString(2, member.getName());
		pstmt.setNString(3, member.getPassword());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}		// 기능 연우-03
	
	public void passwordReset(YWPasswordResetDto changePasswordDto) throws Exception{
		Connection conn = YWJdbcCommon.getConnection();
		String sql = "UPDATE seller_login_information SET password = ?"
				+ " WHERE email = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, changePasswordDto.getNewPassword());
		pstmt.setNString(2, changePasswordDto.getNowEmail());
		pstmt.executeUpdate();
		YWJdbcCommon.close(null, pstmt, conn);
	}		// 기능 연우-02
	
	public YWLoginResultDto sellerLogin(String email, String password) throws Exception{
		String sql = "SELECT COUNT(*) AS cnt FROM seller_login_information"
				+ " WHERE email = ? AND password = ?";
		Connection conn = YWJdbcCommon.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = -1;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		YWJdbcCommon.close(rs, pstmt, conn);
		return new YWLoginResultDto(email, password, cnt);
	}		// 기능 연우-01
}