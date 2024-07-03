package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.ColorInsertDto;
import dto.ColorSchemeDto;
import dto.ColorUpdateDto;
import dto.ShowColorDto;

public class ColorDao {
	static Connection getConnection() throws Exception {
		return JdbcCommon.getConnection();
	}
	
	public ArrayList<ColorSchemeDto> getListColor(int storeIdx) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ColorSchemeDto> colorIdxList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT color_idx FROM color_scheme"
					+ " WHERE store_idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeIdx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int colorIdx = rs.getInt("color_idx");
				ColorSchemeDto ColorSchemeDto = new ColorSchemeDto(colorIdx);
				colorIdxList.add(ColorSchemeDto);
			}
		}finally {
			JdbcCommon.close(rs, pstmt, conn);
		}
		
		return colorIdxList;
	}	//기능 연우-56
	
	public ArrayList<ShowColorDto> ShowColor(int colorIdx) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ShowColorDto> colorRGB = new ArrayList<>();
		
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
                ShowColorDto showColorDto = new ShowColorDto(colorIdxResult, background, text, backButton, buttonLabel, outlineButton);
                colorRGB.add(showColorDto);
            }
        } finally {
            JdbcCommon.close(rs, pstmt, conn);
        }
        return colorRGB;
	}	//기능 연우- 59
	public void ColorUpdate(ColorUpdateDto CUD) throws Exception{
		Connection conn = JdbcCommon.getConnection();
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
		JdbcCommon.close(null, pstmt, conn);
	}	//기능 연우-57
	
	public void ColorInsert(ColorInsertDto CID) throws Exception{
		Connection conn = JdbcCommon.getConnection();
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
		JdbcCommon.close(null, pstmt, conn);
	}	//기능 연우 - 58
}