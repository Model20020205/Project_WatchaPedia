package dao.test;
//기능 연우-56
import java.util.Scanner;

import dao.ColorDao;

import java.util.ArrayList;
import dto.ColorSchemeDto;

public class TestgetListColor {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		System.out.print("로그인한 스토어IDX : ");
		int storeIdx = sc.nextInt();
		
		ColorDao dao = new ColorDao();
		ArrayList<ColorSchemeDto> colorList = dao.getListColor(storeIdx);
		
		for(ColorSchemeDto ColorSchemeDto : colorList) {
			System.out.println("Color IDX: " + ColorSchemeDto.getColorIdx());
		}
		sc.close();
	}
}