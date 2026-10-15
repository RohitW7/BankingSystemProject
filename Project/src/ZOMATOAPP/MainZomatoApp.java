package ZOMATOAPP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainZomatoApp {

	static Scanner sc = new Scanner(System.in);

	static ArrayList<FoodItem> foodMenu = new ArrayList<>();
	static HashMap<Integer, FoodItem> foodMap = new HashMap<>();
	static HashMap<Integer, Customer> customers = new HashMap<>();
	static ArrayList<Order> orders = new ArrayList<>();
	static HashSet<String> categories = new HashSet<>();

	static int nextCustomerId = 501;
	static int nextOrderId = 1001;

	public static void main(String[] args) {

		loadFoodMenu();

		int choice;

		do {
			displayMainMenu();
			choice = readInt("Enter your choice: ");

			switch (choice) {
			case 1:
				displayFoodMenu();
				break;

			case 2:
				searchFood();
				break;

			case 3:
				filterFoodByCategory();
				break;

			case 4:
				sortFoodByPrice();
				break;

			case 5:
				registerCustomer();
				break;

			case 6:
				displayAllCustomers();
				break;

			case 7:
				searchCustomerById();
				break;

			case 8:
				placeOrder();
				break;

			case 9:
				displayAllOrders();
				break;

			case 10:
				displayOrdersByCustomerId();
				break;

			case 11:
				updateOrderStatus();
				break;

			case 12:
				displayUniqueCategories();
				break;

			case 13:
				advancedFoodAnalysis();
				break;

			case 14:
				System.out.println("Thank you for using Zomato!");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}

		} while (choice != 14);

		sc.close();
	}

	// Main menu
	public static void displayMainMenu() {
		System.out.println("\n========== ZOMATO FOOD DELIVERY ==========");
		System.out.println("1. Display Food Menu");
		System.out.println("2. Search Food by ID or Name");
		System.out.println("3. Filter Food by Category");
		System.out.println("4. Sort Food by Price");
		System.out.println("5. Register Customer");
		System.out.println("6. Display All Customers");
		System.out.println("7. Search Customer by ID");
		System.out.println("8. Place Order");
		System.out.println("9. Display All Orders");
		System.out.println("10. Display Orders by Customer ID");
		System.out.println("11. Update Order Status");
		System.out.println("12. Display Unique Food Categories");
		System.out.println("13. Find Top 3 Expensive Food Items");
		System.out.println("14. Exit");
		System.out.println("==========================================");
	}

	// Load sample menu
	public static void loadFoodMenu() {
		addFood(new FoodItem(101, "Veg Pizza", "Pizza", 250));
		addFood(new FoodItem(102, "Chicken Burger", "Burger", 180));
		addFood(new FoodItem(103, "Veg Biryani", "Biryani", 150));
		addFood(new FoodItem(104, "Chicken Biryani", "Biryani", 280));
		addFood(new FoodItem(105, "Masala Dosa", "South Indian", 100));
		addFood(new FoodItem(106, "Paneer Tikka", "Starter", 220));
		addFood(new FoodItem(107, "French Fries", "Snacks", 120));
		addFood(new FoodItem(108, "Cold Coffee", "Beverage", 90));
	}

	public static void addFood(FoodItem food) {
		foodMenu.add(food);
		foodMap.put(food.getFoodId(), food);
		categories.add(food.getCategory());
	}

	// Option 1
	public static void displayFoodMenu() {
		System.out.println("\n========== FOOD MENU ==========");

		if (foodMenu.isEmpty()) {
			System.out.println("No food items available.");
			return;
		}

		for (FoodItem food : foodMenu) {
			System.out.println(food);
		}
	}

	// Option 2
	public static void searchFood() {
		System.out.println("1. Search by Food ID");
		System.out.println("2. Search by Food Name");

		int choice = readInt("Enter choice: ");

		if (choice == 1) {
			int id = readInt("Enter food ID: ");
			FoodItem food = foodMap.get(id);

			if (food != null) {
				System.out.println(food);
			} else {
				System.out.println("Food item not found.");
			}

		} else if (choice == 2) {
			System.out.print("Enter food name: ");
			String name = sc.nextLine().trim();

			boolean found = false;

			for (FoodItem food : foodMenu) {
				if (food.getFoodName().equalsIgnoreCase(name)) {
					System.out.println(food);
					found = true;
				}
			}

			if (!found) {
				System.out.println("Food item not found.");
			}

		} else {
			System.out.println("Invalid search choice.");
		}
	}

	// Option 3
	public static void filterFoodByCategory() {
		System.out.print("Enter category: ");
		String category = sc.nextLine().trim();

		boolean found = false;

		for (FoodItem food : foodMenu) {
			if (food.getCategory().equalsIgnoreCase(category)) {
				System.out.println(food);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No food items found in this category.");
		}
	}

	// Option 4
	public static void sortFoodByPrice() {
		System.out.println("1. Ascending order");
		System.out.println("2. Descending order");

		int choice = readInt("Enter choice: ");

		if (choice == 1) {
			Collections.sort(foodMenu, Comparator.comparingDouble(FoodItem::getPrice));

		} else if (choice == 2) {
			Collections.sort(foodMenu, Comparator.comparingDouble(FoodItem::getPrice).reversed());

		} else {
			System.out.println("Invalid choice.");
			return;
		}

		displayFoodMenu();
	}

	// Option 5
	public static void registerCustomer() {
		System.out.println("\n========== CUSTOMER REGISTRATION ==========");

		System.out.print("Enter customer name: ");
		String name = sc.nextLine().trim();

		System.out.print("Enter mobile number: ");
		String mobile = sc.nextLine().trim();

		System.out.print("Enter address: ");
		String address = sc.nextLine().trim();

		if (name.isEmpty() || mobile.isEmpty() || address.isEmpty()) {
			System.out.println("All customer details are required.");
			return;
		}

		Customer customer = new Customer(nextCustomerId, name, mobile, address);

		customers.put(nextCustomerId, customer);

		System.out.println("Customer registered successfully!");
		System.out.println(customer);

		nextCustomerId++;
	}

	// Option 6
	public static void displayAllCustomers() {
		System.out.println("\n========== REGISTERED CUSTOMERS ==========");

		if (customers.isEmpty()) {
			System.out.println("No customers registered.");
			return;
		}

		for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	// Option 7
	public static void searchCustomerById() {
		int id = readInt("Enter customer ID: ");

		Customer customer = customers.get(id);

		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("Customer not found.");
		}
	}

	// Option 8
	public static void placeOrder() {
		if (customers.isEmpty()) {
			System.out.println("Please register a customer first.");
			return;
		}

		displayAllCustomers();

		int customerId = readInt("Enter customer ID for this order: ");
		Customer customer = customers.get(customerId);

		if (customer == null) {
			System.out.println("Invalid customer ID.");
			return;
		}

		displayFoodMenu();

		ArrayList<FoodItem> selectedItems = new ArrayList<>();

		System.out.println("\nEnter food IDs to add items to the order.");
		System.out.println("Enter 0 when you have finished selecting.");

		while (true) {
			int foodId = readInt("Enter food ID: ");

			if (foodId == 0) {
				break;
			}

			FoodItem food = foodMap.get(foodId);

			if (food != null) {
				selectedItems.add(food);
				System.out.println(food.getFoodName() + " added to your order.");
			} else {
				System.out.println("Invalid food ID. Try again.");
			}
		}

		if (selectedItems.isEmpty()) {
			System.out.println("Order cancelled: no food selected.");
			return;
		}

		Order order = new Order(nextOrderId, customer, selectedItems);

		orders.add(order);

		order.displayBill();

		System.out.println("Order placed successfully!");
		nextOrderId++;
	}

	// Option 9
	public static void displayAllOrders() {
		System.out.println("\n========== ALL ORDERS ==========");

		if (orders.isEmpty()) {
			System.out.println("No orders placed yet.");
			return;
		}

		ArrayList<Order> sortedOrders = new ArrayList<>(orders);

		sortedOrders.sort(Comparator.comparingDouble(Order::getTotalAmount).reversed());

		for (Order order : sortedOrders) {
			System.out.println(order);
		}
	}

	// Option 10
	public static void displayOrdersByCustomerId() {
		int customerId = readInt("Enter customer ID: ");

		if (!customers.containsKey(customerId)) {
			System.out.println("Customer not found.");
			return;
		}

		boolean found = false;

		System.out.println("\n========== CUSTOMER ORDER HISTORY ==========");

		for (Order order : orders) {
			if (order.getCustomer().getCustomerId() == customerId) {
				order.displayBill();
				found = true;
			}
		}

		if (!found) {
			System.out.println("No orders found for this customer.");
		}
	}

	// Option 11
	public static void updateOrderStatus() {
		if (orders.isEmpty()) {
			System.out.println("No orders available.");
			return;
		}

		int id = readInt("Enter order ID: ");
		Order selectedOrder = null;

		for (Order order : orders) {
			if (order.getOrderId() == id) {
				selectedOrder = order;
				break;
			}
		}

		if (selectedOrder == null) {
			System.out.println("Order not found.");
			return;
		}

		String currentStatus = selectedOrder.getStatus();
		String nextStatus;

		switch (currentStatus) {
		case "PLACED":
			nextStatus = "PREPARING";
			break;

		case "PREPARING":
			nextStatus = "OUT_FOR_DELIVERY";
			break;

		case "OUT_FOR_DELIVERY":
			nextStatus = "DELIVERED";
			break;

		case "DELIVERED":
			System.out.println("Order is already delivered.");
			return;

		default:
			System.out.println("Unknown order status.");
			return;
		}

		selectedOrder.updateStatus(nextStatus);

		System.out.println("Order status updated successfully.");
		System.out.println(selectedOrder);
	}

	// Option 12
	public static void displayUniqueCategories() {
		// Rebuild categories from the current menu.
		categories.clear();

		for (FoodItem food : foodMenu) {
			categories.add(food.getCategory());
		}

		System.out.println("\n========== UNIQUE CATEGORIES ==========");

		for (String category : categories) {
			System.out.println(category);
		}
	}

	// Option 13: advanced collection tasks
	public static void advancedFoodAnalysis() {
		if (foodMenu.isEmpty()) {
			System.out.println("No food items available.");
			return;
		}

		ArrayList<FoodItem> sortedFoods = new ArrayList<>(foodMenu);

		sortedFoods.sort(Comparator.comparingDouble(FoodItem::getPrice).reversed());

		System.out.println("\n========== FOOD PRICE ANALYSIS ==========");

		System.out.println("\nMost expensive food:");
		System.out.println(sortedFoods.get(0));

		System.out.println("\nCheapest food:");
		System.out.println(sortedFoods.get(sortedFoods.size() - 1));

		System.out.println("\nTop 3 most expensive food items:");

		int limit = Math.min(3, sortedFoods.size());

		for (int i = 0; i < limit; i++) {
			System.out.println(sortedFoods.get(i));
		}

		System.out.println("\nFood items sorted by descending price:");

		for (FoodItem food : sortedFoods) {
			System.out.println(food);
		}

		// Iterator safely removes items priced below Rs. 100.
		System.out.println("\nRemoving food items below Rs. 100:");

		Iterator<FoodItem> iterator = foodMenu.iterator();

		while (iterator.hasNext()) {
			FoodItem food = iterator.next();

			if (food.getPrice() < 100) {
				System.out.println("Removed: " + food.getFoodName());

				foodMap.remove(food.getFoodId());
				iterator.remove();
			}
		}

		// Rebuild categories after menu changes.
		categories.clear();

		for (FoodItem food : foodMenu) {
			categories.add(food.getCategory());
		}

		System.out.println("\nUpdated food menu:");
		displayFoodMenu();
	}

	// Safe integer input
	public static int readInt(String message) {
		while (true) {
			System.out.print(message);
			String input = sc.nextLine().trim();

			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid whole number.");
			}
		}
	}
}
