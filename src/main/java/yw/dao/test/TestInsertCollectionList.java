package yw.dao.test;

import java.util.Scanner;
import dao.YWCollectionListDao;

public class TestInsertCollectionList {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("제목: ");
        String title = sc.next();
        System.out.print("링크: ");
        String link = sc.next();
        System.out.print("제목 크기 (0작게, 1보통, 2크게): ");
        int titleSize = sc.nextInt();
        System.out.print("비율 (0세로형, 1정사각형): ");
        int ratio = sc.nextInt();
        System.out.print("필드 수 (MIN1, MAX5): ");
        int numberOfField = sc.nextInt();
        System.out.print("전체보기 (0활성화, 1비활성화): ");
        int allview = sc.nextInt();
        
        YWCollectionListDao dao = new YWCollectionListDao();
        dao.insertCollectionList(title, link, titleSize, ratio, numberOfField, allview);
        
        System.out.println("컬렉션 리스트가 성공적으로 추가되었습니다.");
        sc.close();
    }
}