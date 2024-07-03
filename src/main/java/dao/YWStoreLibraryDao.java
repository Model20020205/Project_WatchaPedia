package dao;

import dto.YWStoreLibraryDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YWStoreLibraryDao {
    private Connection getConnection() throws Exception {
    	return YWJdbcCommon.getConnection();
    }

    public List<Integer> getStoreLibrary(int storeIdx) throws Exception {
        String sql = "SELECT sl_idx FROM store_library WHERE store_idx = ?";
        List<Integer> slIdxList = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    slIdxList.add(rs.getInt("sl_idx"));
                }
            }
        }
        return slIdxList;
    }	//연우-53

    public void updateHeadTextLogo(int muIdx, int slIdx) throws Exception {
        String sql = "UPDATE head_text SET logo = ? WHERE mu_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, slIdx);
            ps.setInt(2, muIdx);
            ps.executeUpdate();
        }
    }	//연우-54

    public void insertStoreLibrary(YWStoreLibraryDto dto) throws Exception {
        String sql = "INSERT INTO store_library (sl_idx, upload, store_idx) " +
                     "VALUES (store_library_seq.nextval, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dto.getUpload());
            ps.setInt(2, dto.getStoreIdx());
            ps.executeUpdate();
        }
    }	//연우-55
}