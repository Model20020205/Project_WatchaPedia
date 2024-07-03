package dto;

public class YWAvgPriceDto {
    private int storeIdx;
    private String startDate;
    private String endDate;
    private int avgPrice;

    public YWAvgPriceDto() {}

    public YWAvgPriceDto(int storeIdx, String startDate, String endDate) {
        this.storeIdx = storeIdx;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public YWAvgPriceDto(int storeIdx, String startDate, String endDate, int avgPrice) {
        this.storeIdx = storeIdx;
        this.startDate = startDate;
        this.endDate = endDate;
        this.avgPrice = avgPrice;
    }

    public int getStoreIdx() {
        return storeIdx;
    }

    public void setStoreIdx(int storeIdx) {
        this.storeIdx = storeIdx;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(int avgPrice) {
        this.avgPrice = avgPrice;
    }
}