package dto;

public class YWSpecialProductDetailsDto {
    private String pdName;
    private int slIdx;
    private int price;
    private String lop1Type;
    private String lop2Type;
    private String lop3Type;
    private int amount;

    public YWSpecialProductDetailsDto(String pdName, int slIdx, int price, String lop1Type, String lop2Type, String lop3Type, int amount) {
        this.pdName = pdName;
        this.slIdx = slIdx;
        this.price = price;
        this.lop1Type = lop1Type;
        this.lop2Type = lop2Type;
        this.lop3Type = lop3Type;
        this.amount = amount;
    }

    public String getPdName() {
        return pdName;
    }

    public int getSlIdx() {
        return slIdx;
    }

    public int getPrice() {
        return price;
    }

    public String getLop1Type() {
        return lop1Type;
    }

    public String getLop2Type() {
        return lop2Type;
    }

    public String getLop3Type() {
        return lop3Type;
    }

    public int getAmount() {
        return amount;
    }
}