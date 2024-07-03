package yw.dao.test;

import java.util.Scanner;

import dao.YWAnalysisDao;

public class TesttotalOrders {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("로그인한스토어IDX : ");
		int storeIdx = sc.nextInt();
		System.out.print("시작날짜입력 (YYYY-MM-DD) : ");
		String startdate = sc.next();
		System.out.print("종료날짜입력 (YYYY-MM-DD) : ");
		String enddate = sc.next();
		
		YWAnalysisDao dao = new YWAnalysisDao();
        int totalOrders = dao.totalOrders(storeIdx, startdate, enddate);
		System.out.println("총 주문 수 : " + totalOrders);
		sc.close();
	}
}