package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.YWCollectionListDto;
import dto.YWCollectionListFormDto;


public class YWCollectionListDao {

    public List<YWCollectionListDto> getCollectionList(int storeIdx) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "SELECT cl.title, cl.link, cl.titlesize, cl.ratio, cl.number_of_field, ts.color_idx, cl.allview " +
                     "FROM collection_list cl " +
                     "INNER JOIN template_sunseo ts ON cl.cl_idx = ts.cl_idx " +
                     "INNER JOIN color_scheme cs ON ts.color_idx = cs.color_idx " +
                     "WHERE cs.store_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, storeIdx);
        ResultSet rs = pstmt.executeQuery();

        List<YWCollectionListDto> collectionList = new ArrayList<>();
        while (rs.next()) {
            YWCollectionListDto collection = new YWCollectionListDto(
                rs.getString("title"),
                rs.getString("link"),
                rs.getInt("titlesize"),
                rs.getInt("ratio"),
                rs.getInt("number_of_field"),
                rs.getInt("color_idx"),
                rs.getInt("allview")
            );
            collectionList.add(collection);
        }
        YWJdbcCommon.close(rs, pstmt, conn);
        return collectionList;
    }	//	연우-18

    public void updateCollectionList(int clIdx, String title, String link, int titleSize, int ratio, int numberOfField, int allview) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "UPDATE collection_list SET title = ?, link = ?, titlesize = ?, ratio = ?, number_of_field = ?, allview = ? WHERE cl_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, link);
        pstmt.setInt(3, titleSize);
        pstmt.setInt(4, ratio);
        pstmt.setInt(5, numberOfField);
        pstmt.setInt(6, allview);
        pstmt.setInt(7, clIdx);
        pstmt.executeUpdate();
        YWJdbcCommon.close(null, pstmt, conn);
    }	//	연우-19

    public void updateTemplateSunseo(int storeIdx, int clIdx, int colorIdx) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "UPDATE template_sunseo SET color_idx = ? WHERE store_idx = ? AND cl_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, colorIdx);
        pstmt.setInt(2, storeIdx);
        pstmt.setInt(3, clIdx);
        pstmt.executeUpdate();
        YWJdbcCommon.close(null, pstmt, conn);
    }	//	연우-20

    public void insertCollectionList(String title, String link, int titleSize, int ratio, int numberOfField, int allview) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "INSERT INTO collection_list(cl_idx, title, link, titlesize, ratio, number_of_field, allview) VALUES (collection_list_seq.nextval, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, link);
        pstmt.setInt(3, titleSize);
        pstmt.setInt(4, ratio);
        pstmt.setInt(5, numberOfField);
        pstmt.setInt(6, allview);
        pstmt.executeUpdate();
        YWJdbcCommon.close(null, pstmt, conn);
    }	//	연우-21

    public void insertTemplateSunseo(int storeIdx, int clIdx, int colorIdx) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "INSERT INTO template_sunseo (store_idx, sunseo, cl_idx, color_idx) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM template_sunseo WHERE store_idx = ?), ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, storeIdx);
        pstmt.setInt(2, storeIdx);
        pstmt.setInt(3, clIdx);
        pstmt.setInt(4, colorIdx);
        pstmt.executeUpdate();
        YWJdbcCommon.close(null, pstmt, conn);
    }	//	연우-22

    public List<YWCollectionListFormDto> getCollectionListForm(int clIdx) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "SELECT cl.name, cl.sl_idx FROM collection_list_form clf INNER JOIN collection cl ON clf.collection_idx = cl.cc_idx WHERE clf.cl_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, clIdx);
        ResultSet rs = pstmt.executeQuery();

        List<YWCollectionListFormDto> collectionListForm = new ArrayList<>();
        while (rs.next()) {
            YWCollectionListFormDto form = new YWCollectionListFormDto(
                rs.getString("name"),
                rs.getInt("sl_idx")
            );
            collectionListForm.add(form);
        }
        YWJdbcCommon.close(rs, pstmt, conn);
        return collectionListForm;
    }	//	연우-23

    public void updateCollectionListForm(int clIdx, int collectionIdx, int sunseo) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "UPDATE collection_list_form SET collection_idx = ? WHERE cl_idx = ? AND sunseo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, collectionIdx);
        pstmt.setInt(2, clIdx);
        pstmt.setInt(3, sunseo);
        pstmt.executeUpdate();
        YWJdbcCommon.close(null, pstmt, conn);
    }	//	연우-24

    public void insertCollectionListForm(int clIdx, int collectionIdx) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "INSERT INTO collection_list_form(cl_idx, sunseo, collection_idx) " +
                     "VALUES (?, (SELECT COUNT(sunseo) + 1 FROM collection_list_form WHERE cl_idx = ?), ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, clIdx);
        pstmt.setInt(2, clIdx);
        pstmt.setInt(3, collectionIdx);
        pstmt.executeUpdate();
        YWJdbcCommon.close(null, pstmt, conn);
    }	//	연우-25

    public List<YWCollectionListFormDto> getCollections(int storeIdx) throws Exception {
        Connection conn = YWJdbcCommon.getConnection();
        String sql = "SELECT name, sl_idx FROM collection WHERE store_idx = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, storeIdx);
        ResultSet rs = pstmt.executeQuery();

        List<YWCollectionListFormDto> collections = new ArrayList<>();
        while (rs.next()) {
            YWCollectionListFormDto collection = new YWCollectionListFormDto(
                rs.getString("name"),
                rs.getInt("sl_idx")
            );
            collections.add(collection);
        }
        YWJdbcCommon.close(rs, pstmt, conn);
        return collections;
    }	//	연우-26
}