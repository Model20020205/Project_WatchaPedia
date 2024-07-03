package yw.dao.test;

import java.util.Scanner;
import dao.YWThemeSettingDao;

public class TestCreateMenu {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 이름: ");
        String name = sc.next();
        System.out.print("스토어 IDX: ");
        int storeIdx = sc.nextInt();
        
        YWThemeSettingDao dao = new YWThemeSettingDao();
        dao.createMenu(name, storeIdx);
        
        System.out.println("메뉴가 성공적으로 생성되었습니다.");
        sc.close();
    }
}