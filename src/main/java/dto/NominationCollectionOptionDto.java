package dto;

public class NominationCollectionOptionDto {
	String title;
	String link;
	int cc_idx;
	int maximum;
	int number_of_field;
	int color_idx;
	
	public NominationCollectionOptionDto(String title, String link, int cc_idx, int maximum, int number_of_field,
			int color_idx) {
		super();
		this.title = title;
		this.link = link;
		this.cc_idx = cc_idx;
		this.maximum = maximum;
		this.number_of_field = number_of_field;
		this.color_idx = color_idx;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getCc_idx() {
		return cc_idx;
	}
	public void setCc_idx(int cc_idx) {
		this.cc_idx = cc_idx;
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
