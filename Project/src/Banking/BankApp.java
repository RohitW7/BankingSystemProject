package Banking;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Bank bank = new Bank();

		int choice;

		while (true) {

			System.out.println("\n=================================");
			System.out.println("     BANKING MANAGEMENT SYSTEM");
			System.out.println("=================================");
			System.out.println("1. Create Saving Account");
			System.out.println("2. Create Current Account");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Check Balance");
			System.out.println("6. Display All Accounts");
			System.out.println("7. Exit");
			System.out.println("=================================");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:

				sc.nextLine();

				System.out.print("Enter customer name: ");
				String savingName = sc.nextLine();

				System.out.print("Enter initial balance: ");
				double savingBalance = sc.nextDouble();

				bank.createSavingAccount(savingName, savingBalance);

				break;

			case 2:

				sc.nextLine();

				System.out.print("Enter customer name: ");
				String currentName = sc.nextLine();

				System.out.print("Enter initial balance: ");
				double currentBalance = sc.nextDouble();

				bank.createCurrentAccount(currentName, currentBalance);

				break;

			case 3:

				System.out.print("Enter account number: ");
				int depositAccNo = sc.nextInt();

				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();

				bank.deposit(depositAccNo, depositAmount);

				break;

			case 4:

				System.out.print("Enter account number: ");
				int withdrawAccNo = sc.nextInt();

				System.out.print("Enter withdrawal amount: ");
				double withdrawAmount = sc.nextDouble();

				bank.withdraw(withdrawAccNo, withdrawAmount);

				break;

			case 5:

				System.out.print("Enter account number: ");
				int balanceAccNo = sc.nextInt();

				bank.checkBalance(balanceAccNo);

				break;

			case 6:

				bank.displayAllAccounts();

				break;

			case 7:

				System.out.println("Thank you for using ABC Bank.");
				sc.close();
				System.exit(0);

				break;

			default:

				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
