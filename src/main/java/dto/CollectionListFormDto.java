package dto;

public class CollectionListFormDto {
    private String name;
    private int slIdx;

    public CollectionListFormDto(String name, int slIdx) {
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