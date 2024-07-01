package project_shopifyJDBC;

public class OpenChatroomDto {
	private int chatRoomIdx;
	private String chatContent;
	private int chatContentIdx;
	private int writer;
	private String imgUrl;
	private String transmissionTime;
	private int markRead;
	public OpenChatroomDto(int chatRoomIdx, String chatContent, int chatContentIdx, int writer, String imgUrl,
			String transmissionTime, int markRead) {
		super();
		this.chatRoomIdx = chatRoomIdx;
		this.chatContent = chatContent;
		this.chatContentIdx = chatContentIdx;
		this.writer = writer;
		this.imgUrl = imgUrl;
		this.transmissionTime = transmissionTime;
		this.markRead = markRead;
	}
	public OpenChatroomDto(String chatContent, int writer, String transmissionTime) {
		this.chatContent = chatContent;
		this.writer = writer;
		this.transmissionTime = transmissionTime;
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
	public int getChatContentIdx() {
		return chatContentIdx;
	}
	public void setChatContentIdx(int chatContentIdx) {
		this.chatContentIdx = chatContentIdx;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
