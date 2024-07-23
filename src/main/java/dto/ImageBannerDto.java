package dto;

public class ImageBannerDto {
	private int imageIndex;
    private int imageIndex2;
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
    private int colorIndex;

    public ImageBannerDto(int imageIndex, int imageIndex2, String title, String titleLink,
                          String text, String textLink, String button, String buttonLink,
                          String buttonOutline, String button2, String buttonLink2,
                          String buttonOutline2, int colorIndex) {
        this.imageIndex = imageIndex;
        this.imageIndex2 = imageIndex2;
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
        this.colorIndex = colorIndex;
    }

    // Getters
    public int getImageIndex() {
        return imageIndex;
    }

    public int getImageIndex2() {
        return imageIndex2;
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

    public String getButton2() {
        return button2;
    }

    public String getButtonLink2() {
        return buttonLink2;
    }

    public String getButtonOutline2() {
        return buttonOutline2;
    }

    public int getColorIndex() {
        return colorIndex;
    }
}
