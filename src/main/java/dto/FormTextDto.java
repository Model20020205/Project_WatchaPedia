package dto;

public class FormTextDto {
	private String title;
    private String titleLink;
    private String text;
    private String textLink;
    private String button;
    private String buttonLink;
    private String buttonOutline;
    private String button2;
    private String buttonLink2;
    private String buttonOutline2;
    private int colorIdx;

    public FormTextDto(String title, String titleLink, String text, String textLink, String button,
                       String buttonLink, String buttonOutline, String button2, String buttonLink2,
                       String buttonOutline2, int colorIdx) {
        this.title = title;
        this.titleLink = titleLink;
        this.text = text;
        this.textLink = textLink;
        this.button = button;
        this.buttonLink = buttonLink;
        this.buttonOutline = buttonOutline;
        this.button2 = button2;
        this.buttonLink2 = buttonLink2;
        this.buttonOutline2 = buttonOutline2;
        this.colorIdx = colorIdx;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public String getText() {
        return text;
    }

    public String getTextLink() {
        return textLink;
    }

    public String getButton() {
        return button;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public String getButtonOutline() {
        return buttonOutline;
    }

    public String getButton2() {
        return button2;
    }

    public String getButtonLink2() {
        return buttonLink2;
    }

    public String getButtonOutline2() {
        return buttonOutline2;
    }

    public int getColorIdx() {
        return colorIdx;
    }
}

