package dto;

public class FloorContentDto {
	 private int colorIdx;
	    private String title;
	    private String titleLink;
	    private String text;
	    private String textLink;

	    public FloorContentDto(int colorIdx, String title, String titleLink, String text, String textLink) {
	        this.colorIdx = colorIdx;
	        this.title = title;
	        this.titleLink = titleLink;
	        this.text = text;
	        this.textLink = textLink;
	    }

	    public int getColorIdx() {
	        return colorIdx;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getTitleLink() {
	        return titleLink;
	    }

	    public String getText() {
	        return text;
	    }

	    public String getTextLink() {
	        return textLink;
	    }
}
