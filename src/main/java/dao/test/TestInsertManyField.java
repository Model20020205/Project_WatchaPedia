package dao.test;

import java.util.Scanner;
import dao.ManyFieldDao;

public class TestInsertManyField {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("제목: ");
        String title = sc.next();
        System.out.print("제목 링크: ");
        String titleLink = sc.next();
        System.out.print("제목 크기 (0작게, 1보통, 2크게): ");
        int titleSize = sc.nextInt();
        System.out.print("폭 (0열의 1/3폭, 1열의 1/2폭, 2열의 전체 폭): ");
        int width = sc.nextInt();
        System.out.print("비율 (0이미지에 맞춤, 1정사각형): ");
        int ratio = sc.nextInt();
        System.out.print("정렬 (0왼쪽, 1중앙): ");
        int lineup = sc.nextInt();
        System.out.print("배경 (0없음, 1열의 배경으로 표시): ");
        int background = sc.nextInt();
        System.out.print("버튼 제목: ");
        String buttonLabel = sc.next();
        System.out.print("버튼 링크: ");
        String buttonLink = sc.next();

        ManyFieldDao dao = new ManyFieldDao();
        dao.insertManyField(title, titleLink, titleSize, width, ratio, lineup, background, buttonLabel, buttonLink);

        System.out.println("여러 열이 성공적으로 추가되었습니다.");
        sc.close();
    }
}