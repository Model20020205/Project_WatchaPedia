package dto;

public class YWProductDetailsDto {
    private String pdName;
    private String pdContent;
    private int price;
    private String lop1Type;
    private String lop2Type;
    private String lop3Type;
    private int amount;

    // Getters and Setters
    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdContent() {
        return pdContent;
    }

    public void setPdContent(String pdContent) {
        this.pdContent = pdContent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLop1Type() {
        return lop1Type;
    }

    public void setLop1Type(String lop1Type) {
        this.lop1Type = lop1Type;
    }

    public String getLop2Type() {
        return lop2Type;
    }

    public void setLop2Type(String lop2Type) {
        this.lop2Type = lop2Type;
    }

    public String getLop3Type() {
        return lop3Type;
    }

    public void setLop3Type(String lop3Type) {
        this.lop3Type = lop3Type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}