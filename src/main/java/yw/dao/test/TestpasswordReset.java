package yw.dao.test;
//연우 기능-02
import java.util.Scanner;

import dao.YWMemberDao;
import dto.YWPasswordResetDto;

public class TestpasswordReset {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("새비밀번호 입력 : ");
		String newpassword = sc.next();
		System.out.print("로그인한 이메일주소 : ");
		String nowemail = sc.next();
		
		YWPasswordResetDto changePasswordDto = new YWPasswordResetDto(newpassword, nowemail);
		YWMemberDao dao = new YWMemberDao();
		dao.passwordReset(changePasswordDto);
		System.out.println("업데이트완료");
		sc.close();
	}
}