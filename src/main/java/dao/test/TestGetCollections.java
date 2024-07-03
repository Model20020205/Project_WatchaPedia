package dao.test;

import java.util.List;
import java.util.Scanner;
import dao.CollectionListDao;
import dto.CollectionListFormDto;

public class TestGetCollections {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        
        CollectionListDao dao = new CollectionListDao();
        List<CollectionListFormDto> collections = dao.getCollections(storeIdx);
        
        for (CollectionListFormDto collection : collections) {
            System.out.println("이름: " + collection.getName() + ", 슬라이드 IDX: " + collection.getSlIdx());
        }
        sc.close();
    }
}