package dto;

public class VideoDto {
    private int videoIdx;
    private String title;
    private String titleLink;
    private int titleSize;
    private int videoLoop;
    private int slIdx;
    private String videoUrl;
    private int colorIdx;

    public VideoDto(int videoIdx, String title, String titleLink, int titleSize, int videoLoop, int slIdx, String videoUrl, int colorIdx) {
        this.videoIdx = videoIdx;
        this.title = title;
        this.titleLink = titleLink;
        this.titleSize = titleSize;
        this.videoLoop = videoLoop;
        this.slIdx = slIdx;
        this.videoUrl = videoUrl;
        this.colorIdx = colorIdx;
    }

    public int getVideoIdx() {
        return videoIdx;
    }

    public void setVideoIdx(int videoIdx) {
        this.videoIdx = videoIdx;
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

    public int getVideoLoop() {
        return videoLoop;
    }

    public void setVideoLoop(int videoLoop) {
        this.videoLoop = videoLoop;
    }

    public int getSlIdx() {
        return slIdx;
    }

    public void setSlIdx(int slIdx) {
        this.slIdx = slIdx;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getColorIdx() {
        return colorIdx;
    }

    public void setColorIdx(int colorIdx) {
        this.colorIdx = colorIdx;
    }

    @Override
    public String toString() {
        return "VideoDto{" +
                "videoIdx=" + videoIdx +
                ", title='" + title + '\'' +
                ", titleLink='" + titleLink + '\'' +
                ", titleSize=" + titleSize +
                ", videoLoop=" + videoLoop +
                ", slIdx=" + slIdx +
                ", videoUrl='" + videoUrl + '\'' +
                ", colorIdx=" + colorIdx +
                '}';
    }
}