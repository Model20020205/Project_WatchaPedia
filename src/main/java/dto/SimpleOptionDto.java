package dto;

public class SimpleOptionDto {
	private int idx;
	private String type;
	private String name;
	
	public SimpleOptionDto(int idx, String type, String name) {
		this.idx = idx;
		this.type = type;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
