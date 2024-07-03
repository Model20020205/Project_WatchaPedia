package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.YWColorInsertDto;
import dto.YWColorSchemeDto;
import dto.YWColorUpdateDto;
import dto.YWShowColorDto;

public class YWColorDao {
	static Connection getConnection() throws Exception {
		return YWJdbcCommon.getConnection();
	}
	
	public ArrayList<YWColorSchemeDto> getListColor(int storeIdx) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<YWColorSchemeDto> colorIdxList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT color_idx FROM color_scheme"
					+ " WHERE store_idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeIdx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int colorIdx = rs.getInt("color_idx");
				YWColorSchemeDto YWColorSchemeDto = new YWColorSchemeDto(colorIdx);
				colorIdxList.add(YWColorSchemeDto);
			}
		}finally {
			YWJdbcCommon.close(rs, pstmt, conn);
		}
		
		return colorIdxList;
	}	//기능 연우-56
	
	public ArrayList<YWShowColorDto> ShowColor(int colorIdx) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<YWShowColorDto> colorRGB = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT color_idx, background, text, back_button, button_label, outline_button\r\n" + 
					" FROM color_scheme\r\n" + 
					" WHERE color_idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, colorIdx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int colorIdxResult = rs.getInt("color_idx");
                String background = rs.getString("background");
                String text = rs.getString("text");
                String backButton = rs.getString("back_button");
                String buttonLabel = rs.getString("button_label");
                String outlineButton = rs.getString("outline_button");
                YWShowColorDto YWShowColorDto = new YWShowColorDto(colorIdxResult, background, text, backButton, buttonLabel, outlineButton);
                colorRGB.add(YWShowColorDto);
            }
        } finally {
            YWJdbcCommon.close(rs, pstmt, conn);
        }
        return colorRGB;
	}	//기능 연우- 59
	public void ColorUpdate(YWColorUpdateDto CUD) throws Exception{
		Connection conn = YWJdbcCommon.getConnection();
		String sql = "UPDATE color_scheme SET background = ?, text = ?, back_button = ?, button_label = ?, outline_button = ?"
				+ " WHERE color_idx = ? AND store_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, CUD.getBackground());
		pstmt.setString(2, CUD.getText());
		pstmt.setString(3, CUD.getBack_button());
		pstmt.setString(4, CUD.getButton_label());
		pstmt.setString(5, CUD.getOutline_button());
		pstmt.setInt(6, CUD.getColor_idx());
		pstmt.setInt(7, CUD.getStore_idx());
		pstmt.executeUpdate();
		YWJdbcCommon.close(null, pstmt, conn);
	}	//기능 연우-57
	
	public void ColorInsert(YWColorInsertDto CID) throws Exception{
		Connection conn = YWJdbcCommon.getConnection();
		String sql = "INSERT INTO color_scheme(color_idx, store_idx, background, text, back_button, button_label, outline_button)"
				+ " VALUES(color_scheme_seq.nextval, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, CID.getStore_idx());
		pstmt.setString(2, CID.getBackground());
		pstmt.setString(3, CID.getText());
		pstmt.setString(4, CID.getBack_button());
		pstmt.setString(5, CID.getButton_label());
		pstmt.setString(6, CID.getOutline_button());
		pstmt.executeUpdate();
		YWJdbcCommon.close(null, pstmt, conn);
	}	//기능 연우 - 58
}