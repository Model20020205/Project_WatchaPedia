package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.FloorContentDto;

public class FloorTextDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//바닥글 설정창 출력
	public int FloorTextOption(int ft_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT color_idx " + 
				"FROM floor_text " + 
				"WHERE floor_text_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ft_idx);
		ResultSet rs = pstmt.executeQuery();
		int color_idx = 0;
		if (rs.next()) {
			color_idx = rs.getInt("color_idx");
		}
		return color_idx;
	}
	//바닥글 내용 출력
	public ArrayList<FloorContentDto> getFloorContents(int colorIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<FloorContentDto> floorContents = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT ft.color_idx, fc.title, fc.title_link, fc.text, fc.text_link " +
                         "FROM floor_content fc, floor_text ft " +
                         "WHERE ft.floor_text_idx = fc.floor_text_idx " +
                         "AND ft.color_idx = ? " +
                         "ORDER BY fc.sunseo";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, colorIdx);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                FloorContentDto dto = new FloorContentDto(
                        rs.getInt("color_idx"),
                        rs.getString("title"),
                        rs.getString("title_link"),
                        rs.getString("text"),
                        rs.getString("text_link")
                );
                floorContents.add(dto);
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

        return floorContents;
    }
	//바닥글 내용 변경
	public void updateFloorContent(String title, String titleLink, String text, String textLink, int floorTextIdx, int sunseo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "UPDATE floor_content " +
                         "SET title = ?, title_link = ?, text = ?, text_link = ? " +
                         "WHERE floor_text_idx = ? " +
                         "AND sunseo = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, titleLink);
            pstmt.setString(3, text);
            pstmt.setString(4, textLink);
            pstmt.setInt(5, floorTextIdx);
            pstmt.setInt(6, sunseo);

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
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		
		FloorTextDao dao = new FloorTextDao();
//		int ft_idx = sc.nextInt();
//		System.out.println(dao.FloorTextOption(ft_idx));

        // 입력값 예시 (테스트용으로 하드코딩)
//        int colorIdx = 1; // 색상배합 IDX
//
//        ArrayList<FloorContentDto> floorContents = dao.getFloorContents(colorIdx);
//
//        for (FloorContentDto dto : floorContents) {
//            System.out.println("색상배합 IDX: " + dto.getColorIdx());
//            System.out.println("제목: " + dto.getTitle());
//            System.out.println("제목 링크: " + dto.getTitleLink());
//            System.out.println("텍스트: " + dto.getText());
//            System.out.println("텍스트 링크: " + dto.getTextLink());
//            System.out.println();
//        }
		String title = "새로운 제목";
        String titleLink = "새로운 제목 링크";
        String text = "새로운 텍스트";
        String textLink = "새로운 텍스트 링크";
        int floorTextIdx = 1; // 바닥글 IDX
        int sunseo = 1; // 순서

        dao.updateFloorContent(title, titleLink, text, textLink, floorTextIdx, sunseo);
	}
}
