package dto;

public class YWTemplateProductsDto {
    private int tpIdx;
    private int colorIdx;
    private int pdIdx;
    private int width;
    private int layout;
    private int location;
    private int zoom;
    private int tionop;
    private int button;

    // Getters and Setters
    public int getTpIdx() {
        return tpIdx;
    }

    public void setTpIdx(int tpIdx) {
        this.tpIdx = tpIdx;
    }

    public int getColorIdx() {
        return colorIdx;
    }

    public void setColorIdx(int colorIdx) {
        this.colorIdx = colorIdx;
    }

    public int getPdIdx() {
        return pdIdx;
    }

    public void setPdIdx(int pdIdx) {
        this.pdIdx = pdIdx;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public int getTionop() {
        return tionop;
    }

    public void setTionop(int tionop) {
        this.tionop = tionop;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }
    @Override
    public String toString() {
        return "TemplateProductsDto{" +
                "tpIdx=" + tpIdx +
                ", colorIdx=" + colorIdx +
                ", pdIdx=" + pdIdx +
                ", width=" + width +
                ", layout=" + layout +
                ", location=" + location +
                ", zoom=" + zoom +
                ", tionop=" + tionop +
                ", button=" + button +
                '}';
    }
}