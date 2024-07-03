package yw.dao.test;

import java.util.List;
import java.util.Scanner;
import dao.YWManyFieldDao;
import dto.YWFieldDto;

public class TestGetField {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("여러 열 IDX: ");
        int mfIdx = sc.nextInt();
        System.out.print("순서: ");
        int sunseo = sc.nextInt();

        YWManyFieldDao dao = new YWManyFieldDao();
        List<YWFieldDto> fields = dao.getField(mfIdx, sunseo);

        for (YWFieldDto field : fields) {
            System.out.println("슬라이드 IDX: " + field.getSlIdx() + ", 제목: " + field.getTitle() + 
                               ", 제목 링크: " + field.getTitleLink() + ", 설명: " + field.getDescription() + 
                               ", 버튼 제목: " + field.getButtonLabel() + ", 버튼 링크: " + field.getButtonLink());
        }
        sc.close();
    }
}