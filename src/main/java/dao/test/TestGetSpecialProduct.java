package dao.test;

import java.util.Scanner;
import dao.SpecialProductDao;
import dto.SpecialProductDto;

public class TestGetSpecialProduct {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        System.out.print("특별 제품 IDX: ");
        int specialProductIdx = sc.nextInt();
        
        SpecialProductDao dao = new SpecialProductDao();
        SpecialProductDto specialProduct = dao.getSpecialProduct(storeIdx, specialProductIdx);
        
        if (specialProduct != null) {
            System.out.println("제품 이름: " + specialProduct.getPdName());
            System.out.println("슬라이드 IDX: " + specialProduct.getSlIdx());
            System.out.println("색상 IDX: " + specialProduct.getColorIdx());
            System.out.println("너비: " + specialProduct.getWidth());
            System.out.println("위치: " + specialProduct.getLocation());
            System.out.println("확대/축소: " + specialProduct.getZoom());
            System.out.println("형태: " + specialProduct.getTionop());
            System.out.println("버튼: " + specialProduct.getButton());
        } else {
            System.out.println("특별 제품을 찾을 수 없습니다.");
        }
        sc.close();
    }
}