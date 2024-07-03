package dto;

public class YWColorSchemeDto {
	private int storeIdx;
	
	public YWColorSchemeDto() {}
	
	public YWColorSchemeDto(int storeIdx) {
		this.storeIdx = storeIdx;
	}
	
	public int getColorIdx() {
		return storeIdx;
	}

	public void setColorIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
}