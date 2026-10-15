package ZomatoAppCollectionsFramework;

public class Customer {

	private int customerId;
	private String customerName;
	private String email;
	private String phone;

	// Default constructor
	public Customer() {
	}

	// Parameterized constructor
	public Customer(int customerId, String customerName, String email, String phone) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
	}

	// Getter and Setter for customerId
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// Getter and Setter for customerName
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	// Getter and Setter for email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Getter and Setter for phone
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// toString method
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email + ", phone="
				+ phone + "]";
	}
}
