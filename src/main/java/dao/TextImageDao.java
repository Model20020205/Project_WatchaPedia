package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.TextImageDto;
import dto.TextImageOptionDto;

public class TextImageDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//텍스트 포함 이미지 설정 변경
	void TextImageOption(int sl_idx, int image_location, int ti_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE text_image " + 
				"SET sl_idx = ?, image_location = ? " + 
				"WHERE ti_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sl_idx);
		pstmt.setInt(2, image_location);
		pstmt.setInt(3, ti_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	// 텍스트 포함 이미지 설정창 출력
	public ArrayList<TextImageOptionDto> text_imageOption(int ti_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<TextImageOptionDto> listRet = new ArrayList<TextImageOptionDto>();
		String sql = "SELECT sl_idx, image_location, color_idx " + 
				"FROM template_sunseo ts, text_image ti " + 
				"WHERE ts.ti_idx = ti.ti_idx " + 
				"AND ti.ti_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ti_idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int sl_idx = rs.getInt("sl_idx");
			int image_location = rs.getInt("image_location");
			int color_idx = rs.getInt("color_idx");
			TextImageOptionDto dto = new TextImageOptionDto(sl_idx, image_location, color_idx);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//텍스트 포함 이미지 색상배합 변경
	void TextImageColorOption(int color_idx, int ti_idx) throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE template_sunseo " + 
				"SET color_idx = ? " + 
				"WHERE ti_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, color_idx);
		pstmt.setInt(2, ti_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//텍스트 포함 이미지 출력
	public TextImageDto getTextImage(int textImageIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TextImageDto dto = null;

        try {
            conn = getConnection();

            String sql = "SELECT ti.image_location, ti.title, ti.title_link, ti.text, ti.text_link, " +
                         "ti.button, ti.button_link, ti.button_outline " +
                         "FROM text_image ti, template_sunseo ts " +
                         "WHERE ti.ti_idx = ts.ti_idx " +
                         "AND ti.ti_idx = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, textImageIdx);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new TextImageDto(
                    rs.getString("image_location"),
                    rs.getString("title"),
                    rs.getString("title_link"),
                    rs.getString("text"),
                    rs.getString("text_link"),
                    rs.getString("button"),
                    rs.getString("button_link"),
                    rs.getString("button_outline")
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
//		int image_location = sc.nextInt();
//		int color_idx = sc.nextInt();
//		int ti_idx = sc.nextInt();
		
		TextImageDao dao = new TextImageDao();
//		dao.TextImageOption(sl_idx,image_location, ti_idx);
//		ArrayList<text_imageOptionDto> option = dao.text_imageOption(ti_idx);
//		for(text_imageOptionDto dto : option) {
//			System.out.println(dto.getSl_idx());
//			System.out.println(dto.getImage_location());
//			System.out.println(dto.getColor_idx());
//		}
		int textImageIdx = sc.nextInt();
		TextImageDto dto = dao.getTextImage(textImageIdx);
		System.out.println("이미지 위치: " + dto.getImageLocation());
        System.out.println("제목: " + dto.getTitle());
        System.out.println("제목 링크: " + dto.getTitleLink());
        System.out.println("텍스트: " + dto.getText());
        System.out.println("텍스트 링크: " + dto.getTextLink());
        System.out.println("버튼: " + dto.getButton());
        System.out.println("버튼 링크: " + dto.getButtonLink());
        System.out.println("버튼 윤곽: " + dto.getButtonOutline());
        
//		dao.TextImageColorOption(color_idx, ti_idx);
		System.out.println("끝");
	}
}
