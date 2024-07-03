package dao.test;

import java.util.Scanner;
import dao.CollectionListDao;

public class TestInsertCollectionListForm {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("컬렉션 리스트 IDX: ");
        int clIdx = sc.nextInt();
        System.out.print("컬렉션 IDX: ");
        int collectionIdx = sc.nextInt();
        
        CollectionListDao dao = new CollectionListDao();
        dao.insertCollectionListForm(clIdx, collectionIdx);
        
        System.out.println("컬렉션 리스트 폼이 성공적으로 추가되었습니다.");
        sc.close();
    }
}