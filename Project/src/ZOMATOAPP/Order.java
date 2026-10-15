package ZOMATOAPP;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private Customer customer;
	private List<FoodItem> orderedItems;
	private double totalAmount;
	private String status;

	public Order() {
		orderedItems = new ArrayList<>();
		status = "PLACED";
	}

	public Order(int orderId, Customer customer, List<FoodItem> orderedItems) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderedItems = new ArrayList<>(orderedItems);
		this.totalAmount = calculateTotal();
		this.status = "PLACED";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<FoodItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<FoodItem> orderedItems) {
		this.orderedItems = new ArrayList<>(orderedItems);
		this.totalAmount = calculateTotal();
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double calculateTotal() {
		double total = 0;

		for (FoodItem food : orderedItems) {
			total += food.getPrice();
		}

		return total;
	}

	public void updateStatus(String status) {
		this.status = status;
	}

	public void displayBill() {
		System.out.println("\n========== ORDER BILL ==========");
		System.out.println("Order ID: " + orderId);
		System.out.println("Customer ID: " + customer.getCustomerId());
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("Mobile: " + customer.getMobileNumber());
		System.out.println("Address: " + customer.getAddress());
		System.out.println("--------------------------------");

		for (FoodItem food : orderedItems) {
			System.out.println(food.getFoodName() + " - Rs. " + food.getPrice());
		}

		System.out.println("--------------------------------");
		System.out.println("Grand Total: Rs. " + totalAmount);
		System.out.println("Order Status: " + status);
		System.out.println("================================");
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + " | Customer: " + customer.getCustomerName() + " | Customer ID: "
				+ customer.getCustomerId() + " | Total: Rs. " + totalAmount + " | Status: " + status;
	}
}
