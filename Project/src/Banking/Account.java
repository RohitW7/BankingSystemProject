package Banking;

public class Account {

	// Encapsulation: private data members
	private int accNo;
	private String name;
	private double balance;

	// Static variable: shared by all Account objects
	private static int accountCounter = 1000;

	// Final constant
	public static final String BANK_NAME = "ABC Bank";

	// Constructor
	public Account(String name, double balance) {

		accountCounter++;

		this.accNo = accountCounter;
		this.name = name;
		this.balance = balance;
	}

	// Getter for account number
	public int getAccNo() {
		return accNo;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for balance
	public double getBalance() {
		return balance;
	}

	// Deposit money
	public void deposit(double amount) {

		if (amount > 0) {
			balance = balance + amount;
			System.out.println("Amount deposited successfully.");
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	// Withdraw money
	public void withdraw(double amount) {

		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
			System.out.println("Amount withdrawn successfully.");
		} else {
			System.out.println("Insufficient balance or invalid amount.");
		}
	}

	// Display account information
	public void displayAccount() {

		System.out.println("----------------------------");
		System.out.println("Bank Name : " + BANK_NAME);
		System.out.println("Account No: " + accNo);
		System.out.println("Name      : " + name);
		System.out.println("Balance   : " + balance);
		System.out.println("----------------------------");
	}
}
