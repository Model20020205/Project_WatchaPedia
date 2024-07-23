package dto;

public class TextImageDto {
	private String imageLocation;
    private String title;
    private String titleLink;
    private String text;
    private String textLink;
    private String button;
    private String buttonLink;
    private String buttonOutline;

    public TextImageDto(String imageLocation, String title, String titleLink,
                        String text, String textLink, String button,
                        String buttonLink, String buttonOutline) {
        this.imageLocation = imageLocation;
        this.title = title;
        this.titleLink = titleLink;
        this.text = text;
        this.textLink = textLink;
        this.button = button;
        this.buttonLink = buttonLink;
        this.buttonOutline = buttonOutline;
    }

    // Getters
    public String getImageLocation() {
        return imageLocation;
    }

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
}
