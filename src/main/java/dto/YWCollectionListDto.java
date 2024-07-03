package dto;

public class YWCollectionListDto {
    private String title;
    private String link;
    private int titleSize;
    private int ratio;
    private int numberOfField;
    private int colorIdx;
    private int allview;

    public YWCollectionListDto(String title, String link, int titleSize, int ratio, int numberOfField, int colorIdx, int allview) {
        this.title = title;
        this.link = link;
        this.titleSize = titleSize;
        this.ratio = ratio;
        this.numberOfField = numberOfField;
        this.colorIdx = colorIdx;
        this.allview = allview;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public int getRatio() {
        return ratio;
    }

    public int getNumberOfField() {
        return numberOfField;
    }

    public int getColorIdx() {
        return colorIdx;
    }

    public int getAllview() {
        return allview;
    }
}