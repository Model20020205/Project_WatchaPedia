package dto;

public class YWLoginResultDto {
	private String email;
	private String password;
	private int count;
	
	public YWLoginResultDto() {}
	
	public YWLoginResultDto(String email, String password, int count) {
		this.email = email;
		this.password = password;
		this.count = count;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
