package dto;

public class ManyFieldDto {
    private String title;
    private String titleLink;
    private int titleSize;
    private int width;
    private int ratio;
    private int lineup;
    private int background;
    private String buttonLabel;
    private String buttonLink;
    private int colorIdx;

    public ManyFieldDto(String title, String titleLink, int titleSize, int width, int ratio, int lineup, int background, String buttonLabel, String buttonLink, int colorIdx) {
        this.title = title;
        this.titleLink = titleLink;
        this.titleSize = titleSize;
        this.width = width;
        this.ratio = ratio;
        this.lineup = lineup;
        this.background = background;
        this.buttonLabel = buttonLabel;
        this.buttonLink = buttonLink;
        this.colorIdx = colorIdx;
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

	public int getTitleSize() {
		return titleSize;
	}

	public void setTitleSize(int titleSize) {
		this.titleSize = titleSize;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public int getLineup() {
		return lineup;
	}

	public void setLineup(int lineup) {
		this.lineup = lineup;
	}

	public int getBackground() {
		return background;
	}

	public void setBackground(int background) {
		this.background = background;
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

	public int getColorIdx() {
		return colorIdx;
	}

	public void setColorIdx(int colorIdx) {
		this.colorIdx = colorIdx;
	}
}