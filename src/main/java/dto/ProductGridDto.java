package dto;

public class ProductGridDto {
	private int maximum;
    private int numberOfField;
    private int colorIdx;
    private String productName;
    private int price;
    private String productDescription;
    private String productState;
    private int productImage;
    private int option1;
    private int option2;
    private int option3;
    private int ccIdx;

    public ProductGridDto(int maximum, int numberOfField, int colorIdx, String productName, int price, String productDescription, String productState, int productImage, int option1, int option2, int option3, int ccIdx) {
        this.maximum = maximum;
        this.numberOfField = numberOfField;
        this.colorIdx = colorIdx;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.productState = productState;
        this.productImage = productImage;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.ccIdx = ccIdx;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getNumberOfField() {
        return numberOfField;
    }

    public int getColorIdx() {
        return colorIdx;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductState() {
        return productState;
    }

    public int getProductImage() {
        return productImage;
    }

    public int getOption1() {
        return option1;
    }

    public int getOption2() {
        return option2;
    }

    public int getOption3() {
        return option3;
    }

    public int getCcIdx() {
        return ccIdx;
    }
}
