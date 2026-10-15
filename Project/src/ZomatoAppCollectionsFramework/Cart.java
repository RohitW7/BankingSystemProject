package ZomatoAppCollectionsFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {

	private int cartId;
	private String customerName;
	private List<FoodItem> foodItems;

	// Default constructor
	public Cart() {
		foodItems = new ArrayList<>();
	}

	// Parameterized constructor
	public Cart(int cartId, String customerName) {
		this.cartId = cartId;
		this.customerName = customerName;
		this.foodItems = new ArrayList<>();
	}

	// Getter and Setter for cartId
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	// Getter and Setter for customerName
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	// Getter for foodItems
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	// Add food to cart
	public void addFood(FoodItem food) {
		foodItems.add(food);
		System.out.println(food.getFoodName() + " added to cart.");
	}

	// Remove food from cart using foodId
	public boolean removeFood(int foodId) {
		Iterator<FoodItem> itr = foodItems.iterator();

		while (itr.hasNext()) {
			FoodItem food = itr.next();

			if (food.getFoodId() == foodId) {
				itr.remove();
				System.out.println(food.getFoodName() + " removed from cart.");
				return true;
			}
		}

		System.out.println("Food item not found in cart.");
		return false;
	}

	// Calculate total bill
	public double calculateTotal() {
		double total = 0;

		for (FoodItem food : foodItems) {
			total = total + food.getPrice();
		}

		return total;
	}

	// Display cart
	public void displayCart() {
		System.out.println("\n========== YOUR CART ==========");
		System.out.println("Cart ID: " + cartId);
		System.out.println("Customer Name: " + customerName);

		if (foodItems.isEmpty()) {
			System.out.println("Your cart is empty.");
		} else {
			for (FoodItem food : foodItems) {
				System.out.println(food.getFoodName() + " - Rs. " + food.getPrice());
			}

			System.out.println("--------------------------------");
			System.out.println("Grand Total: Rs. " + calculateTotal());
		}
	}

	// toString method
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerName=" + customerName + ", foodItems=" + foodItems + ", total="
				+ calculateTotal() + "]";
	}
}
