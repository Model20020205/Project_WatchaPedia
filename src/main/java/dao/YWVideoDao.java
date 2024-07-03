package dao;

import dto.YWVideoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class YWVideoDao {
    private Connection getConnection() throws Exception {
    	return YWJdbcCommon.getConnection();
    }

    public YWVideoDto getVideo(int videoIdx) throws Exception {
        String sql = "SELECT v.title, v.title_link, v.titlesize, v.videoloop, v.sl_idx, v.videourl, ts.color_idx " +
                     "FROM video v " +
                     "INNER JOIN template_sunseo ts ON v.video_idx = ts.video_idx " +
                     "WHERE v.video_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, videoIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new YWVideoDto(videoIdx, rs.getString("title"), rs.getString("title_link"),
                                        rs.getInt("titlesize"), rs.getInt("videoloop"), rs.getInt("sl_idx"),
                                        rs.getString("videourl"), rs.getInt("color_idx"));
                }
            }
        }
        return null;
    }	//연우-49

    public void updateVideo(YWVideoDto dto) throws Exception {
        String sql = "UPDATE video SET title = ?, title_link = ?, titlesize = ?, videoloop = ?, sl_idx = ?, videourl = ? " +
                     "WHERE video_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getTitleLink());
            ps.setInt(3, dto.getTitleSize());
            ps.setInt(4, dto.getVideoLoop());
            ps.setInt(5, dto.getSlIdx());
            ps.setString(6, dto.getVideoUrl());
            ps.setInt(7, dto.getVideoIdx());
            ps.executeUpdate();
        }
    }	//연우-50

    public void updateTemplateSunseoColor(int videoIdx, int colorIdx) throws Exception {
        String sql = "UPDATE template_sunseo SET color_idx = ? WHERE video_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, colorIdx);
            ps.setInt(2, videoIdx);
            ps.executeUpdate();
        }
    }	//연우-51

    public void insertVideo(YWVideoDto dto) throws Exception {
        String sql = "INSERT INTO video(video_idx, title, title_link, titlesize, videoloop, sl_idx, videourl) " +
                     "VALUES (video_seq.nextval, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getTitleLink());
            ps.setInt(3, dto.getTitleSize());
            ps.setInt(4, dto.getVideoLoop());
            ps.setInt(5, dto.getSlIdx());
            ps.setString(6, dto.getVideoUrl());
            ps.executeUpdate();
        }
    }	//연우-52

    public void insertTemplateSunseo(int storeIdx, int videoIdx, int colorIdx) throws Exception {
        String sql = "INSERT INTO template_sunseo(store_idx, sunseo, video_idx, color_idx) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM template_sunseo WHERE store_idx = ?), ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            ps.setInt(2, storeIdx);
            ps.setInt(3, videoIdx);
            ps.setInt(4, colorIdx);
            ps.executeUpdate();
        }
    }	//연우-53
}