package Banking;

public class Customer {

	// Private variables - Encapsulation
	private int customerId;
	private String customerName;
	private String mobileNo;
	private String city;

	// Constructor
	public Customer(int customerId, String customerName, String mobileNo, String city) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.city = city;
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

	// Getter and Setter for mobileNo
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	// Getter and Setter for city
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// Display customer details
	public void displayCustomer() {

		System.out.println("----------------------------");
		System.out.println("Customer ID   : " + customerId);
		System.out.println("Customer Name : " + customerName);
		System.out.println("Mobile No     : " + mobileNo);
		System.out.println("City          : " + city);
		System.out.println("----------------------------");
	}
}
