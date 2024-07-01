package project_shopifyJDBC;

//[로고조회] : 스토어 세부정보 첫 화면

public class StoreDetailEditDto { // private는 다른 곳에서 접근 불가 X
	private String upload;	// 컬럼명 들어가야 됨
	private String storeName;
	private String storeNumber;
	private String storeEmail;
	public StoreDetailEditDto(String upload, String storeName, String storeNumber, String storeEmail) {
		super();
		this.upload = upload;
		this.storeName = storeName;
		this.storeNumber = storeNumber;
		this.storeEmail = storeEmail;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
}
