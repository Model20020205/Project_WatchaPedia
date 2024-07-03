package dto;

public class RecapchaUpdateDto {
	private int recaptcha;
	private int storeIdx;
	
	public RecapchaUpdateDto(int recaptcha, int storeIdx) {
		this.recaptcha = recaptcha;
		this.storeIdx = storeIdx;
	}

	public int getRecaptcha() {
		return recaptcha;
	}

	public void setRecaptcha(int recaptcha) {
		this.recaptcha = recaptcha;
	}

	public int getStoreIdx() {
		return storeIdx;
	}

	public void setStoreIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
}
