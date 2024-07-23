package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ImageBannerDto;
import dto.ImageBannerOptionDto;

public class ImageBannerDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//이미지 배너 이미지 변경(업데이트)
	void ImageBannerOptionUpdate(int sl_idx, int sl_idx2, int ib_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE image_banner " + 
				"SET sl_idx =  ?, " + 
				"sl_idx2 = ? " + 
				"WHERE ib_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sl_idx);
		pstmt.setInt(2, sl_idx2);
		pstmt.setInt(3, ib_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//이미지 배너 설정창 출력
	public ArrayList<ImageBannerOptionDto> ImageBannerOption(int ib_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<ImageBannerOptionDto> listRet = new ArrayList<ImageBannerOptionDto>();
		String sql = "SELECT sl_idx, sl_idx2, color_idx " + 
				"FROM image_banner ib, template_sunseo ts " + 
				"WHERE ib.ib_idx = ts.ib_idx " + 
				"AND ib.ib_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ib_idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int sl_idx = rs.getInt("sl_idx");
			int sl_idx2 = rs.getInt("sl_idx2");
			int color_idx = rs.getInt("color_idx");
			ImageBannerOptionDto dto = new ImageBannerOptionDto(sl_idx, sl_idx2, color_idx);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//이미지 배너 옵션 업데이트
	void ImageBannerColorOptionUpdate(int color_idx, int ib_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE template_sunseo " + 
				"SET color_idx = ? " + 
				"WHERE ib_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, color_idx);
		pstmt.setInt(2, ib_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	// 이미지 배너 출력
	public ImageBannerDto getImageBanner(int imageBannerIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ImageBannerDto dto = null;

        try {
            conn = getConnection();

            String sql = "SELECT ib.sl_idx, ib.sl_idx2, ib.title, ib.title_link, ib.text, ib.text_link, " +
                         "ib.button, ib.button_link, ib.button_outline, ib.button_2, ib.button_link_2, " +
                         "ib.button_outline_2, ts.color_idx " +
                         "FROM image_banner ib, template_sunseo ts " +
                         "WHERE ib.ib_idx = ts.ib_idx " +
                         "AND ib.ib_idx = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, imageBannerIdx);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new ImageBannerDto(
                    rs.getInt("sl_idx"),
                    rs.getInt("sl_idx2"),
                    rs.getString("title"),
                    rs.getString("title_link"),
                    rs.getString("text"),
                    rs.getString("text_link"),
                    rs.getString("button"),
                    rs.getString("button_link"),
                    rs.getString("button_outline"),
                    rs.getString("button_2"),
                    rs.getString("button_link_2"),
                    rs.getString("button_outline_2"),
                    rs.getInt("color_idx")
                );
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return dto;
    }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		int sl_idx = sc.nextInt();
//		int sl_idx2 = sc.nextInt();
//		int color_idx = sc.nextInt();
//		int ib_idx = sc.nextInt();
		ImageBannerDao dao = new ImageBannerDao();
//		dao.ImageBannerOptionUpdate(sl_idx, sl_idx2, ib_idx);
//		ArrayList<image_bannerOptionDto> option = dao.ImageBannerOption(ib_idx);
//		for(image_bannerOptionDto dto : option) {
//			System.out.println(dto.getSl_idx());
//			System.out.println(dto.getSl_idx2());
//			System.out.println(dto.getColor_idx());
//		}
//		dao.ImageBannerColorOptionUpdate(color_idx, ib_idx);
		
		int imageBannerIdx = sc.nextInt();
		ImageBannerDto dto = dao.getImageBanner(imageBannerIdx);
		System.out.println("이미지 1 위치: " + dto.getImageIndex());
        System.out.println("이미지 2 위치: " + dto.getImageIndex2());
        System.out.println("제목: " + dto.getTitle());
        System.out.println("제목 링크: " + dto.getTitleLink());
        System.out.println("텍스트: " + dto.getText());
        System.out.println("텍스트 링크: " + dto.getTextLink());
        System.out.println("버튼: " + dto.getButton());
        System.out.println("버튼 링크: " + dto.getButtonLink());
        System.out.println("버튼 윤곽: " + dto.getButtonOutline());
        System.out.println("버튼2: " + dto.getButton2());
        System.out.println("버튼 링크2: " + dto.getButtonLink2());
        System.out.println("버튼 윤곽2: " + dto.getButtonOutline2());
        System.out.println("색상 배합 IDX: " + dto.getColorIndex());
	}
}
