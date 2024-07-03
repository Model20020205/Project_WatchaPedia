package dao.test;

import java.util.Scanner;
import dao.ManyFieldDao;
import dto.ManyFieldDto;

public class TestGetManyField {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("여러 열 IDX: ");
        int mfIdx = sc.nextInt();

        ManyFieldDao dao = new ManyFieldDao();
        ManyFieldDto manyField = dao.getManyField(mfIdx);

        if (manyField != null) {
            System.out.println("제목: " + manyField.getTitle() + ", 제목 링크: " + manyField.getTitleLink() + ", 제목 크기: " + manyField.getTitleSize() +
                               ", 폭: " + manyField.getWidth() + ", 비율: " + manyField.getRatio() + ", 정렬: " + manyField.getLineup() + 
                               ", 배경: " + manyField.getBackground() + ", 버튼 제목: " + manyField.getButtonLabel() + 
                               ", 버튼 링크: " + manyField.getButtonLink() + ", 색상 IDX: " + manyField.getColorIdx());
        } else {
            System.out.println("해당 여러 열을 찾을 수 없습니다.");
        }
        sc.close();
    }
}