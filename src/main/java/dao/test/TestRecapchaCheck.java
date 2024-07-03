package dao.test;

import java.util.Scanner;

import dao.RecapchaDao;

public class TestRecapchaCheck {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("로그인한 스토어IDX : ");
		int store_idx = sc.nextInt();
		RecapchaDao dao = new RecapchaDao();
		int recaptcha = dao.recaptchaCheck(store_idx);
		System.out.println(recaptcha);
		sc.close();
	}
}