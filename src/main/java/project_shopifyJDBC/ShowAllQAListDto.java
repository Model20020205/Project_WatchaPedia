package project_shopifyJDBC;

public class ShowAllQAListDto {
	private int productInquiryIdx;
	private String answer;
	private int secretPost;
	private String gubun;
	private String title;
	private String email;
	private String registerDate;
	public ShowAllQAListDto(int productInquiryIdx, String answer, int secretPost, String gubun, String title,
			String email, String registerDate) {
		super();
		this.productInquiryIdx = productInquiryIdx;
		this.answer = answer;
		this.secretPost = secretPost;
		this.gubun = gubun;
		this.title = title;
		this.email = email;
		this.registerDate = registerDate;
	}
	public int getProductInquiryIdx() {
		return productInquiryIdx;
	}
	public void setProductInquiryIdx(int productInquiryIdx) {
		this.productInquiryIdx = productInquiryIdx;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSecretPost() {
		return secretPost;
	}
	public void setSecretPost(int secretPost) {
		this.secretPost = secretPost;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
}
