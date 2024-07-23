package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dto.DetailedOrderDto;
import dto.OrderDto;

public class OrderDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "Pro";
		String pw = "1234";
			
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
			
		return conn;
	}
	public ArrayList<OrderDto> getOrderDetails(int orderIDX) throws Exception {
        Connection conn = getConnection();
        ArrayList<OrderDto> orderList = new ArrayList<OrderDto>();
		String sql = "SELECT o.order_idx \"주문번호\", naljja \"주문날짜\", cm.mm_idx \"고객\", o.total_price \"총계\", status \"주문상태\", pd_idx \"제품\", lop1_idx\"옵션1\", lop2_idx\"옵션2\", lop3_idx\"옵션3\", sl_idx \"사진\",cnt \"주문 수량\", address \"주소\", email \"이메일\"\r\n" + 
				"FROM orders o, orderitems oi, productoption p, customer_member cm " + 
				"WHERE o.order_idx = ? " + 
				"AND p.po_idx = oi.po_idx " + 
				"AND o.order_idx = oi.order_idx " + 
				"AND o.mm_idx = cm.mm_idx";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderIDX);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {        
                OrderDto dto = new OrderDto(
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
                        rs.getInt("주문 수량"),     
                        rs.getString("주소"),         
                        rs.getString("이메일")
                	);
                orderList.add(dto);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return orderList;
        }
    }
	//주문상세창 출력
	public DetailedOrderDto getOrderDetails(int customerIdx, int orderIdx) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DetailedOrderDto orderDto = null;

        try {
            conn = getConnection(); // 데이터베이스 연결
            String sql = "SELECT o.order_idx AS \"주문번호\", naljja AS \"주문날짜\", cm.mm_idx AS \"고객\", " +
                         "o.total_price AS \"총계\", status AS \"주문상태\", pd_idx AS \"제품\", " +
                         "lop1_idx AS \"옵션1\", lop2_idx AS \"옵션2\", lop3_idx AS \"옵션3\", " +
                         "sl_idx AS \"사진\", cnt AS \"주문 수량\", address AS \"주소\", email AS \"이메일\", " +
                         "(SELECT COUNT(*) FROM orders WHERE mm_idx = ?) AS \"고객의 총 주문수\" " +
                         "FROM orders o " +
                         "JOIN orderitems oi ON o.order_idx = oi.order_idx " +
                         "JOIN productoption p ON oi.po_idx = p.po_idx " +
                         "JOIN customer_member cm ON o.mm_idx = cm.mm_idx " +
                         "WHERE o.order_idx = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerIdx);
            pstmt.setInt(2, orderIdx);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	orderDto = new DetailedOrderDto(
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
                    rs.getInt("주문 수량"),
                    rs.getString("주소"),
                    rs.getString("이메일"),
                    rs.getInt("고객의 총 주문수")
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
        return orderDto;
    
}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		OrderDao dao = new OrderDao();
//		int order_idx = sc.nextInt();
//		ArrayList<OrderDto> option = dao.getOrderDetails(order_idx);
//		for(OrderDto dto : option) {
//			System.out.println(dto.getOrderNumber());
//			System.out.println(dto.getOrderDate());
//			System.out.println(dto.getCustomer());
//			System.out.println(dto.getTotalAmount());
//			System.out.println(dto.getOrderStatus());
//			System.out.println(dto.getProduct());
//			System.out.println(dto.getOption1());
//			System.out.println(dto.getOption2());
//			System.out.println(dto.getOption3());
//			System.out.println(dto.getPhotoUrl());
//			System.out.println(dto.getQuantity());
//			System.out.println(dto.getAddress());
//			System.out.println(dto.getEmail());
//		}
//		ArrayList<OrderDto> option = dao.getOrderDetails(order_idx);
//		for(DetailedOrderDto dto : option) {
//			System.out.println(dto.getOrderNumber());
//			System.out.println(dto.getOrderDate());
//			System.out.println(dto.getCustomer());
//			System.out.println(dto.getTotalAmount());
//			System.out.println(dto.getOrderStatus());
//			System.out.println(dto.getProduct());
//			System.out.println(dto.getOption1());
//			System.out.println(dto.getOption2());
//			System.out.println(dto.getOption3());
//			System.out.println(dto.getPhotoUrl());
//			System.out.println(dto.getQuantity());
//			System.out.println(dto.getAddress());
//			System.out.println(dto.getEmail());
//		}
		
		int customerIdx = sc.nextInt();
		int orderIdx = sc.nextInt();
		DetailedOrderDto orderDto = dao.getOrderDetails(customerIdx, orderIdx);
		System.out.println("주문번호: " + orderDto.getOrderIdx());
        System.out.println("주문날짜: " + orderDto.getOrderDate());
        System.out.println("고객: " + orderDto.getCustomer());
        System.out.println("총계: " + orderDto.getTotalPrice());
        System.out.println("주문상태: " + orderDto.getOrderStatus());
        System.out.println("제품: " + orderDto.getProduct());
        System.out.println("옵션1: " + orderDto.getOption1());
        System.out.println("옵션2: " + orderDto.getOption2());
        System.out.println("옵션3: " + orderDto.getOption3());
        System.out.println("사진: " + orderDto.getPhoto());
        System.out.println("주문 수량: " + orderDto.getQuantity());
        System.out.println("주소: " + orderDto.getAddress());
        System.out.println("이메일: " + orderDto.getEmail());
        System.out.println("고객의 총 주문수: " + orderDto.getTotalOrdersByCustomer());
		
	}
}
