package dto;

public class SimpleProductDto {
	private int pdIdx;    // product idx
	private String pdName;  // 상품이름
	private String pdContent; // 상품설명
	private int price;		// 가격
	private String upload;  // 이미지URL
	
	public SimpleProductDto(int pdIdx, String pdName, String pdContent, int price, String upload) {
		this.pdIdx = pdIdx;
		this.pdName = pdName;
		this.pdContent = pdContent;
		this.price = price;
		this.upload = upload;
	}

	public int getPdIdx() {
		return pdIdx;
	}
	public void setPdIdx(int pdIdx) {
		this.pdIdx = pdIdx;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getPdContent() {
		return pdContent;
	}
	public void setPdContent(String pdContent) {
		this.pdContent = pdContent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	
	
}
