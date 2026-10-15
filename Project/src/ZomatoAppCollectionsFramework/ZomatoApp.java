package ZomatoAppCollectionsFramework;

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

public class ZomatoApp {

	static Scanner sc = new Scanner(System.in);

	static List<FoodItem> foodMenu = new ArrayList<>();
	static Map<Integer, FoodItem> foodMap = new HashMap<>();
	static Map<Integer, String> customers = new HashMap<>();
	static List<Order> orders = new ArrayList<>();
	static Set<String> categories = new HashSet<>();

	static Cart cart;
	static int nextOrderId = 1001;
	static int customerId = 1;

	public static void main(String[] args) {

		loadFoodMenu();

		System.out.println("========== ZOMATO FOOD DELIVERY ==========");
		System.out.print("Enter customer name: ");
		String customerName = sc.nextLine();

		customers.put(customerId, customerName);
		cart = new Cart(customerId, customerName);

		int choice;

		do {
			displayMainMenu();

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				displayFoodMenu();
				break;

			case 2:
				searchFoodById();
				break;

			case 3:
				searchFoodByName();
				break;

			case 4:
				filterFoodByCategory();
				break;

			case 5:
				sortFoodByPrice();
				break;

			case 6:
				addFoodToCart();
				break;

			case 7:
				removeFoodFromCart();
				break;

			case 8:
				cart.displayCart();
				break;

			case 9:
				System.out.println("Total Bill: Rs. " + cart.calculateTotal());
				break;

			case 10:
				placeOrder();
				break;

			case 11:
				displayOrderHistory();
				break;

			case 12:
				updateOrderStatus();
				break;

			case 13:
				displayUniqueCategories();
				break;

			case 14:
				displayTopThreeExpensiveFood();
				break;

			case 15:
				removeFoodBelow100();
				break;

			case 16:
				displayOrdersByBillDescending();
				break;

			case 17:
				displayCustomers();
				break;

			case 18:
				System.out.println("Thank you for using Zomato!");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}

		} while (choice != 18);

