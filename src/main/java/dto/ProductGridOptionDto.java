package dto;

public class ProductGridOptionDto {
	int maximum;
	int number_of_field;
	int color_idx;
	public ProductGridOptionDto(int maximum, int number_of_field, int color_idx) {
		super();
		this.maximum = maximum;
		this.number_of_field = number_of_field;
		this.color_idx = color_idx;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getNumber_of_field() {
		return number_of_field;
	}
	public void setNumber_of_field(int number_of_field) {
		this.number_of_field = number_of_field;
	}
	public int getColor_idx() {
		return color_idx;
	}
	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}
	
}
