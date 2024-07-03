package dto;

public class ReducerowDto {
	private int reducerowIdx;
	private int tpIdx;
	private String title;
	private String titleLink;
	private String rowContent;
	private String rowContentLink;
    // Getters and Setters
	
	
    public String getTitle() {
        return title;
    }

    public int getReducerowIdx() {
		return reducerowIdx;
	}

	public void setReducerowIdx(int reducerowIdx) {
		this.reducerowIdx = reducerowIdx;
	}

	public int getTpIdx() {
		return tpIdx;
	}

	public void setTpIdx(int tpIdx) {
		this.tpIdx = tpIdx;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    public String getRowContent() {
        return rowContent;
    }

    public void setRowContent(String rowContent) {
        this.rowContent = rowContent;
    }

    public String getRowContentLink() {
        return rowContentLink;
    }

    public void setRowContentLink(String rowContentLink) {
        this.rowContentLink = rowContentLink;
    }
    @Override
    public String toString() {
        return "ReducerowDto{" +
                "reducerowIdx=" + reducerowIdx +
                ", tpIdx=" + tpIdx +
                ", title='" + title + '\'' +
                ", titleLink='" + titleLink + '\'' +
                ", rowContent='" + rowContent + '\'' +
                ", rowContentLink='" + rowContentLink + '\'' +
                '}';
    }
}