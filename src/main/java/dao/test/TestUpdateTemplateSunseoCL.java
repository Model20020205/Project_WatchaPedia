package dao.test;

import java.util.Scanner;
import dao.CollectionListDao;

public class TestUpdateTemplateSunseoCL {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        System.out.print("컬렉션 리스트 IDX: ");
        int clIdx = sc.nextInt();
        System.out.print("색상 IDX: ");
        int colorIdx = sc.nextInt();
        
        CollectionListDao dao = new CollectionListDao();
        dao.updateTemplateSunseo(storeIdx, clIdx, colorIdx);
        
        System.out.println("템플릿 순서가 성공적으로 업데이트되었습니다.");
        sc.close();
    }
}