package dao.test;
//기능 연우-03
import java.util.Scanner;

import dao.SellerMemberDao;
import dto.RegisterMemberDto;

public class TestRegisterMember {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("email : ");
		String email = sc.next();
		System.out.print("name : ");
		String name = sc.next();
		System.out.print("pw : ");
		String pw = sc.next();
		
		RegisterMemberDto member = new RegisterMemberDto(email, name, pw);
		SellerMemberDao dao = new SellerMemberDao();
		dao.registerMember(member);
		
		System.out.println("끝");
		sc.close();
	}
}