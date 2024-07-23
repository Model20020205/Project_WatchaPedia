package dto;

public class CollectionBannerDto {
	int color_idx;
	String name;
	int sl_idx;
	public CollectionBannerDto(int color_idx, String name, int sl_idx) {
		super();
		this.color_idx = color_idx;
		this.name = name;
		this.sl_idx = sl_idx;
	}
	public int getColor_idx() {
		return color_idx;
	}
	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSl_idx() {
		return sl_idx;
	}
	public void setSl_idx(int sl_idx) {
		this.sl_idx = sl_idx;
	}
	
}
