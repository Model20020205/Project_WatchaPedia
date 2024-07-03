package dto;

public class YWColorUpdateDto {
	private String background;
	private String text;
	private String back_button;
	private String button_label;
	private String outline_button;
	private int color_idx;
	private int store_idx;
	
	
	public int getColor_idx() {
		return color_idx;
	}
	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}
	public int getStore_idx() {
		return store_idx;
	}
	public void setStore_idx(int store_idx) {
		this.store_idx = store_idx;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getBack_button() {
		return back_button;
	}
	public void setBack_button(String back_button) {
		this.back_button = back_button;
	}
	public String getButton_label() {
		return button_label;
	}
	public void setButton_label(String button_label) {
		this.button_label = button_label;
	}
	public String getOutline_button() {
		return outline_button;
	}
	public void setOutline_button(String outline_button) {
		this.outline_button = outline_button;
	}
	public YWColorUpdateDto(String background, String text, String back_button, String button_label,
			String outline_button, int color_idx, int store_idx) {
		super();
		this.background = background;
		this.text = text;
		this.back_button = back_button;
		this.button_label = button_label;
		this.outline_button = outline_button;
		this.color_idx = color_idx;
		this.store_idx = store_idx;
	}
	
	
}