package dao.test;
// 연우 기능-01
import java.util.Scanner;

import dao.SellerMemberDao;
import dto.LoginResultDto;

public class TestloginResult {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("EMAIL : ");
		String email = sc.next();
		System.out.print("PW : ");
		String password = sc.next();
		SellerMemberDao dao = new SellerMemberDao();
		LoginResultDto loginResult = dao.sellerLogin(email, password);
		if(loginResult.getCount()==1) {
			System.out.println("로그인성공");
		}
		else {
			System.out.println("로그인실패");
		}
		sc.close();
	}
}