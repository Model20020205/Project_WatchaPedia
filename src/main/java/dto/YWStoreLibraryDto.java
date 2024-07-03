package dto;

public class YWStoreLibraryDto {
    private int slIdx;
    private String upload;
    private int storeIdx;

    public YWStoreLibraryDto(int slIdx, String upload, int storeIdx) {
        this.slIdx = slIdx;
        this.upload = upload;
        this.storeIdx = storeIdx;
    }

    public int getSlIdx() {
        return slIdx;
    }

    public void setSlIdx(int slIdx) {
        this.slIdx = slIdx;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public int getStoreIdx() {
        return storeIdx;
    }

    public void setStoreIdx(int storeIdx) {
        this.storeIdx = storeIdx;
    }

    @Override
    public String toString() {
        return "StoreLibraryDto{" +
                "slIdx=" + slIdx +
                ", upload='" + upload + '\'' +
                ", storeIdx=" + storeIdx +
                '}';
    }
}