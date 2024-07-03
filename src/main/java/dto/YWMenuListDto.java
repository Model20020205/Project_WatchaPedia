package dto;

public class YWMenuListDto {
    private String name;
    private String link;
    private int upperMul;
    
    public YWMenuListDto(String name, String link, int upperMul) {
        this.name = name;
        this.link = link;
        this.upperMul = upperMul;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public int getUpperMul() {
        return upperMul;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUpperMul(int upperMul) {
        this.upperMul = upperMul;
    }
}