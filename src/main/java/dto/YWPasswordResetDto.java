package dto;

public class YWPasswordResetDto {
	private String newPassword;
	private String nowEmail;
	
	public YWPasswordResetDto() {}
	
	public YWPasswordResetDto(String newPassword, String nowEmail) {
		this.newPassword = newPassword;
		this.nowEmail = nowEmail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNowEmail() {
		return nowEmail;
	}

	public void setNowEmail(String nowEmail) {
		this.nowEmail = nowEmail;
	}
}
