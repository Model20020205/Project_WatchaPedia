package dto;

public class YWRecapchaDto {
	private int storeIdx;
	private int recaptcha;
	
	public YWRecapchaDto(int storeIdx, int recaptcha) {
		this.storeIdx = storeIdx;
		this.recaptcha = recaptcha;
	}

	public int getStoreIdx() {
		return storeIdx;
	}

	public void setStoreIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}

	public int getRecaptcha() {
		return recaptcha;
	}

	public void setRecaptcha(int recaptcha) {
		this.recaptcha = recaptcha;
	}
}