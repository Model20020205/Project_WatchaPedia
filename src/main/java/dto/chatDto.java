package dto;

public class chatDto {
	private int chatContentIdx;
	private int chatRoomIdx;
	private String chatContent;
	private int writer;
	private String imageUrl;
	private String transmissionTime;
	private int markRead;
	public chatDto(int chatContentIdx, int chatRoomIdx, String chatContent, int writer, String imageUrl,
			String transmissionTime, int markRead) {
		super();
		this.chatContentIdx = chatContentIdx;
		this.chatRoomIdx = chatRoomIdx;
		this.chatContent = chatContent;
		this.writer = writer;
		this.imageUrl = imageUrl;
		this.transmissionTime = transmissionTime;
		this.markRead = markRead;
	}
	public int getChatContentIdx() {
		return chatContentIdx;
	}
	public void setChatContentIdx(int chatContentIdx) {
		this.chatContentIdx = chatContentIdx;
	}
	public int getChatRoomIdx() {
		return chatRoomIdx;
	}
	public void setChatRoomIdx(int chatRoomIdx) {
		this.chatRoomIdx = chatRoomIdx;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTransmissionTime() {
		return transmissionTime;
	}
	public void setTransmissionTime(String transmissionTime) {
		this.transmissionTime = transmissionTime;
	}
	public int getMarkRead() {
		return markRead;
	}
	public void setMarkRead(int markRead) {
		this.markRead = markRead;
	}
}
