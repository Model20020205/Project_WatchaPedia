package dto;

public class TextImageOptionDto {
	int sl_idx;
	int image_location;
	int color_idx;
	public TextImageOptionDto(int sl_idx, int image_location, int color_idx) {
		super();
		this.sl_idx = sl_idx;
		this.image_location = image_location;
		this.color_idx = color_idx;
	}
	public int getSl_idx() {
		return sl_idx;
	}
	public void setSl_idx(int sl_idx) {
		this.sl_idx = sl_idx;
	}
	public int getImage_location() {
		return image_location;
	}
	public void setImage_location(int image_location) {
		this.image_location = image_location;
	}
	public int getColor_idx() {
		return color_idx;
	}
	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}
	
}
