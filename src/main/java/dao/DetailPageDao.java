package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.ComProDto;
import dto.DetailPageDto;
import dto.StaffDto;

public class DetailPageDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "watcha1234";
		String pw = "watcha1234";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);

		return conn;
	}
	
	// 영화 상세페이지
	public ArrayList<DetailPageDto> showList(int movie_idx) throws Exception {
		ArrayList<DetailPageDto> list = new ArrayList<DetailPageDto>();
		Connection conn = getConnection();
		String sql = "SELECT \r\n"
				+ "    m.movie_background AS \"영화배경화면\", \r\n"
				+ "    m.movie_title AS \"영화제목\", \r\n"
				+ "    m.release_year AS \"영화개봉년도\",\r\n"
				+ "    g.genre_name AS \"장르\", \r\n"
				+ "    m.movie_time AS \"영화시간\", \r\n"
				+ "    a.age_name AS \"연령\", \r\n"
				+ "    m.poster AS \"영화포스터\", \r\n"
				+ "    m.movie_description AS \"영화설명\", \r\n"
				+ "    ROUND(AVG(s.score), 1) AS \"별점\"\r\n"
				+ "FROM movie m\r\n"
				+ "INNER JOIN genre g ON m.genre_idx = g.genre_idx\r\n"
				+ "INNER JOIN age a ON m.age_idx = a.age_idx\r\n"
				+ "INNER JOIN star s ON m.movie_idx = s.movie_idx\r\n"
				+ "WHERE m.movie_idx = ?\r\n"
				+ "GROUP BY m.movie_background, m.movie_title, m.release_year, g.genre_name, m.movie_time, a.age_name, m.poster, m.movie_description";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, movie_idx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String movie_background = rs.getString("영화배경화면");
			String movie_title = rs.getString("영화제목");
			String release_year = rs.getString("영화개봉년도");
			String genre_name = rs.getString("장르");
			String movie_time = rs.getString("영화시간");
			String age_name = rs.getString("연령");
			String poster = rs.getString("영화포스터");
			String movie_description = rs.getString("영화설명");
			int score = rs.getInt("별점");
			
			DetailPageDto dto = new DetailPageDto(movie_background, movie_title, release_year, genre_name, movie_time, age_name, poster, movie_description, score);
			list.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	
	// 출연/제작 정보 출력
	public ArrayList<StaffDto> showStaff(int movie_idx) throws Exception {
	    ArrayList<StaffDto> staff = new ArrayList<StaffDto>();
	    Connection conn = getConnection();
	    String sql = "SELECT *\r\n"
	    		+ "FROM (\r\n"
	    		+ "    SELECT p.person_name, \r\n"
	    		+ "           r.job, \r\n"
	    		+ "           p.person_img\r\n"
	    		+ "    FROM role r\r\n"
	    		+ "    INNER JOIN person p ON r.role_idx = p.role_idx\r\n"
	    		+ "    INNER JOIN movie_person mp ON p.person_idx = mp.person_idx\r\n"
	    		+ "    WHERE movie_idx = ?\r\n"
	    		+ "    ORDER BY p.person_idx\r\n"
	    		+ ")\r\n"
	    		+ "WHERE ROWNUM <= 12";
	    
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, movie_idx);
	    ResultSet rs = pstmt.executeQuery();
	    
	    while(rs.next()) {
	        String person_name = rs.getString("person_name");
	        String job = rs.getString("job");
	        String person_img = rs.getString("person_img");  // 수정된 참조
	        
	        StaffDto dto = new StaffDto(person_name, job, person_img);
	        staff.add(dto);
	    }
	    
	    rs.close();
	    pstmt.close();
	    conn.close();
	    
	    return staff;
	}
	
	// 코멘트 (평가글 기준 프로필 이미지, 닉네임, 별점)
	public ArrayList<ComProDto> showProfile(int movie_idx) throws Exception {
		ArrayList<ComProDto> profile = new ArrayList<ComProDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM ( "
				+ "    SELECT profile_img, nickname, score, "
				+ "           ROW_NUMBER() OVER (ORDER BY mm_idx ASC) AS rn "
				+ "    FROM ( "
				+ "        SELECT m.profile_img, m.nickname, ROUND(AVG(s.score), 1) AS score, "
				+ "               m.mm_idx "
				+ "        FROM member m "
				+ "        LEFT JOIN evaluation_article ea ON m.mm_idx = ea.mm_idx "
				+ "        LEFT JOIN star s ON ea.mm_idx = s.mm_idx "
				+ "        WHERE ea.movie_idx = ? "
				+ "        GROUP BY m.profile_img, m.nickname, m.mm_idx "
				+ "    ) "
				+ ") "
				+ "WHERE rn BETWEEN 1 AND 8";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, movie_idx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String profile_img = rs.getString("profile_img");
			String nickname = rs.getString("nickname");
			int score = rs.getInt("score");
			
			ComProDto dto = new ComProDto(profile_img, nickname, score);
			profile.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return profile;
	}
}
