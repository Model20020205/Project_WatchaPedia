package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.ManyRowDto;
import dto.EachRowDto;

public class ManyRowDao {

    public ManyRowDto getManyRow(int mrIdx) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "SELECT mr.height, mr.width, mr.titlesize, mr.buttonstyle, mr.location, mr.lineup, mr.disposition, ts.color_idx, mr.color_idx " +
                     "FROM many_row mr " +
                     "INNER JOIN template_sunseo ts ON ts.mr_idx = mr.mr_idx " +
                     "WHERE ts.mr_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, mrIdx);
        ResultSet rs = pstmt.executeQuery();
        
        ManyRowDto dto = null;
        if (rs.next()) {
            dto = new ManyRowDto(
                rs.getInt("height"),
                rs.getInt("width"),
                rs.getInt("titlesize"),
                rs.getInt("buttonstyle"),
                rs.getInt("location"),
                rs.getInt("lineup"),
                rs.getInt("disposition"),
                rs.getInt("color_idx")
            );
            dto.setMrIdx(mrIdx);
        }
        
        JdbcCommon.close(rs, pstmt, conn);
        return dto;
    }	//연우-35
    
    public void updateManyRow(ManyRowDto dto) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "UPDATE many_row " +
                     "SET height = ?, width = ?, titlesize = ?, buttonstyle = ?, location = ?, lineup = ?, disposition = ?, color_idx = ? " +
                     "WHERE mr_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dto.getHeight());
        pstmt.setInt(2, dto.getWidth());
        pstmt.setInt(3, dto.getTitlesize());
        pstmt.setInt(4, dto.getButtonstyle());
        pstmt.setInt(5, dto.getLocation());
        pstmt.setInt(6, dto.getLineup());
        pstmt.setInt(7, dto.getDisposition());
        pstmt.setInt(8, dto.getColorIdx());
        pstmt.setInt(9, dto.getMrIdx());
        pstmt.executeUpdate();
        
        JdbcCommon.close(null, pstmt, conn);
    }	//연우-36
    
    public void updateTemplateSunseoColor(int mrIdx, int colorIdx) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "UPDATE template_sunseo " +
                     "SET color_idx = ? " +
                     "WHERE mr_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, colorIdx);
        pstmt.setInt(2, mrIdx);
        pstmt.executeUpdate();
        
        JdbcCommon.close(null, pstmt, conn);
    }	//연우-37
    
    public void insertManyRow(ManyRowDto dto) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "INSERT INTO many_row(mr_idx, height, width, titlesize, buttonstyle, location, lineup, disposition, color_idx) " +
                     "VALUES (many_row_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dto.getHeight());
        pstmt.setInt(2, dto.getWidth());
        pstmt.setInt(3, dto.getTitlesize());
        pstmt.setInt(4, dto.getButtonstyle());
        pstmt.setInt(5, dto.getLocation());
        pstmt.setInt(6, dto.getLineup());
        pstmt.setInt(7, dto.getDisposition());
        pstmt.setInt(8, dto.getColorIdx());
        pstmt.executeUpdate();
        
        JdbcCommon.close(null, pstmt, conn);
    }	//연우-38
    
    public void insertTemplateSunseo(int storeIdx, int mrIdx, int colorIdx) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "INSERT INTO template_sunseo (store_idx, sunseo, mr_idx, color_idx) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM template_sunseo WHERE store_idx = ?), ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, storeIdx);
        pstmt.setInt(2, storeIdx);
        pstmt.setInt(3, mrIdx);
        pstmt.setInt(4, colorIdx);
        pstmt.executeUpdate();
        
        JdbcCommon.close(null, pstmt, conn);
    }	//연우-39
    
    public List<EachRowDto> getEachRows(int mrIdx, int sunseo) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "SELECT sl_idx, title, title_link, text, buttonlabel, buttonlink " +
                     "FROM each_row " +
                     "WHERE mr_idx = ? " +
                     "AND sunseo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, mrIdx);
        pstmt.setInt(2, sunseo);
        ResultSet rs = pstmt.executeQuery();
        
        List<EachRowDto> eachRows = new ArrayList<>();
        while (rs.next()) {
            eachRows.add(new EachRowDto(
                mrIdx,
                sunseo,
                rs.getInt("sl_idx"),
                rs.getString("title"),
                rs.getString("title_link"),
                rs.getString("text"),
                rs.getString("buttonlabel"),
                rs.getString("buttonlink")
            ));
        }
        
        JdbcCommon.close(rs, pstmt, conn);
        return eachRows;
    }	//연우-40
    
    public void insertEachRow(EachRowDto dto) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "INSERT INTO each_row(mr_idx, sunseo, sl_idx, title, title_link, text, buttonlabel, buttonlink) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM each_row WHERE mr_idx = ?), ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dto.getMrIdx());
        pstmt.setInt(2, dto.getMrIdx());
        pstmt.setInt(3, dto.getSlIdx());
        pstmt.setString(4, dto.getTitle());
        pstmt.setString(5, dto.getTitleLink());
        pstmt.setString(6, dto.getText());
        pstmt.setString(7, dto.getButtonLabel());
        pstmt.setString(8, dto.getButtonLink());
        pstmt.executeUpdate();
        
        JdbcCommon.close(null, pstmt, conn);
    }	//연우-41
    
    public void updateEachRow(EachRowDto dto) throws Exception {
        Connection conn = JdbcCommon.getConnection();
        String sql = "UPDATE each_row " +
                     "SET sl_idx = ?, title = ?, title_link = ?, text = ?, buttonlabel = ?, buttonlink = ? " +
                     "WHERE mr_idx = ? " +
                     "AND sunseo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dto.getSlIdx());
        pstmt.setString(2, dto.getTitle());
        pstmt.setString(3, dto.getTitleLink());
        pstmt.setString(4, dto.getText());
        pstmt.setString(5, dto.getButtonLabel());
        pstmt.setString(6, dto.getButtonLink());
        pstmt.setInt(7, dto.getMrIdx());
        pstmt.setInt(8, dto.getSunseo());
        pstmt.executeUpdate();
        
        JdbcCommon.close(null, pstmt, conn);
    }	//연우-42
}