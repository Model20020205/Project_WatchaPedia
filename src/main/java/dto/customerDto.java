package dto;

public class customerDto {
	private int mmIdx;
	private String name;
	private String email;
	private int password;
	private int storeIdx;
	private String address;
	public customerDto(int mmIdx, String name, String email, int password, int storeIdx, String address) {
		super();
		this.mmIdx = mmIdx;
		this.name = name;
		this.email = email;
		this.password = password;
		this.storeIdx = storeIdx;
		this.address = address;
	}
	public int getMmIdx() {
		return mmIdx;
	}
	public void setMmIdx(int mmIdx) {
		this.mmIdx = mmIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getStoreIdx() {
		return storeIdx;
	}
	public void setStoreIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
