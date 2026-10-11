package Banking;

public class CurrentAccount extends Account {

	// Final constant
	public static final double MIN_BALANCE = 5000.0;

	// Constructor
	public CurrentAccount(String name, double balance) {

		super(name, balance);
	}

	// Method Overriding
	@Override
	public void withdraw(double amount) {

		if (amount > 0) {

			if (getBalance() - amount >= MIN_BALANCE) {

				super.withdraw(amount);

			} else {

				System.out.println("Withdrawal failed. Minimum balance of " + MIN_BALANCE + " must be maintained.");
			}

		} else {

			System.out.println("Invalid withdrawal amount.");
		}
	}

	// Current account service charge
	public void serviceCharge() {

		double charge = 200.0;

		System.out.println("Service Charge: " + charge);
	}
}
