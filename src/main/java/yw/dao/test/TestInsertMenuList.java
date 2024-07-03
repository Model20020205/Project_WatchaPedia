package yw.dao.test;

import java.util.Scanner;
import dao.YWThemeSettingDao;

public class TestInsertMenuList {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 IDX: ");
        int muIdx = sc.nextInt();
        System.out.print("메뉴 리스트 이름: ");
        String name = sc.next();
        System.out.print("링크: ");
        String link = sc.next();
        System.out.print("상위 항목: ");
        int upperMul = sc.nextInt();
        
        YWThemeSettingDao dao = new YWThemeSettingDao();
        dao.insertMenuList(muIdx, name, link, upperMul);
        
        System.out.println("메뉴 리스트가 성공적으로 추가되었습니다.");
        sc.close();
    }
}