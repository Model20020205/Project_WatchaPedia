package dto;

public class YWSellerLoginInformationDto {
	private int userIdx;
	private String email;
	private String name;
	private String password;
	
	public YWSellerLoginInformationDto() {}
	
	public YWSellerLoginInformationDto(int userIdx, String email, String name, String password) {
		this.userIdx = userIdx;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}