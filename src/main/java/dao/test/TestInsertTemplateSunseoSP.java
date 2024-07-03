package dao.test;

import java.util.Scanner;
import dao.SpecialProductDao;

public class TestInsertTemplateSunseoSP {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        System.out.print("스페셜 IDX: ");
        int spIdx = sc.nextInt();
        System.out.print("색상 IDX: ");
        int colorIdx = sc.nextInt();
        
        SpecialProductDao dao = new SpecialProductDao();
        dao.insertTemplateSunseo(storeIdx, spIdx, colorIdx);
        
        System.out.println("템플릿 순서가 성공적으로 추가되었습니다.");
        sc.close();
    }
}