package dao;

import dto.YWProductDetailsDto;
import dto.YWReducerowDto;
import dto.YWTemplateProductsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class YWTemplateProductsDao {
    private Connection getConnection() throws Exception {
    	return YWJdbcCommon.getConnection();
    }

    public String getLatestProductName(int storeIdx) throws Exception {
        String sql = "SELECT p.pd_name FROM product p INNER JOIN store_library sl ON p.sl_idx = sl.sl_idx " +
                     "WHERE p.pd_idx = (SELECT max(pd_idx) FROM product p INNER JOIN store_library sl ON p.sl_idx = sl.sl_idx WHERE store_idx = ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("pd_name");
                }
            }
        }
        return null;
    }

    public YWTemplateProductsDto getTemplateProducts(int tpIdx, int storeIdx) throws Exception {
        String sql = "SELECT tp.width, tp.layout, tp.location, tp.zoom, tp.color_idx, tp.pd_idx, tp.tionop, tp.button " +
                     "FROM template_products tp INNER JOIN color_scheme cs ON tp.color_idx = cs.color_idx " +
                     "WHERE tp.tp_idx = ? AND store_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tpIdx);
            ps.setInt(2, storeIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    YWTemplateProductsDto dto = new YWTemplateProductsDto();
                    dto.setWidth(rs.getInt("width"));
                    dto.setLayout(rs.getInt("layout"));
                    dto.setLocation(rs.getInt("location"));
                    dto.setZoom(rs.getInt("zoom"));
                    dto.setColorIdx(rs.getInt("color_idx"));
                    dto.setPdIdx(rs.getInt("pd_idx"));
                    dto.setTionop(rs.getInt("tionop"));
                    dto.setButton(rs.getInt("button"));
                    return dto;
                }
            }
        }
        return null;
    }

    public List<String> getProductNames(int storeIdx) throws Exception {
        String sql = "SELECT p.pd_name FROM product p INNER JOIN store_library sl ON p.sl_idx = sl.sl_idx WHERE store_idx = ?";
        List<String> productNames = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productNames.add(rs.getString("pd_name"));
                }
            }
        }
        return productNames;
    }

    public void updateTemplateProducts(YWTemplateProductsDto dto) throws Exception {
        String sql = "UPDATE template_products SET color_idx = ?, pd_idx = ?, width = ?, layout = ?, location = ?, zoom = ?, tionop = ?, button = ? WHERE tp_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dto.getColorIdx());
            ps.setInt(2, dto.getPdIdx());
            ps.setInt(3, dto.getWidth());
            ps.setInt(4, dto.getLayout());
            ps.setInt(5, dto.getLocation());
            ps.setInt(6, dto.getZoom());
            ps.setInt(7, dto.getTionop());
            ps.setInt(8, dto.getButton());
            ps.setInt(9, dto.getTpIdx());
            ps.executeUpdate();
        }
    }

    public void insertReducerow(int tpIdx, String title, String titleLink, String rowContent, String rowContentLink) throws Exception {
        String sql = "INSERT INTO reducerow(reducerow_idx, tp_idx, title, title_link, rowcontent, rowcontent_link) VALUES (reducerow_seq.nextval, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tpIdx);
            ps.setString(2, title);
            ps.setString(3, titleLink);
            ps.setString(4, rowContent);
            ps.setString(5, rowContentLink);
            ps.executeUpdate();
        }
    }

    public void updateReducerow(int reducerowIdx, String title, String titleLink, String rowContent, String rowContentLink) throws Exception {
        String sql = "UPDATE reducerow SET title = ?, title_link = ?, rowcontent = ?, rowcontent_link = ? WHERE reducerow_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, titleLink);
            ps.setString(3, rowContent);
            ps.setString(4, rowContentLink);
            ps.setInt(5, reducerowIdx);
            ps.executeUpdate();
        }
    }

    // New Methods
    public YWProductDetailsDto getProductDetails(int tpIdx, int storeIdx) throws Exception {
        String sql = "SELECT p.pd_name, p.pd_content, p.price, l1.lop1_type, l2.lop2_type, l3.lop3_type, po.amount " +
                     "FROM template_products tp INNER JOIN product p ON p.pd_idx = tp.pd_idx " +
                     "INNER JOIN productoption po ON p.pd_idx = po.pd_idx " +
                     "INNER JOIN lowtionop1 l1 ON po.lop1_idx = l1.lop1_idx " +
                     "INNER JOIN lowtionop2 l2 ON po.lop2_idx = l2.lop2_idx " +
                     "INNER JOIN lowtionop3 l3 ON po.lop3_idx = l3.lop3_idx " +
                     "INNER JOIN store_library sl ON p.sl_idx = sl.sl_idx " +
                     "WHERE tp.tp_idx = ? AND store_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tpIdx);
            ps.setInt(2, storeIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    YWProductDetailsDto dto = new YWProductDetailsDto();
                    dto.setPdName(rs.getString("pd_name"));
                    dto.setPdContent(rs.getString("pd_content"));
                    dto.setPrice(rs.getInt("price"));
                    dto.setLop1Type(rs.getString("lop1_type"));
                    dto.setLop2Type(rs.getString("lop2_type"));
                    dto.setLop3Type(rs.getString("lop3_type"));
                    dto.setAmount(rs.getInt("amount"));
                    return dto;
                }
            }
        }
        return null;
    }

    public YWReducerowDto getReducerow(int tpIdx) throws Exception {
        String sql = "SELECT title, title_link, rowcontent, rowcontent_link FROM reducerow WHERE tp_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tpIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    YWReducerowDto dto = new YWReducerowDto();
                    dto.setTitle(rs.getString("title"));
                    dto.setTitleLink(rs.getString("title_link"));
                    dto.setRowContent(rs.getString("rowcontent"));
                    dto.setRowContentLink(rs.getString("rowcontent_link"));
                    return dto;
                }
            }
        }
        return null;
    }

    public int getTionop(int tpIdx, int storeIdx) throws Exception {
        String sql = "SELECT tionop FROM template_products tp INNER JOIN color_scheme cs ON tp.color_idx = cs.color_idx " +
                     "WHERE store_idx = ? AND tp_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            ps.setInt(2, tpIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("tionop");
                }
            }
        }
        return -1;
    }

    public int getButton(int tpIdx, int storeIdx) throws Exception {
        String sql = "SELECT button FROM template_products tp INNER JOIN color_scheme cs ON tp.color_idx = cs.color_idx " +
                     "WHERE store_idx = ? AND tp_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, storeIdx);
            ps.setInt(2, tpIdx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("button");
                }
            }
        }
        return -1;
    }

    public void updateTionop(int tpIdx, int tionop) throws Exception {
        String sql = "UPDATE template_products SET tionop = ? WHERE tp_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tionop);
            ps.setInt(2, tpIdx);
            ps.executeUpdate();
        }
    }

    public void updateButton(int tpIdx, int button) throws Exception {
        String sql = "UPDATE template_products SET button = ? WHERE tp_idx = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, button);
            ps.setInt(2, tpIdx);
            ps.executeUpdate();
        }
    }
}
