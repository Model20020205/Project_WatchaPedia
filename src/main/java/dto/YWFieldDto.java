package dto;

public class YWFieldDto {
    private int slIdx;
    private String title;
    private String titleLink;
    private String description;
    private String buttonLabel;
    private String buttonLink;

    public YWFieldDto(int slIdx, String title, String titleLink, String description, String buttonLabel, String buttonLink) {
        this.slIdx = slIdx;
        this.title = title;
        this.titleLink = titleLink;
        this.description = description;
        this.buttonLabel = buttonLabel;
        this.buttonLink = buttonLink;
    }
	public int getSlIdx() {
		return slIdx;
	}

	public void setSlIdx(int slIdx) {
		this.slIdx = slIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleLink() {
		return titleLink;
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	public String getButtonLink() {
		return buttonLink;
	}

	public void setButtonLink(String buttonLink) {
		this.buttonLink = buttonLink;
	}

    
}