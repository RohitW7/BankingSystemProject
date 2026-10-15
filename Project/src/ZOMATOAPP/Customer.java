package ZOMATOAPP;

public class Customer {
	private int customerId;
	private String customerName;
	private String mobileNumber;
	private String address;

	public Customer() {
	}

	public Customer(int customerId, String customerName, String mobileNumber, String address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer ID: " + customerId + " | Name: " + customerName + " | Mobile: " + mobileNumber + " | Address: "
				+ address;
	}
}
