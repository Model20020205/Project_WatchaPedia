package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import dto.FormTextDto;

public class FormTextDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	//서식있는 텍스트 옵션 변경
	void FromTextOptionUpdate(int color_idx, int ft_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE template_sunseo " + 
				"SET color_idx = ? " + 
				"WHERE ft_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, color_idx);
		pstmt.setInt(2, ft_idx);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	//서식있는 텍스트 옵션 출력
	public int FromTextOption(int ft_idx) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT color_idx " + 
				"FROM template_sunseo " + 
				"WHERE ft_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ft_idx);
		ResultSet rs = pstmt.executeQuery();
		int color_idx = 0;
		if(rs.next()) {
		color_idx = rs.getInt("color_idx");
		}
		return color_idx;
	}
	//서식있는 텍스트 내용 출력
	public FormTextDto getFormText(int formTextIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        FormTextDto dto = null;

        try {
            conn = getConnection();

            String sql = "SELECT ft.title, ft.title_link, ft.text, ft.text_link, " +
                         "ft.button, ft.button_link, ft.button_outline, " +
                         "ft.button_2, ft.button_link_2, ft.button_outline_2, " +
                         "ts.color_idx " +
                         "FROM form_text ft, template_sunseo ts " +
                         "WHERE ft.ft_idx = ts.ft_idx " +
                         "AND ft.ft_idx = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, formTextIdx);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new FormTextDto(
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
	public static void main(String[] args) throws Exception{
	Scanner sc = new Scanner(System.in);
//	int color_idx = sc.nextInt();
//	int ft_idx = sc.nextInt();
//	
	FormTextDao dao = new FormTextDao();
////	dao.FromTextOptionUpdate(color_idx, ft_idx);
//	int ft_idx = sc.nextInt();
//	System.out.print(dao.FromTextOption(ft_idx));
	int formTextIdx = sc.nextInt();
	FormTextDto dto = dao.getFormText(formTextIdx);
	
	System.out.println("Title: " + dto.getTitle());
    System.out.println("Title Link: " + dto.getTitleLink());
    System.out.println("Text: " + dto.getText());
    System.out.println("Text Link: " + dto.getTextLink());
    System.out.println("Button: " + dto.getButton());
    System.out.println("Button Link: " + dto.getButtonLink());
    System.out.println("Button Outline: " + dto.getButtonOutline());
    System.out.println("Button2: " + dto.getButton2());
    System.out.println("Button2 Link: " + dto.getButtonLink2());
    System.out.println("Button2 Outline: " + dto.getButtonOutline2());
    System.out.println("Color Index: " + dto.getColorIdx());
	
	System.out.println("끝");	
	}
}
