package dao.test;

import java.util.List;
import java.util.Scanner;
import dao.CollectionListDao;
import dto.CollectionListDto;

public class TestGetCollectionList {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        
        CollectionListDao dao = new CollectionListDao();
        List<CollectionListDto> collectionList = dao.getCollectionList(storeIdx);
        
        for (CollectionListDto collection : collectionList) {
            System.out.println("제목: " + collection.getTitle() + ", 링크: " + collection.getLink() + 
                               ", 제목 크기: " + collection.getTitleSize() + ", 비율: " + collection.getRatio() + 
                               ", 필드 수: " + collection.getNumberOfField() + ", 색상 IDX: " + collection.getColorIdx() + 
                               ", 전체보기: " + collection.getAllview());
        }
        sc.close();
    }
}