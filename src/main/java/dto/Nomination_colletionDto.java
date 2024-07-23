package dto;

public class Nomination_colletionDto {
    private String text;
    private String link;
    private int maximumProducts;
    private int numberOfFieldProducts;
    private int colorCombination;
    private int option1;
    private int option2;
    private int option3;
    private String productName;
    private int price;
    private String productState;
    private int productImage;

    public Nomination_colletionDto(String text, String link, int maximumProducts, int numberOfFieldProducts,
            int colorCombination, int option1, int option2, int option3, String productName, int price,
            String productState, int productImage) {
        this.text = text;
        this.link = link;
        this.maximumProducts = maximumProducts;
        this.numberOfFieldProducts = numberOfFieldProducts;
        this.colorCombination = colorCombination;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.productName = productName;
        this.price = price;
        this.productState = productState;
        this.productImage = productImage;
    }

    // 각 필드의 getter 및 setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getMaximumProducts() {
        return maximumProducts;
    }

    public void setMaximumProducts(int maximumProducts) {
        this.maximumProducts = maximumProducts;
    }

    public int getNumberOfFieldProducts() {
        return numberOfFieldProducts;
    }

    public void setNumberOfFieldProducts(int numberOfFieldProducts) {
        this.numberOfFieldProducts = numberOfFieldProducts;
    }

    public int getColorCombination() {
        return colorCombination;
    }

    public void setColorCombination(int colorCombination) {
        this.colorCombination = colorCombination;
    }

    public int getOption1() {
        return option1;
    }

    public void setOption1(int option1) {
        this.option1 = option1;
    }

    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        this.option2 = option2;
    }

    public int getOption3() {
        return option3;
    }

    public void setOption3(int option3) {
        this.option3 = option3;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}

