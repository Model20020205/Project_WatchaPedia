package dao;

import dto.YWInquiryFormDto;

import java.sql.*;

public class YWInquiryFormDao {
    private Connection getConnection() throws Exception {
    	return YWJdbcCommon.getConnection();
    }

    public YWInquiryFormDto getInquiryForm(int ifIdx) throws Exception {
        String sql = "SELECT if.title, if.title_link, if.titlesize, ts.color_idx " +
                     "FROM inquiry_form if " +
                     "INNER JOIN template_sunseo ts ON if.if_idx = ts.if_idx " +
                     "WHERE ts.if_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ifIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new YWInquiryFormDto(ifIdx, rs.getString("title"), rs.getString("title_link"),
                                              rs.getInt("titlesize"), rs.getInt("color_idx"));
                }
            }
        }
        return null;
    }	//연우-43

    public void updateInquiryForm(YWInquiryFormDto dto) throws Exception {
        String sql = "UPDATE inquiry_form SET title = ?, title_link = ?, titlesize = ? WHERE if_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getTitleLink());
            ps.setInt(3, dto.getTitleSize());
            ps.setInt(4, dto.getIfIdx());
            ps.executeUpdate();
        }
    }	//연우-44

    public void updateTemplateSunseoColor(int ifIdx, int colorIdx) throws Exception {
        String sql = "UPDATE template_sunseo SET color_idx = ? WHERE if_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, colorIdx);
            ps.setInt(2, ifIdx);
            ps.executeUpdate();
        }
    }	//연우-45

    public void insertInquiryForm(YWInquiryFormDto dto) throws Exception {
        String sql = "INSERT INTO inquiry_form(if_idx, title, title_link, titlesize) " +
                     "VALUES (inquiry_form_seq.nextval, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getTitleLink());
            ps.setInt(3, dto.getTitleSize());
            ps.executeUpdate();
        }
    }	//연우-46

    public void insertTemplateSunseo(int storeIdx, int ifIdx, int colorIdx) throws Exception {
        String sql = "INSERT INTO template_sunseo(store_idx, sunseo, if_idx, color_idx) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM template_sunseo WHERE store_idx = ?), ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            ps.setInt(2, storeIdx);
            ps.setInt(3, ifIdx);
            ps.setInt(4, colorIdx);
            ps.executeUpdate();
        }
    }	//연우-47

    public void insertInquiry(int storeIdx, String name, String email, String phone, String content) throws Exception {
        String sql = "INSERT INTO inquiry (iq_idx, name, email, phone, content, store_idx) " +
                     "VALUES (inquiry_seq.nextval, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, content);
            ps.setInt(5, storeIdx);
            ps.executeUpdate();
        }
    }	//연우-48
}