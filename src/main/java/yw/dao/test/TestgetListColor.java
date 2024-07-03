package yw.dao.test;
//기능 연우-56
import java.util.Scanner;

import dao.YWColorDao;

import java.util.ArrayList;
import dto.YWColorSchemeDto;

public class TestgetListColor {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		System.out.print("로그인한 스토어IDX : ");
		int storeIdx = sc.nextInt();
		
		YWColorDao dao = new YWColorDao();
		ArrayList<YWColorSchemeDto> colorList = dao.getListColor(storeIdx);
		
		for(YWColorSchemeDto ColorSchemeDto : colorList) {
			System.out.println("Color IDX: " + ColorSchemeDto.getColorIdx());
		}
		sc.close();
	}
}