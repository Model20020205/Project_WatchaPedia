package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.MenuListDto;

public class ThemeSettingDao {
	 public void createMenu(String name, int storeIdx) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "INSERT INTO create_menu (mu_idx, name, store_idx) VALUES (CREATE_MENU_SEQ.nextval, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name);
	        pstmt.setInt(2, storeIdx);
	        pstmt.executeUpdate();
	        JdbcCommon.close(null, pstmt, conn);
	    }	// 기능 연우-07
	    
	    public void insertMenuList(int muIdx, String name, String link, int upperMul) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "INSERT INTO menu_list (mu_idx, sunseo, name, link, upper_mul) VALUES (?, (SELECT COUNT(sunseo) + 1 FROM menu_list WHERE mu_idx = ?), ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, muIdx);
	        pstmt.setInt(2, muIdx);
	        pstmt.setString(3, name);
	        pstmt.setString(4, link);
	        pstmt.setInt(5, upperMul);
	        pstmt.executeUpdate();
	        JdbcCommon.close(null, pstmt, conn);
	    }	// 기능 연우-08
	    
	    public List<MenuListDto> getMenuList(int muIdx) throws Exception {
	        Connection conn = JdbcCommon.getConnection();
	        String sql = "SELECT name, link, upper_mul FROM menu_list WHERE mu_idx = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, muIdx);
	        ResultSet rs = pstmt.executeQuery();
	        
	        List<MenuListDto> menuList = new ArrayList<>();
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String link = rs.getString("link");
	            int upperMul = rs.getInt("upper_mul");
	            menuList.add(new MenuListDto(name, link, upperMul));
	        }
	        JdbcCommon.close(rs, pstmt, conn);
	        return menuList;
	    }	// 기능 연우-09
}