package dto;

public class preferencesDto {
	private int storeIdx;
	private String storeName;
	private String storeEmail;
	private int logo;
	private int userIdx;
	public preferencesDto(int storeIdx, String storeName, String storeEmail, int logo, int userIdx) {
		super();
		this.storeIdx = storeIdx;
		this.storeName = storeName;
		this.storeEmail = storeEmail;
		this.logo = logo;
		this.userIdx = userIdx;
	}
	public int getStoreIdx() {
		return storeIdx;
	}
	public void setStoreIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public int getLogo() {
		return logo;
	}
	public void setLogo(int logo) {
		this.logo = logo;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
}
