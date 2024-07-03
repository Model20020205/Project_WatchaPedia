package yw.dao.test;

import java.util.List;
import java.util.Scanner;
import dao.YWSpecialProductDao;
import dto.YWSpecialProductDetailsDto;

public class TestGetSpecialProductDetails {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스페셜 IDX 번호: ");
        int spIdx = sc.nextInt();
        System.out.print("스토어 IDX 번호: ");
        int storeIdx = sc.nextInt();
        
        YWSpecialProductDao dao = new YWSpecialProductDao();
        List<YWSpecialProductDetailsDto> detailsList = dao.getSpecialProductDetails(spIdx, storeIdx);
        
        for (YWSpecialProductDetailsDto details : detailsList) {
            System.out.println("제품명: " + details.getPdName() + ", 제품사진: " + details.getSlIdx() + ", 가격: " + details.getPrice() +
                               ", 옵션1: " + details.getLop1Type() + ", 옵션2: " + details.getLop2Type() + ", 옵션3: " + details.getLop3Type() +
                               ", 수량: " + details.getAmount());
        }
        sc.close();
    }
}