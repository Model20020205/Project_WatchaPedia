package dto;

public class NoticeBarOptionDto {
//	private int nb_idx;
	private int color_idx;
	private int division_line;
	private int automatic_rotation;
	private int rotative_velocity;
	
	public NoticeBarOptionDto(int color_idx,int division_line,int automatic_rotation,int rotative_velocity) {
//		this.nb_idx = nb_idx;
		this.color_idx = color_idx;
		this.division_line = division_line;
		this.automatic_rotation = automatic_rotation;
		this.rotative_velocity = rotative_velocity;
	}

	public int getColor_idx() {
		return color_idx;
	}

	public void setColor_idx(int color_idx) {
		this.color_idx = color_idx;
	}

	public int getDivision_line() {
		return division_line;
	}

	public void setDivision_line(int division_line) {
		this.division_line = division_line;
	}

	public int getAutomatic_rotation() {
		return automatic_rotation;
	}

	public void setAutomatic_rotation(int automatic_rotation) {
		this.automatic_rotation = automatic_rotation;
	}

	public int getRotative_velocity() {
		return rotative_velocity;
	}

	public void setRotative_velocity(int rotative_velocity) {
		this.rotative_velocity = rotative_velocity;
	}
}
