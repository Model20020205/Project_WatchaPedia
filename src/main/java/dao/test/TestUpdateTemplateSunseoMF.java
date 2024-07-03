package dao.test;

import java.util.Scanner;
import dao.ManyFieldDao;

public class TestUpdateTemplateSunseoMF {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("여러 열 IDX: ");
        int mfIdx = sc.nextInt();
        System.out.print("색상 IDX: ");
        int colorIdx = sc.nextInt();

        ManyFieldDao dao = new ManyFieldDao();
        dao.updateTemplateSunseo(mfIdx, colorIdx);

        System.out.println("템플릿 순서가 성공적으로 업데이트되었습니다.");
        sc.close();
    }
}