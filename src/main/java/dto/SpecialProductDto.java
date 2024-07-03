package dto;

public class SpecialProductDto {
    private String pdName;
    private int slIdx;
    private int colorIdx;
    private int width;
    private int location;
    private int zoom;
    private int tionop;
    private int button;

    public SpecialProductDto(String pdName, int slIdx, int colorIdx, int width, int location, int zoom, int tionop, int button) {
        this.pdName = pdName;
        this.slIdx = slIdx;
        this.colorIdx = colorIdx;
        this.width = width;
        this.location = location;
        this.zoom = zoom;
        this.tionop = tionop;
        this.button = button;
    }

    public String getPdName() {
        return pdName;
    }

    public int getSlIdx() {
        return slIdx;
    }

    public int getColorIdx() {
        return colorIdx;
    }

    public int getWidth() {
        return width;
    }

    public int getLocation() {
        return location;
    }

    public int getZoom() {
        return zoom;
    }

    public int getTionop() {
        return tionop;
    }

    public int getButton() {
        return button;
    }
}