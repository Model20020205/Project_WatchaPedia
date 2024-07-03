package dao.test;

import java.util.Scanner;

import dao.ColorDao;
import dto.ColorInsertDto;

public class TestColorInsert {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("로그인한 store_idx : ");
		int store_idx = sc.nextInt();
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
		
		ColorDao dao = new ColorDao();
		ColorInsertDto CID = new ColorInsertDto(store_idx, background, text, back_button, button_label, outline_button);
		dao.ColorInsert(CID);
		
		System.out.println("생성완료");
		sc.close();
	}
}
