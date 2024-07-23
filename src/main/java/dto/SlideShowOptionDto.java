package dto;

public class SlideShowOptionDto {
	int automatic_rotation;
	int rotative_velocity;
	public SlideShowOptionDto(int automatic_rotation, int rotative_velocity) {
		super();
		this.automatic_rotation = automatic_rotation;
		this.rotative_velocity = rotative_velocity;
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
