package dao.test;

import java.util.Scanner;

import dao.ColorDao;

import java.util.ArrayList;
import dto.ShowColorDto;

public class TestShowColor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 color_idx : ");
        int colorIdx = sc.nextInt();

        ColorDao dao = new ColorDao();
        ArrayList<ShowColorDto> colorList = dao.ShowColor(colorIdx);

        for (ShowColorDto color : colorList) {
            System.out.println("Color IDX: " + color.getColorIdx());
            System.out.println("Background: " + color.getBackground());
            System.out.println("Text: " + color.getText());
            System.out.println("Back Button: " + color.getBackButton());
            System.out.println("Button Label: " + color.getButtonLabel());
            System.out.println("Outline Button: " + color.getOutlineButton());
            System.out.println("---------------------------------");
        }

        sc.close();
    }
}