package ZomatoAppCollectionsFramework;

public class Order {

	private int orderId;
	private String customerName;
	private double totalAmount;
	private String status;

	// Default constructor
	public Order() {
	}

	// Parameterized constructor
	public Order(int orderId, String customerName, double totalAmount, String status) {

		this.orderId = orderId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	// Getter and Setter for orderId
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	// Getter and Setter for customerName
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	// Getter and Setter for totalAmount
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	// Getter and Setter for status
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Update order status
	public void updateStatus(String status) {
		this.status = status;
		System.out.println("Order status updated to: " + status);
	}

	// Display order details
	public void displayOrder() {
		System.out.println("\n========== ORDER DETAILS ==========");
		System.out.println("Order ID      : " + orderId);
		System.out.println("Customer Name : " + customerName);
		System.out.println("Total Amount  : Rs. " + totalAmount);
		System.out.println("Order Status  : " + status);
		System.out.println("===================================");
	}

	// toString method
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", totalAmount=" + totalAmount
				+ ", status=" + status + "]";
	}
}
