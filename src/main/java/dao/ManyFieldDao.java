package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import dto.ManyFieldDto;
import dto.FieldDto;

public class ManyFieldDao {

    public ManyFieldDto getManyField(int mfIdx) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "SELECT mf.title, mf.title_link, mf.titlesize, mf.width, mf.ratio, mf.lineup, mf.background, mf.buttonlabel, mf.buttonlink, ts.color_idx " +
                     "FROM many_field mf " +
                     "INNER JOIN template_sunseo ts ON mf.mf_idx = ts.mf_idx " +
                     "WHERE mf.mf_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, mfIdx);
        ResultSet rs = pstmt.executeQuery();

        ManyFieldDto manyField = null;
        if (rs.next()) {
            manyField = new ManyFieldDto(
                rs.getString("title"),
                rs.getString("title_link"),
                rs.getInt("titlesize"),
                rs.getInt("width"),
                rs.getInt("ratio"),
                rs.getInt("lineup"),
                rs.getInt("background"),
                rs.getString("buttonlabel"),
                rs.getString("buttonlink"),
                rs.getInt("color_idx")
            );
        }
        JdbcCommon.close(rs, pstmt, conn);
        return manyField;
    }	// 연우-27

    public void updateManyField(int mfIdx, String title, String titleLink, int titleSize, int width, int ratio, int lineup, int background, String buttonLabel, String buttonLink) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "UPDATE many_field SET title = ?, title_link = ?, titlesize = ?, width = ?, ratio = ?, lineup = ?, background = ?, buttonlabel = ?, buttonlink = ? WHERE mf_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, titleLink);
        pstmt.setInt(3, titleSize);
        pstmt.setInt(4, width);
        pstmt.setInt(5, ratio);
        pstmt.setInt(6, lineup);
        pstmt.setInt(7, background);
        pstmt.setString(8, buttonLabel);
        pstmt.setString(9, buttonLink);
        pstmt.setInt(10, mfIdx);
        pstmt.executeUpdate();
        JdbcCommon.close(null, pstmt, conn);
    }	// 연우-28

    public void updateTemplateSunseo(int mfIdx, int colorIdx) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "UPDATE template_sunseo SET color_idx = ? WHERE mf_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, colorIdx);
        pstmt.setInt(2, mfIdx);
        pstmt.executeUpdate();
        JdbcCommon.close(null, pstmt, conn);
    }	// 연우-29

    public void insertManyField(String title, String titleLink, int titleSize, int width, int ratio, int lineup, int background, String buttonLabel, String buttonLink) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "INSERT INTO many_field(mf_idx, title, title_link, titlesize, width, ratio, lineup, background, buttonlabel, buttonlink) " +
                     "VALUES(many_field_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, titleLink);
        pstmt.setInt(3, titleSize);
        pstmt.setInt(4, width);
        pstmt.setInt(5, ratio);
        pstmt.setInt(6, lineup);
        pstmt.setInt(7, background);
        pstmt.setString(8, buttonLabel);
        pstmt.setString(9, buttonLink);
        pstmt.executeUpdate();
        JdbcCommon.close(null, pstmt, conn);
    }	// 연우-30

    public void insertTemplateSunseo(int storeIdx, int mfIdx, int colorIdx) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "INSERT INTO template_sunseo (store_idx, sunseo, mf_idx, color_idx) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM template_sunseo WHERE store_idx = ?), ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, storeIdx);
        pstmt.setInt(2, storeIdx);
        pstmt.setInt(3, mfIdx);
        pstmt.setInt(4, colorIdx);
        pstmt.executeUpdate();
        JdbcCommon.close(null, pstmt, conn);
    }	// 연우-31

    public List<FieldDto> getField(int mfIdx, int sunseo) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "SELECT f.sl_idx, f.title, f.title_link, f.description, f.buttonlabel, f.buttonlink " +
                     "FROM field f WHERE mf_idx = ? AND sunseo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, mfIdx);
        pstmt.setInt(2, sunseo);
        ResultSet rs = pstmt.executeQuery();

        List<FieldDto> fields = new ArrayList<>();
        while (rs.next()) {
            FieldDto field = new FieldDto(
                rs.getInt("sl_idx"),
                rs.getString("title"),
                rs.getString("title_link"),
                rs.getString("description"),
                rs.getString("buttonlabel"),
                rs.getString("buttonlink")
            );
            fields.add(field);
        }
        JdbcCommon.close(rs, pstmt, conn);
        return fields;
    }	// 연우-32

    public void insertField(int mfIdx, int slIdx, String title, String titleLink, String description, String buttonLabel, String buttonLink) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "INSERT INTO field(mf_idx, sunseo, sl_idx, title, title_link, description, buttonlabel, buttonlink) " +
                     "VALUES(?, (SELECT COUNT(sunseo) + 1 FROM field WHERE mf_idx = ?), ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, mfIdx);
        pstmt.setInt(2, mfIdx);
        pstmt.setInt(3, slIdx);
        pstmt.setString(4, title);
        pstmt.setString(5, titleLink);
        pstmt.setString(6, description);
        pstmt.setString(7, buttonLabel);
        pstmt.setString(8, buttonLink);
        pstmt.executeUpdate();
        JdbcCommon.close(null, pstmt, conn);
    }	// 연우-33

    public void updateField(int mfIdx, int sunseo, int slIdx, String title, String titleLink, String description, String buttonLabel, String buttonLink) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "UPDATE field SET sl_idx = ?, title = ?, title_link = ?, description = ?, buttonlabel = ?, buttonlink = ? " +
                     "WHERE mf_idx = ? AND sunseo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, slIdx);
        pstmt.setString(2, title);
        pstmt.setString(3, titleLink);
        pstmt.setString(4, description);
        pstmt.setString(5, buttonLabel);
        pstmt.setString(6, buttonLink);
        pstmt.setInt(7, mfIdx);
        pstmt.setInt(8, sunseo);
        pstmt.executeUpdate();
        JdbcCommon.close(null, pstmt, conn);
    }// 연우-34
}