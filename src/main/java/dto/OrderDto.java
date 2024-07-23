package dto;

public class OrderDto {
	private String orderNumber;     // 주문번호
    private String orderDate;       // 주문날짜
    private String customer;        // 고객명
    private int totalAmount;        // 총계
    private String orderStatus;     // 주문상태
    private String product;         // 제품명
    private String option1;         // 옵션1
    private String option2;         // 옵션2
    private String option3;         // 옵션3
    private String photoUrl;        // 사진 URL
    private int quantity;           // 주문 수량
    private String address;         // 주소
    private String email;           // 이메일
	public OrderDto(String orderNumber, String orderDate, String customer, int totalAmount, String orderStatus,
			String product, String option1, String option2, String option3, String photoUrl, int quantity,
			String address, String email) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.product = product;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.photoUrl = photoUrl;
		this.quantity = quantity;
		this.address = address;
		this.email = email;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
