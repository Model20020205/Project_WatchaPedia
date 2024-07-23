package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.NoticeBarDto;
import dto.NoticeBarOptionDto;

public class NoticeBarDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//공지표시줄 블라인더 처리
	void notice_barBlind(int nb_idx, int sunseo, int blind) throws Exception{
		Connection conn = getConnection();
			
		String sql = "UPDATE notice_bar_idx " + 
					"SET blind = ? " + 
					"WHERE nb_idx = ? " + 
					"AND sunseo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, blind);
		pstmt.setInt(2, nb_idx);
		pstmt.setInt(3, sunseo);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		}
	//공지 표시줄 삭제 표시
	void notice_barDel(int nb_idx, int sunseo, int sakjae) throws Exception{
		Connection conn = getConnection();
		
		String sql = "UPDATE notice_bar_idx " + 
				"SET sakjae = ? " + 
				"WHERE nb_idx = ? " + 
				"AND sunseo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sakjae);
		pstmt.setInt(2, nb_idx);
		pstmt.setInt(3, sunseo);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	// 공지표시줄 내용 추가
	void notice_barInsert(int nb_idx) throws Exception{
		Connection conn = getConnection();
		
		String sql = "INSERT INTO notice_bar_idx(nb_idx, sunseo) " + 
				"VALUES (?,  + (SELECT COUNT (sunseo)+ 1 " + 
				"FROM notice_bar_idx " + 
				"WHERE nb_idx = ?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, nb_idx);
		pstmt.setInt(2, nb_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//공지표시줄 내용(링크) 변경
	void notice_barUpdateContent(String content, String link,int nb_idx, int sunseo) throws Exception{
		Connection conn = getConnection();
		
		String sql = "UPDATE notice_bar_idx " + 
				"SET content = ?, " +
				"link = ?" +  
				"WHERE nb_idx = ? " + 
				"AND sunseo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setString(2, link);
		pstmt.setInt(3,nb_idx);
		pstmt.setInt(4,sunseo);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//공지표시줄 설정 변경
	void optionUpdate(int nb_idx, int color_idx, int division_line, int automatic_rotation, int rotative_velocity) throws Exception{
		Connection conn = getConnection();
		
		String sql = "UPDATE notice_bar " + 
				"SET color_idx = ?, division_line = ?, " + 
				"automatic_rotation = ?, rotative_velocity = ? " + 
				"WHERE nb_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, color_idx);
		pstmt.setInt(2, division_line);
		pstmt.setInt(3, automatic_rotation);
		pstmt.setInt(4, rotative_velocity);
		pstmt.setInt(5, nb_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//공지표시줄 옵션창 데이터 출력
	public ArrayList<NoticeBarOptionDto> NoticBarOption(int nb_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<NoticeBarOptionDto> listRet = new ArrayList<NoticeBarOptionDto>();
		String sql = "SELECT n.color_idx, division_line, automatic_rotation, rotative_velocity " 
				+ "FROM notice_bar n, color_scheme c " 
				+ "WHERE nb_idx = ? "  
				+ "AND n.color_idx = c.color_idx";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, nb_idx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int color_idx = rs.getInt("color_idx");
			int division_line = rs.getInt("division_line");
			int automatic_rotation = rs.getInt("automatic_rotation"); 
			int rotative_velocity = rs.getInt("rotative_velocity");
			NoticeBarOptionDto dto = new NoticeBarOptionDto(color_idx, division_line, automatic_rotation, rotative_velocity);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	// 공지표시줄 내용 데이터 출력
	public ArrayList<NoticeBarDto> noticebar(int nb_idx) throws Exception {
		Connection conn = getConnection();
		ArrayList<NoticeBarDto> listRet = new ArrayList<NoticeBarDto>();
		String sql = "SELECT content, link " + 
				"FROM notice_bar_idx " + 
				"WHERE nb_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, nb_idx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String content = rs.getString("content");
			String link = rs.getString("link");
			NoticeBarDto dto = new NoticeBarDto(content, link);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	//공지표시줄 한 줄만 출력
	public ArrayList<NoticeBarDto> notice_bar2(int nb_idx, int sunseo) throws Exception {
		Connection conn = getConnection();
		ArrayList<NoticeBarDto> listRet = new ArrayList<NoticeBarDto>();
		String sql = "SELECT content, link "
				+ "FROM notice_bar_idx "
				+ "WHERE nb_idx = ? "
				+ "AND sunseo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, nb_idx);
		pstmt.setInt(2, sunseo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String content = rs.getString("content");
			String link = rs.getString("link");
			NoticeBarDto dto = new NoticeBarDto(content, link);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return listRet;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("nb_idx : ");
		int nb_idx = sc.nextInt();
		System.out.print("sunseo : ");
		int sunseo = sc.nextInt();
		NoticeBarDao dao = new NoticeBarDao();
//		dao.notice_barInsert(nb_idx);
		ArrayList<NoticeBarDto> listRet = dao.notice_bar2(nb_idx,sunseo);
		for(NoticeBarDto dto : listRet) {
			System.out.println(dto.getContent());
			System.out.println(dto.getLink());
		}
//		
		
	}
	
}
	
