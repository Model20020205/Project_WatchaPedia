package dto;

public class RefundDto {
	private String orderidx;
    private String orderDate;
    private String customer;
    private int totalAmount;
    private String orderStatus;
    private String product;
    private String option1;
    private String option2;
    private String option3;
    private String photo;
    private int quantity;
    private String address;
    private String email;
    private int amounts;
    private String reason;
    
	public RefundDto(String orderidx, String orderDate, String customer, int totalAmount, String orderStatus,
			String product, String option1, String option2, String option3, String photo, int quantity, String address,
			String email, int amounts, String reason) {
		super();
		this.orderidx = orderidx;
		this.orderDate = orderDate;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.product = product;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.photo = photo;
		this.quantity = quantity;
		this.address = address;
		this.email = email;
	}

	public String getOrderidx() {
		return orderidx;
	}

	public void setOrderidx(String orderidx) {
		this.orderidx = orderidx;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public int getAmounts() {
		return amounts;
	}

	public void setAmounts(int amounts) {
		this.amounts = amounts;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
    
    
}
