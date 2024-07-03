package dao.test;
//연우 기능-02
import java.util.Scanner;

import dao.SellerMemberDao;
import dto.PasswordResetDto;

public class TestpasswordReset {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("새비밀번호 입력 : ");
		String newpassword = sc.next();
		System.out.print("로그인한 이메일주소 : ");
		String nowemail = sc.next();
		
		PasswordResetDto changePasswordDto = new PasswordResetDto(newpassword, nowemail);
		SellerMemberDao dao = new SellerMemberDao();
		dao.passwordReset(changePasswordDto);
		System.out.println("업데이트완료");
		sc.close();
	}
}