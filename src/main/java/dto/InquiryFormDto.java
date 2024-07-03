package dto;

public class InquiryFormDto {
    private int ifIdx;
    private String title;
    private String titleLink;
    private int titleSize;
    private int colorIdx;

    public InquiryFormDto(int ifIdx, String title, String titleLink, int titleSize, int colorIdx) {
        this.ifIdx = ifIdx;
        this.title = title;
        this.titleLink = titleLink;
        this.titleSize = titleSize;
        this.colorIdx = colorIdx;
    }

    public int getIfIdx() {
        return ifIdx;
    }

    public void setIfIdx(int ifIdx) {
        this.ifIdx = ifIdx;
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

    public int getColorIdx() {
        return colorIdx;
    }

    public void setColorIdx(int colorIdx) {
        this.colorIdx = colorIdx;
    }

    @Override
    public String toString() {
        return "InquiryFormDto{" +
                "ifIdx=" + ifIdx +
                ", title='" + title + '\'' +
                ", titleLink='" + titleLink + '\'' +
                ", titleSize=" + titleSize +
                ", colorIdx=" + colorIdx +
                '}';
    }
}