		sc.close();
	}

	// Load sample food items
	public static void loadFoodMenu() {

		foodMenu.add(new FoodItem(101, "Veg Pizza", "Pizza", 250));
		foodMenu.add(new FoodItem(102, "Chicken Burger", "Burger", 180));
		foodMenu.add(new FoodItem(103, "Veg Biryani", "Biryani", 150));
		foodMenu.add(new FoodItem(104, "Chicken Biryani", "Biryani", 280));
		foodMenu.add(new FoodItem(105, "Masala Dosa", "South Indian", 100));
		foodMenu.add(new FoodItem(106, "Paneer Tikka", "Starter", 220));
		foodMenu.add(new FoodItem(107, "French Fries", "Snacks", 120));
		foodMenu.add(new FoodItem(108, "Cold Coffee", "Beverage", 90));

		for (FoodItem food : foodMenu) {
			foodMap.put(food.getFoodId(), food);
			categories.add(food.getCategory());
		}
	}

	// Display main menu
	public static void displayMainMenu() {

		System.out.println("\n========== ZOMATO FOOD DELIVERY ==========");
		System.out.println("1. Display Food Menu");
		System.out.println("2. Search Food by ID");
		System.out.println("3. Search Food by Name");
		System.out.println("4. Filter Food by Category");
		System.out.println("5. Sort Food by Price");
		System.out.println("6. Add Food to Cart");
		System.out.println("7. Remove Food from Cart");
		System.out.println("8. Display Cart");
		System.out.println("9. Calculate Total Bill");
		System.out.println("10. Place Order");
		System.out.println("11. Display Order History");
		System.out.println("12. Update Order Status");
		System.out.println("13. Display Unique Food Categories");
		System.out.println("14. Find Top 3 Expensive Food Items");
		System.out.println("15. Remove Food Priced Below Rs. 100");
		System.out.println("16. Sort Orders by Bill (Descending)");
		System.out.println("17. Display Registered Customers");
		System.out.println("18. Exit");
		System.out.println("==========================================");
	}

	// 1. Display food menu
	public static void displayFoodMenu() {

		System.out.println("\n========== FOOD MENU ==========");

		for (FoodItem food : foodMenu) {
			System.out.println(food);
		}
	}

	// 2. Search food by ID
	public static void searchFoodById() {

		System.out.print("Enter food ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		FoodItem food = foodMap.get(id);

		if (food != null) {
			System.out.println("Food found: " + food);
		} else {
			System.out.println("Food item not found.");
		}
	}

	// 3. Search food by name
	public static void searchFoodByName() {

		System.out.print("Enter food name: ");
		String name = sc.nextLine();

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
	}

	// 4. Filter food by category
	public static void filterFoodByCategory() {

		System.out.print("Enter category: ");
		String category = sc.nextLine();

		boolean found = false;

		for (FoodItem food : foodMenu) {

			if (food.getCategory().equalsIgnoreCase(category)) {
				System.out.println(food);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No food found in this category.");
		}
	}

	// 5. Sort food by price
	public static void sortFoodByPrice() {

		Collections.sort(foodMenu, new Comparator<FoodItem>() {

			@Override
			public int compare(FoodItem f1, FoodItem f2) {
				return Double.compare(f1.getPrice(), f2.getPrice());
			}
		});

		System.out.println("\nFood items sorted by price:");

		displayFoodMenu();
	}

	// 6. Add food to cart
	public static void addFoodToCart() {

		System.out.print("Enter food ID to add: ");
		int id = sc.nextInt();
		sc.nextLine();

		FoodItem food = foodMap.get(id);

		if (food != null) {
			cart.addFood(food);
		} else {
			System.out.println("Invalid food ID.");
		}
	}

	// 7. Remove food from cart
	public static void removeFoodFromCart() {

		System.out.print("Enter food ID to remove: ");
		int id = sc.nextInt();
		sc.nextLine();

		cart.removeFood(id);
	}

	// 10. Place order
	public static void placeOrder() {

		if (cart.getFoodItems().isEmpty()) {
			System.out.println("Your cart is empty. Add food first.");
			return;
		}

		cart.displayCart();

		double total = cart.calculateTotal();

		Order order = new Order(nextOrderId, cart.getCustomerName(), total, "PLACED");

		orders.add(order);

		System.out.println("\nOrder placed successfully!");
		System.out.println("Order ID: " + nextOrderId);
		System.out.println("Order Status: PLACED");

		order.displayOrder();

		nextOrderId++;

		// Empty cart after successful order
		cart.getFoodItems().clear();
	}

	// 11. Display order history
	public static void displayOrderHistory() {

		System.out.println("\n========== ORDER HISTORY ==========");

		boolean found = false;

		for (Order order : orders) {

			if (order.getCustomerName().equalsIgnoreCase(cart.getCustomerName())) {

				order.displayOrder();
				found = true;
			}
		}

		if (!found) {
			System.out.println("No orders found.");
		}
	}

	// 12. Update order status
	public static void updateOrderStatus() {

		System.out.print("Enter order ID: ");
		int id = sc.nextInt();
		sc.nextLine();

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

		switch (currentStatus) {

		case "PLACED":
			selectedOrder.updateStatus("PREPARING");
			break;

		case "PREPARING":
			selectedOrder.updateStatus("OUT_FOR_DELIVERY");
			break;

		case "OUT_FOR_DELIVERY":
			selectedOrder.updateStatus("DELIVERED");
			break;

		case "DELIVERED":
			System.out.println("Order has already been delivered.");
			break;

		default:
			System.out.println("Unknown order status.");
		}

		selectedOrder.displayOrder();
	}

	// 13. Display unique categories
	public static void displayUniqueCategories() {

		System.out.println("\n========== FOOD CATEGORIES ==========");

		for (String category : categories) {
			System.out.println(category);
		}
	}

	// 14. Display top three expensive food items
	public static void displayTopThreeExpensiveFood() {

		List<FoodItem> sortedList = new ArrayList<>(foodMenu);

		Collections.sort(sortedList, new Comparator<FoodItem>() {

			@Override
			public int compare(FoodItem f1, FoodItem f2) {
				return Double.compare(f2.getPrice(), f1.getPrice());
			}
		});

		System.out.println("\n========== TOP 3 EXPENSIVE FOOD ITEMS ==========");

		int count = 0;

		for (FoodItem food : sortedList) {

			System.out.println(food);
			count++;

			if (count == 3) {
				break;
			}
		}
	}

	// 15. Remove food items priced below Rs. 100 using Iterator
	public static void removeFoodBelow100() {

		Iterator<FoodItem> itr = foodMenu.iterator();

		while (itr.hasNext()) {

			FoodItem food = itr.next();

			if (food.getPrice() < 100) {
				itr.remove();
				foodMap.remove(food.getFoodId());
			}
		}

		System.out.println("Food items priced below Rs. 100 removed from the menu.");

		displayFoodMenu();
	}

	// 16. Sort orders by total bill in descending order
	public static void displayOrdersByBillDescending() {

		List<Order> sortedOrders = new ArrayList<>(orders);

		Collections.sort(sortedOrders, new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				return Double.compare(o2.getTotalAmount(), o1.getTotalAmount());
			}
		});

		System.out.println("\n========== ORDERS BY TOTAL BILL ==========");

		if (sortedOrders.isEmpty()) {
			System.out.println("No orders available.");
			return;
		}

		for (Order order : sortedOrders) {
			System.out.println(order);
		}
	}

	// 17. Display registered customers
	public static void displayCustomers() {

		System.out.println("\n========== REGISTERED CUSTOMERS ==========");

		for (Map.Entry<Integer, String> entry : customers.entrySet()) {

			System.out.println("Customer ID: " + entry.getKey() + ", Customer Name: " + entry.getValue());
		}
	}
}