package project_shopifyJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
// [1:1 채팅] : 구매자 측 채팅방 열기
public class OpenChatroomDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kimhwan";
		String pw = "kimhwan0205";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<OpenChatroomDto> openChat(int chatRoomIdx) throws Exception {
		ArrayList<OpenChatroomDto> showCustomerChat = new ArrayList<OpenChatroomDto>();
		Connection conn = getConnection();
		String sql = "SELECT chat_content, writer,"
				+ " transmission_time"
				+ " FROM chat"
				+ " WHERE chat_room_idx = ?"
				+ " ORDER BY transmission_time";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, chatRoomIdx);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String chatContent = rs.getString("chat_content");
			int writer = rs.getInt("writer");
			String transmissionTime = rs.getString("transmission_time");
			
			OpenChatroomDto obj = new OpenChatroomDto(chatContent, writer, transmissionTime);
			showCustomerChat.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return showCustomerChat;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("채팅방IDX 입력 : ");
		int chatRoomIdx = sc.nextInt();	// 채팅방IDX 입력
		OpenChatroomDao obj = new OpenChatroomDao();
		ArrayList<OpenChatroomDto> showChatting = obj.openChat(chatRoomIdx);
		
		for(int i=0; i<=showChatting.size()-1; i++) {
			System.out.println(showChatting.get(i).getChatContent());
			System.out.println(showChatting.get(i).getWriter());
			System.out.println(showChatting.get(i).getTransmissionTime());
		}
	}
}
