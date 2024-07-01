package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.BoardDto;

public class BoardDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "user0416";
		String dbPw = "pass1234";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
		return conn;
	}
	// ArrayList<BoardDto> 객체의 참조값을 리턴하는 메서드.
	public ArrayList<BoardDto> getBoardListAll() throws Exception {
		// ArrayList<BoardDto> -> 데이터 타입이라고 생각하면 됨
		ArrayList<BoardDto> listRet = new ArrayList<BoardDto>();
		
		String sql = "SELECT * FROM board1 ORDER BY bno DESC";
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int bno = rs.getInt("bno");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String writedate = rs.getString("writedate");
			
			BoardDto dto = new BoardDto(bno, title, content, writer, writedate);
			listRet.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return listRet;
	}
	// getBoardByBno(int) : 게시글 번호(bno)에 해당하는 게시글 dto를 리턴.
	// 파라미터 bno : 게시글 번호
	// 리턴 --> BoardDto 객체(의 참조값)
	// 리턴 --> 게시글 데이터
	public BoardDto getBoardByBno(int bno) throws Exception {
		String sql = "SELECT * FROM board1 WHERE bno = ?";
		
		// Connection 객체 얻기
		Connection conn = getConnection();
		
		// PreparedStatement 객체 얻기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		// rs.next() 등을 사용 ---> 게시글 데이터 읽어오기.
		ResultSet rs = pstmt.executeQuery();
		BoardDto dto = null;
		if(rs.next()) {	// 출력할 데이터가 한 줄이면 if로 사용!
			// int bno = rs.getInt("bno");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String writedate = rs.getString("writedate");
			
			dto = new BoardDto(bno, title, content, writer, writedate);
			
		}
		
		// BoardDto 객체를 리턴.
		return dto;
	}
//	public static void main(String[] args) throws Exception {
//		BoardDao obj = new BoardDao();
//		ArrayList<BoardDto> showAllList = obj.getBoardListAll();
//		
//		for(int i=0; i<=showAllList.size()-1; i++) {
//			System.out.println(showAllList.get(i).getBno());
//			System.out.println(showAllList.get(i).getTitle());
//			System.out.println(showAllList.get(i).getContent());
//			System.out.println(showAllList.get(i).getWriter());
//			System.out.println(showAllList.get(i).getWritedate());
//		}
//	}
}
