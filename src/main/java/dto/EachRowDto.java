package dto;

public class EachRowDto {
    private int mrIdx;
    private int sunseo;
    private int slIdx;
    private String title;
    private String titleLink;
    private String text;
    private String buttonLabel;
    private String buttonLink;

    public EachRowDto(int mrIdx, int sunseo, int slIdx, String title, String titleLink, String text, String buttonLabel, String buttonLink) {
        this.mrIdx = mrIdx;
        this.sunseo = sunseo;
        this.slIdx = slIdx;
        this.title = title;
        this.titleLink = titleLink;
        this.text = text;
        this.buttonLabel = buttonLabel;
        this.buttonLink = buttonLink;
    }

    // Getters and Setters

    public int getMrIdx() {
        return mrIdx;
    }

    public void setMrIdx(int mrIdx) {
        this.mrIdx = mrIdx;
    }

    public int getSunseo() {
        return sunseo;
    }

    public void setSunseo(int sunseo) {
        this.sunseo = sunseo;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    @Override
    public String toString() {
        return "EachRowDto{" +
                "mrIdx=" + mrIdx +
                ", sunseo=" + sunseo +
                ", slIdx=" + slIdx +
                ", title='" + title + '\'' +
                ", titleLink='" + titleLink + '\'' +
                ", text='" + text + '\'' +
                ", buttonLabel='" + buttonLabel + '\'' +
                ", buttonLink='" + buttonLink + '\'' +
                '}';
    }
}