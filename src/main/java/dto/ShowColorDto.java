package dto;

public class ShowColorDto {
	private int colorIdx;
	private String background;
    private String text;
    private String backButton;
    private String buttonLabel;
    private String outlineButton;

	public int getColorIdx() {
		return colorIdx;
	}

	public void setColorIdx(int colorIdx) {
		this.colorIdx = colorIdx;
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

	public String getBackButton() {
		return backButton;
	}

	public void setBackButton(String backButton) {
		this.backButton = backButton;
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	public String getOutlineButton() {
		return outlineButton;
	}

	public void setOutlineButton(String outlineButton) {
		this.outlineButton = outlineButton;
	}
	public ShowColorDto(int colorIdx, String background, String text, String backButton, String buttonLabel,
			String outlineButton) {
		super();
		this.colorIdx = colorIdx;
		this.background = background;
		this.text = text;
		this.backButton = backButton;
		this.buttonLabel = buttonLabel;
		this.outlineButton = outlineButton;
	}	
}