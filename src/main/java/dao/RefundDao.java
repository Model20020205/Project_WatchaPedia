package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import dto.RefundDto;

class RefundDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
		
		// (1)
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}	
	//환불 사유와 금액 입력
	void Updaterefund(int order_idx, int amounts, String reason) throws Exception{
		Connection conn = getConnection();
		
		String sql = "INSERT INTO refund(order_idx, amounts, reason)" 
		+ "VALUES(?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, order_idx);
		pstmt.setInt(2, amounts);
		pstmt.setString(3, reason);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	//환불창 출력
	public RefundDto refund(int order_idx) throws Exception {
        RefundDto refund = null;

        Connection conn = getConnection();
        String sql = "SELECT o.order_idx AS 주문번호, naljja AS 주문날짜, cm.mm_idx AS 고객, " +
                     "o.total_price AS 총계, status AS 주문상태, pd_idx AS 제품, " +
                     "lop1_idx AS 옵션1, lop2_idx AS 옵션2, lop3_idx AS 옵션3, " +
                     "sl_idx AS 사진, cnt AS 주문수량, address AS 주소, email AS 이메일, " +
                     "amounts AS 환불금액, reason AS 환불사유 " +
                     "FROM orders o, orderitems oi, productoption p, customer_member cm, refund r " +
                     "WHERE o.order_idx = ? " +
                     "AND p.po_idx = oi.po_idx " +
                     "AND o.order_idx = oi.order_idx " +
                     "AND o.mm_idx = cm.mm_idx " +
                     "AND o.order_idx = r.order_idx";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, order_idx);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                refund = new RefundDto(
                    rs.getString("주문번호"),
                    rs.getString("주문날짜"),
                    rs.getString("고객"),
                    rs.getInt("총계"),
                    rs.getString("주문상태"),
                    rs.getString("제품"),
                    rs.getString("옵션1"),
                    rs.getString("옵션2"),
                    rs.getString("옵션3"),
                    rs.getString("사진"),
                    rs.getInt("주문수량"),
                    rs.getString("주소"),
                    rs.getString("이메일"),
                    rs.getInt("환불금액"),
                    rs.getString("환불사유")
                );
            }
        }

        return refund;
}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		System.out.print("onder_idx : ");
//		int onder_idx = sc.nextInt();
//		System.out.print("amounts : ");
//		int amounts = sc.nextInt();
//		System.out.print("reason : ");
//		String reason = sc.next();
		int order_idx = sc.nextInt();
		
		RefundDao dao = new RefundDao();
		RefundDto refund = dao.refund(order_idx);
		
		System.out.println("주문번호: " + refund.getOrderidx());
        System.out.println("주문날짜: " + refund.getOrderDate());
        System.out.println("고객: " + refund.getCustomer());
        System.out.println("총계: " + refund.getTotalAmount());
        System.out.println("주문상태: " + refund.getOrderStatus());
        System.out.println("제품: " + refund.getProduct());
        System.out.println("옵션1: " + refund.getOption1());
        System.out.println("옵션2: " + refund.getOption2());
        System.out.println("옵션3: " + refund.getOption3());
        System.out.println("사진: " + refund.getPhoto());
        System.out.println("주문수량: " + refund.getQuantity());
        System.out.println("주소: " + refund.getAddress());
        System.out.println("이메일: " + refund.getEmail());
        System.out.println("환불금액: " + refund.getAmounts());
        System.out.println("환불사유: " + refund.getReason());
//		dao.Updaterefund(onder_idx, amounts, reason);
//		
//		System.out.println("끗");
		
		
	}

}
