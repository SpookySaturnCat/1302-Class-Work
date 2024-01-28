package atmgame;

import java.util.Scanner;

public class ATMGame {
	
	public static int getIdNumber(Scanner input) {
		int idNumber = 0;
		// Do while to get user to enter if for program
		do {
			// Prompt user to enter an id
			System.out.print("Please enter an id: ");
			idNumber = input.nextInt();

			// Checks to see if entered value is in range of 0-9
			if (idNumber < 0 || idNumber >= 10) {
				System.out.println("Please enter a correct ID");
			}
		} while (idNumber < 0 || idNumber >= 10);

		return idNumber;
	}

	public static void displayMenu(Scanner input, int idNumber, Account[] accounts) {
		// Prompt user
		System.out.printf("%nMain Menu%n1: check balance%n" + "2: withdraw%n3: deposit%n4: exit%n%nEnter a choice: ");
		int choice = input.nextInt(); // Save user choice

		switch (choice) {
		case 1:
			// Prints balance
			System.out.print("$" + accounts[idNumber].getBalance() + "\n");
			break;
		case 2:
			// Withdraws from account
			char transactionType = 'w';
			displayWithdrawOrDeposit(input, idNumber, accounts, transactionType);
			break;
		case 3:
			// Deposits to account
			transactionType = 'd';
			displayWithdrawOrDeposit(input, idNumber, accounts, transactionType);
			break;
		case 4:
			// Exits account and allows for new account to be acsessed
			idNumber = getIdNumber(input);
			displayMenu(input, idNumber, accounts);
			break;
		default:
			// Prinrs error message and restarts the menu
			System.out.println("Invalid entry, please try again.");
			displayMenu(input, idNumber, accounts);
		}
	}

	public static void displayWithdrawOrDeposit(Scanner input, int idNumber, Account[] accounts, char transactionType) {
		// Initilize variables
		String transactionString = "deposit";
		double amount = 0;

		// Check if string value needs to be changed
		if (transactionType == 'w') {
			transactionString = "withdraw";
		}
		// Prompt user
		System.out.printf("Enter amount to %s: ", transactionString);
		amount = input.nextDouble();

		// Checks string of transaction type and preforms action based on that
		if (transactionString.equals("withdraw")) {
			accounts[idNumber].withdraw(amount);
		}

		if (transactionString.equals("deposit")) {
			accounts[idNumber].deposit(amount);
		}
	}
}
