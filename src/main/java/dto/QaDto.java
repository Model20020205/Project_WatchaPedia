package dto;

public class QaDto {
	private int productInquiryIdx;
	private int orderIdx;
	private String gubun;
	private String title;
	private String content;
	private String productImage;
	private int secretPost;
	private String registerDate;
	private String delYN;
	private String answer;
	private String answerDate;
	public QaDto(int productInquiryIdx, int orderIdx, String gubun, String title, String content, String productImage,
			int secretPost, String registerDate, String delYN, String answer, String answerDate) {
		super();
		this.productInquiryIdx = productInquiryIdx;
		this.orderIdx = orderIdx;
		this.gubun = gubun;
		this.title = title;
		this.content = content;
		this.productImage = productImage;
		this.secretPost = secretPost;
		this.registerDate = registerDate;
		this.delYN = delYN;
		this.answer = answer;
		this.answerDate = answerDate;
	}
	public int getProductInquiryIdx() {
		return productInquiryIdx;
	}
	public void setProductInquiryIdx(int productInquiryIdx) {
		this.productInquiryIdx = productInquiryIdx;
	}
	public int getOrderIdx() {
		return orderIdx;
	}
	public void setOrderIdx(int orderIdx) {
		this.orderIdx = orderIdx;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getSecretPost() {
		return secretPost;
	}
	public void setSecretPost(int secretPost) {
		this.secretPost = secretPost;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getDelYN() {
		return delYN;
	}
	public void setDelYN(String delYN) {
		this.delYN = delYN;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
}
