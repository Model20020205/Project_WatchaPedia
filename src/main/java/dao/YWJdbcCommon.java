package dao;

import java.sql.*;

public class YWJdbcCommon {
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String id = "groupproject";
	private static final String pw = "123456";
	
    public static Connection getConnection() throws Exception {
    	Class.forName(driver);
        return DriverManager.getConnection(url, id, pw);
    }
    
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
}