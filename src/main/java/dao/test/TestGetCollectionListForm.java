package dao.test;

import java.util.List;
import java.util.Scanner;
import dao.CollectionListDao;
import dto.CollectionListFormDto;

public class TestGetCollectionListForm {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("컬렉션 리스트 IDX: ");
        int clIdx = sc.nextInt();
        
        CollectionListDao dao = new CollectionListDao();
        List<CollectionListFormDto> collectionListForm = dao.getCollectionListForm(clIdx);
        
        for (CollectionListFormDto form : collectionListForm) {
            System.out.println("이름: " + form.getName() + ", 슬라이드 IDX: " + form.getSlIdx());
        }
        sc.close();
    }
}