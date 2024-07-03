package yw.dao.test;

import java.util.Scanner;

import dao.YWAnalysisDao;

public class TestavgPrice {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("로그인한 스토어 IDX: ");
        int storeIdx = sc.nextInt();
        System.out.print("시작 날짜 입력 (YYYY-MM-DD): ");
        String startDate = sc.next();
        System.out.print("종료 날짜 입력 (YYYY-MM-DD): ");
        String endDate = sc.next();
        
        YWAnalysisDao dao = new YWAnalysisDao();
        int avgTotalPrice = dao.avgPrice(storeIdx, startDate, endDate);
        System.out.println("평균 주문 금액: " + avgTotalPrice);
        
        sc.close();
    }
}