package dto;

public class ImageBannerOptionDto {
	int sl_idx;
	int sl_idx2;
	int color_idx;
	public ImageBannerOptionDto(int sl_idx, int sl_idx2, int color_idx) {
		super();
		this.sl_idx = sl_idx;
		this.sl_idx2 = sl_idx2;
		this.color_idx = color_idx;
	}
	public int getSl_idx() {
		return sl_idx;
	}
	public void setSl_idx(int sl_idx) {
		this.sl_idx = sl_idx;
	}
	public int getSl_idx2() {
		return sl_idx2;
	}
	public void setSl_idx2(int sl_idx2) {
		this.sl_idx2 = sl_idx2;
	}
	public int getColor_idx() {
		return color_idx;
	}
	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}
	
}
