package dto;

public class SlideShowDto {
	private int automaticRotation;
    private int rotativeVelocity;
    private int libraryIdx;
    private int colorCombinationIdx;
    private String title;
    private String titleLink;
    private String text;
    private String textLink;
    private String buttonTitle;
    private String buttonLink;
    private int buttonOutline;

    public SlideShowDto(int automaticRotation, int rotativeVelocity, int libraryIdx, int colorCombinationIdx,
                        String title, String titleLink, String text, String textLink,
                        String buttonTitle, String buttonLink, int buttonOutline) {
        this.automaticRotation = automaticRotation;
        this.rotativeVelocity = rotativeVelocity;
        this.libraryIdx = libraryIdx;
        this.colorCombinationIdx = colorCombinationIdx;
        this.title = title;
        this.titleLink = titleLink;
        this.text = text;
        this.textLink = textLink;
        this.buttonTitle = buttonTitle;
        this.buttonLink = buttonLink;
        this.buttonOutline = buttonOutline;
    }

    public int getAutomaticRotation() {
        return automaticRotation;
    }

    public int getRotativeVelocity() {
        return rotativeVelocity;
    }

    public int getLibraryIdx() {
        return libraryIdx;
    }

    public int getColorCombinationIdx() {
        return colorCombinationIdx;
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

    public String getButtonTitle() {
        return buttonTitle;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public int getButtonOutline() {
        return buttonOutline;
    }
}
