package Banking;

public class Bank {

	// Array to store accounts
	private Account[] accounts;

	// To keep track of number of accounts
	private int accountCount;

	// Constructor
	public Bank() {
		accounts = new Account[100];
		accountCount = 0;
	}

	// Create a Saving Account
	public void createSavingAccount(String name, double balance) {

		if (accountCount < accounts.length) {

			accounts[accountCount] = new SavingAccount(name, balance);

			accountCount++;

			System.out.println("Saving Account created successfully.");
			System.out.println("Account Number: " + accounts[accountCount - 1].getAccNo());

		} else {

			System.out.println("Bank account limit reached.");
		}
	}

	// Create a Current Account
	public void createCurrentAccount(String name, double balance) {

		if (accountCount < accounts.length) {

			accounts[accountCount] = new CurrentAccount(name, balance);

			accountCount++;

			System.out.println("Current Account created successfully.");
			System.out.println("Account Number: " + accounts[accountCount - 1].getAccNo());

		} else {

			System.out.println("Bank account limit reached.");
		}
	}

	// Search account by account number
	public Account findAccount(int accNo) {

		for (int i = 0; i < accountCount; i++) {

			if (accounts[i].getAccNo() == accNo) {
				return accounts[i];
			}
		}

		return null;
	}

	// Deposit money
	public void deposit(int accNo, double amount) {

		Account account = findAccount(accNo);

		if (account != null) {

			account.deposit(amount);

		} else {

			System.out.println("Account not found.");
		}
	}

	// Withdraw money
	public void withdraw(int accNo, double amount) {

		Account account = findAccount(accNo);

		if (account != null) {

			account.withdraw(amount);

		} else {

			System.out.println("Account not found.");
		}
	}

	// Check balance
	public void checkBalance(int accNo) {

		Account account = findAccount(accNo);

		if (account != null) {

			System.out.println("----------------------------");
			System.out.println("Account No : " + account.getAccNo());
			System.out.println("Name       : " + account.getName());
			System.out.println("Balance    : " + account.getBalance());
			System.out.println("----------------------------");

		} else {

			System.out.println("Account not found.");
		}
	}

	// Display all accounts
	public void displayAllAccounts() {

		if (accountCount == 0) {

			System.out.println("No accounts available.");

		} else {

			System.out.println("\n===== ALL ACCOUNTS =====");

			for (int i = 0; i < accountCount; i++) {

				accounts[i].displayAccount();
			}
		}
	}
}