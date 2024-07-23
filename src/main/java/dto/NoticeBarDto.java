package dto;

public class NoticeBarDto {
	private String content;
	private String link;
	
	public NoticeBarDto(String content, String link) {
		super();
		this.content = content;
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
