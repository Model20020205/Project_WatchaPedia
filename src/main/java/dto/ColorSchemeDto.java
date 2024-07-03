package dto;

public class ColorSchemeDto {
	private int storeIdx;
	
	public ColorSchemeDto() {}
	
	public ColorSchemeDto(int storeIdx) {
		this.storeIdx = storeIdx;
	}
	
	public int getColorIdx() {
		return storeIdx;
	}

	public void setColorIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
}