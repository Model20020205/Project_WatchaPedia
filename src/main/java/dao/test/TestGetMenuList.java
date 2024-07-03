package dao.test;

import java.util.List;
import java.util.Scanner;
import dao.ThemeSettingDao;
import dto.MenuListDto;

public class TestGetMenuList {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 IDX: ");
        int muIdx = sc.nextInt();
        
        ThemeSettingDao dao = new ThemeSettingDao();
        List<MenuListDto> menuList = dao.getMenuList(muIdx);
        
        for (MenuListDto menu : menuList) {
            System.out.println("이름: " + menu.getName() + ", 링크: " + menu.getLink() + ", 상위 항목: " + menu.getUpperMul());
        }
        sc.close();
    }
}