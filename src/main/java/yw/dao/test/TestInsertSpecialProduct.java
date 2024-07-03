package yw.dao.test;

import java.util.Scanner;
import dao.YWSpecialProductDao;

public class TestInsertSpecialProduct {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("제품 IDX: ");
        int pdIdx = sc.nextInt();
        System.out.print("너비 (0작게, 1보통, 2크게): ");
        int width = sc.nextInt();
        System.out.print("위치 (0오른쪽, 1왼쪽): ");
        int location = sc.nextInt();
        System.out.print("확대/축소 (0라이트박스 열기, 1확대/축소 안하기): ");
        int zoom = sc.nextInt();
        System.out.print("형태 (0드롭다운, 1타원형): ");
        int tionop = sc.nextInt();
        System.out.print("버튼 (0동적결제 버튼 활성화, 1비활성화): ");
        int button = sc.nextInt();
        
        YWSpecialProductDao dao = new YWSpecialProductDao();
        dao.insertSpecialProduct(pdIdx, width, location, zoom, tionop, button);
        
        System.out.println("특별 제품이 성공적으로 추가되었습니다.");
        sc.close();
    }
}