package yw.dao.test;
// 연우 기능-01
import java.util.Scanner;

import dao.YWMemberDao;
import dto.YWLoginResultDto;

public class TestloginResult {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("EMAIL : ");
		String email = sc.next();
		System.out.print("PW : ");
		String password = sc.next();
		YWMemberDao dao = new YWMemberDao();
		YWLoginResultDto loginResult = dao.sellerLogin(email, password);
		if(loginResult.getCount()==1) {
			System.out.println("로그인성공");
		}
		else {
			System.out.println("로그인실패");
		}
		sc.close();
	}
}