package dto;

public class YWCollectionListFormDto {
    private String name;
    private int slIdx;

    public YWCollectionListFormDto(String name, int slIdx) {
        this.name = name;
        this.slIdx = slIdx;
    }

    public String getName() {
        return name;
    }

    public int getSlIdx() {
        return slIdx;
    }
}