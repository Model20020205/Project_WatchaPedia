package project_shopifyJDBC_Dto;

public class ShowoneQAListDto {
	private String storeName;
	private String answer;
	private String answerDate;
	public ShowoneQAListDto(String storeName, String answer, String answerDate) {
		super();
		this.storeName = storeName;
		this.answer = answer;
		this.answerDate = answerDate;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
