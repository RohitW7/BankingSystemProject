package Banking;

public class SavingAccount extends Account {

	// Final variable: minimum balance required
	public static final double MIN_BALANCE = 1000.0;

	// Constructor
	public SavingAccount(String name, double balance) {

		super(name, balance);
	}

	// Method Overriding
	@Override
	public void withdraw(double amount) {

		if (amount > 0) {

			if (getBalance() - amount >= MIN_BALANCE) {

				// We cannot directly access balance because it is private.
				// So we use the inherited deposit/withdraw functionality.
				super.withdraw(amount);

			} else {

				System.out.println("Withdrawal failed. Minimum balance of " + MIN_BALANCE + " must be maintained.");
			}

		} else {

			System.out.println("Invalid withdrawal amount.");
		}
	}

	// Saving account interest
	public void calculateInterest() {

		double interest = getBalance() * 0.04;

		System.out.println("Saving Account Interest: " + interest);
	}
}
