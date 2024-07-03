package yw.dao.test;

import java.util.List;
import java.util.Scanner;
import dao.YWCollectionListDao;
import dto.YWCollectionListFormDto;

public class TestGetCollectionListForm {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("컬렉션 리스트 IDX: ");
        int clIdx = sc.nextInt();
        
        YWCollectionListDao dao = new YWCollectionListDao();
        List<YWCollectionListFormDto> collectionListForm = dao.getCollectionListForm(clIdx);
        
        for (YWCollectionListFormDto form : collectionListForm) {
            System.out.println("이름: " + form.getName() + ", 슬라이드 IDX: " + form.getSlIdx());
        }
        sc.close();
    }
}