package dto;

public class YWManyRowDto {
    private int mrIdx;
    private int height;
    private int width;
    private int titlesize;
    private int buttonstyle;
    private int location;
    private int lineup;
    private int disposition;
    private int colorIdx;

    public YWManyRowDto(int height, int width, int titlesize, int buttonstyle, int location, int lineup, int disposition, int colorIdx) {
        this.height = height;
        this.width = width;
        this.titlesize = titlesize;
        this.buttonstyle = buttonstyle;
        this.location = location;
        this.lineup = lineup;
        this.disposition = disposition;
        this.colorIdx = colorIdx;
    }

    // Getters and Setters

    public int getMrIdx() {
        return mrIdx;
    }

    public void setMrIdx(int mrIdx) {
        this.mrIdx = mrIdx;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getTitlesize() {
        return titlesize;
    }

    public void setTitlesize(int titlesize) {
        this.titlesize = titlesize;
    }

    public int getButtonstyle() {
        return buttonstyle;
    }

    public void setButtonstyle(int buttonstyle) {
        this.buttonstyle = buttonstyle;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLineup() {
        return lineup;
    }

    public void setLineup(int lineup) {
        this.lineup = lineup;
    }

    public int getDisposition() {
        return disposition;
    }

    public void setDisposition(int disposition) {
        this.disposition = disposition;
    }

    public int getColorIdx() {
        return colorIdx;
    }

    public void setColorIdx(int colorIdx) {
        this.colorIdx = colorIdx;
    }

    @Override
    public String toString() {
        return "ManyRowDto{" +
                "mrIdx=" + mrIdx +
                ", height=" + height +
                ", width=" + width +
                ", titlesize=" + titlesize +
                ", buttonstyle=" + buttonstyle +
                ", location=" + location +
                ", lineup=" + lineup +
                ", disposition=" + disposition +
                ", colorIdx=" + colorIdx +
                '}';
    }
}