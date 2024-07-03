package yw.dao.test;

import java.util.List;
import java.util.Scanner;
import dao.YWThemeSettingDao;
import dto.YWMenuListDto;

public class TestGetMenuList {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 IDX: ");
        int muIdx = sc.nextInt();
        
        YWThemeSettingDao dao = new YWThemeSettingDao();
        List<YWMenuListDto> menuList = dao.getMenuList(muIdx);
        
        for (YWMenuListDto menu : menuList) {
            System.out.println("이름: " + menu.getName() + ", 링크: " + menu.getLink() + ", 상위 항목: " + menu.getUpperMul());
        }
        sc.close();
    }
}