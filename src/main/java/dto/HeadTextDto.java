package dto;

public class HeadTextDto {
	int color_idx;
	int color_idx2;
	int mu_idx;
	
	public HeadTextDto(int color_idx, int color_idx2, int mu_idx) {
		super();
		this.color_idx = color_idx;
		this.color_idx2 = color_idx2;
		this.mu_idx = mu_idx;
	}
	
	public int getColor_idx() {
		return color_idx;
	}
	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}
	public int getColor_idx2() {
		return color_idx2;
	}
	public void setColor_idx2(int color_idx2) {
		this.color_idx2 = color_idx2;
	}
	public int getMu_idx() {
		return mu_idx;
	}
	public void setMu_idx(int mu_idx) {
		this.mu_idx = mu_idx;
	}
	
}
