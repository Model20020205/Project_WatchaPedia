package dao.test;

import java.util.Scanner;

import dao.ColorDao;
import dto.ColorUpdateDto;
// 기능 연우 -57
public class TestColorUpdate {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("background : ");
		String background = sc.next();
		System.out.print("text : ");
		String text = sc.next();
		System.out.print("back_button : ");
		String back_button = sc.next();
		System.out.print("button_label : ");
		String button_label = sc.next();
		System.out.print("outline_button : ");
		String outline_button = sc.next();
		System.out.print("수정할 color_idx : ");
		int color_idx = sc.nextInt();
		System.out.print("로그인한 store_idx : ");
		int store_idx = sc.nextInt();
		
		ColorDao dao = new ColorDao();
		ColorUpdateDto CUD = new ColorUpdateDto(background, text, back_button, button_label, outline_button, color_idx, store_idx);
		dao.ColorUpdate(CUD);
		
		System.out.println("업뎃완료");
		sc.close();
	}
}
