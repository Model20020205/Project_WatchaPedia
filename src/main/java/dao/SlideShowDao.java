package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.SlideShowDto;
import dto.SlideShowOptionDto;

public class SlideShowDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//슬라이드 쇼 옵션 업데이트
	void slid_showOptionUpdate(int automatic_rotation, int rotative_velocity, int ss_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE slide_show " + 
				"SET automatic_rotation = ?, " + 
				"rotative_velocity = ? " + 
				"WHERE ss_idx = ?";
		PreparedStatement pstmt = conn.prepareCall(sql);
		pstmt.setInt(1, automatic_rotation);
		pstmt.setInt(2, rotative_velocity);
		pstmt.setInt(3, ss_idx);
		pstmt.executeUpdate();
		conn.close();
	}
	//슬라이드 쇼 옵션창 출력
	public ArrayList<SlideShowOptionDto> SlideShowOption(int ss_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<SlideShowOptionDto> listRet = new ArrayList<SlideShowOptionDto>();
		String sql = "SELECT automatic_rotation, rotative_velocity " + 
				"FROM slide_show " + 
				"WHERE ss_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ss_idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int automatic_rotation = rs.getInt("automatic_rotation");
			int rotative_velocity = rs.getInt("rotative_velocity");
			SlideShowOptionDto dto = new SlideShowOptionDto(automatic_rotation, rotative_velocity);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//슬라이드 쇼 슬라이드 내용 설정
	public void updateSlide(int libraryIdx, int colorCombinationIdx, String title, String titleLink,
            String text, String textLink, String buttonTitle, String buttonLink, int buttonOutline,
            int slideshowIdx, int order) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "UPDATE slide " +
                         "SET sl_idx = ?, color_idx = ?, title = ?, title_link = ?, " +
                         "text = ?, text_link = ?, button = ?, button_link = ?, button_outline = ? " +
                         "WHERE ss_idx = ? AND sunseo = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, libraryIdx);
            pstmt.setInt(2, colorCombinationIdx);
            pstmt.setString(3, title);
            pstmt.setString(4, titleLink);
            pstmt.setString(5, text);
            pstmt.setString(6, textLink);
            pstmt.setString(7, buttonTitle);
            pstmt.setString(8, buttonLink);
            pstmt.setInt(9, buttonOutline);
            pstmt.setInt(10, slideshowIdx);
            pstmt.setInt(11, order);

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
	//
	public ArrayList<SlideShowDto> getSlideShowSlides(int slideShowIdx, int order) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<SlideShowDto> slideShowSlides = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT ss.automatic_rotation, ss.rotative_velocity, s.sl_idx, s.color_idx, " +
                         "s.title, s.title_link, s.text, s.text_link, s.button, s.button_link, s.button_outline " +
                         "FROM slide s, slide_show ss " +
                         "WHERE s.ss_idx = ss.ss_idx " +
                         "AND ss.ss_idx = ? " +
                         "ORDER BY sunseo";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, slideShowIdx);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                SlideShowDto dto = new SlideShowDto(
                        rs.getInt("automatic_rotation"),
                        rs.getInt("rotative_velocity"),
                        rs.getInt("sl_idx"),
                        rs.getInt("color_idx"),
                        rs.getString("title"),
                        rs.getString("title_link"),
                        rs.getString("text"),
                        rs.getString("text_link"),
                        rs.getString("button"),
                        rs.getString("button_link"),
                        rs.getInt("button_outline")
                );
                slideShowSlides.add(dto);
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

        return slideShowSlides;
    }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		int automatic_rotation = sc.nextInt();
//		int rotative_velocity = sc.nextInt();
//		int ss_idx = sc.nextInt();
		
		SlideShowDao dao = new SlideShowDao();
//		dao.slid_showOptionUpdate(automatic_rotation, rotative_velocity, ss_idx);
//		ArrayList<slide_showOptionDto> option = dao.SlideShowOption(ss_idx);
//		for(slide_showOptionDto dto : option) {
//			System.out.println(dto.getAutomatic_rotation());
//			System.out.println(dto.getRotative_velocity());
//		}
//		int libraryIdx = 1;
//        int colorCombinationIdx = 2;
//        String title = "새로운 제목";
//        String titleLink = "https://example.com/title";
//        String text = "새로운 내용";
//        String textLink = "https://example.com/text";
//        String buttonTitle = "새로운 버튼";
//        String buttonLink = "https://example.com/button";
//        int buttonOutline = 0;
//        int slideshowIdx = 2;
//        int order = 2;
//
//        dao.updateSlide(libraryIdx, colorCombinationIdx, title, titleLink, text, textLink,
//                buttonTitle, buttonLink, buttonOutline, slideshowIdx, order);
		int slideShowIdx = 1; 
        int order = 1; 
		ArrayList<SlideShowDto> slideShowSlides = dao.getSlideShowSlides(slideShowIdx, order);

        for (SlideShowDto dto : slideShowSlides) {
            System.out.println("자동 회전: " + dto.getAutomaticRotation());
            System.out.println("회전 속도: " + dto.getRotativeVelocity());
            System.out.println("라이브러리 IDX: " + dto.getLibraryIdx());
            System.out.println("색상배합 IDX: " + dto.getColorCombinationIdx());
            System.out.println("제목: " + dto.getTitle());
            System.out.println("제목 링크: " + dto.getTitleLink());
            System.out.println("텍스트: " + dto.getText());
            System.out.println("텍스트 링크: " + dto.getTextLink());
            System.out.println("버튼 제목: " + dto.getButtonTitle());
            System.out.println("버튼 링크: " + dto.getButtonLink());
            System.out.println("버튼 윤곽: " + dto.getButtonOutline());
            System.out.println();
        }
	}
}
