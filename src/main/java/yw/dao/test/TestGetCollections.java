package yw.dao.test;

import java.util.List;
import java.util.Scanner;
import dao.YWCollectionListDao;
import dto.YWCollectionListFormDto;

public class TestGetCollections {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        
        YWCollectionListDao dao = new YWCollectionListDao();
        List<YWCollectionListFormDto> collections = dao.getCollections(storeIdx);
        
        for (YWCollectionListFormDto collection : collections) {
            System.out.println("이름: " + collection.getName() + ", 슬라이드 IDX: " + collection.getSlIdx());
        }
        sc.close();
    }
}