package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.chatDto;

public class chatDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
	
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<chatDto> chatList() throws Exception {
		ArrayList<chatDto> showChat = new ArrayList<chatDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM chat";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int chatContentIdx = rs.getInt("chat_content_idx");
			int chatRoomIdx = rs.getInt("chat_room_idx");
			String chatContent = rs.getString("chat_content");
			int writer = rs.getInt("writer");
			String imageUrl = rs.getString("image_url");
			String transmissionTime = rs.getString("transmission_time");
			int markRead = rs.getInt("mark_read");
			
			chatDto chat = new chatDto(chatContentIdx, chatRoomIdx, chatContent,
					writer, imageUrl, transmissionTime, markRead);
			showChat.add(chat);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return showChat;
	}
}
