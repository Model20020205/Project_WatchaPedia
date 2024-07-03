package dao.test;

import java.util.Scanner;

import dao.AnalysisDao;

public class TesttotalPrice {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("로그인한스토어IDX : ");
		int storeIdx = sc.nextInt();
		System.out.print("시작날짜입력 (YYYY-MM-DD) : ");
		String startdate = sc.next();
		System.out.print("종료날짜입력 (YYYY-MM-DD) : ");
		String enddate = sc.next();
		
		AnalysisDao dao = new AnalysisDao();
		int totalprice = dao.totalPrice(storeIdx, startdate, enddate);
		System.out.println("총 금액 : " + totalprice);
		sc.close();
	}
}
