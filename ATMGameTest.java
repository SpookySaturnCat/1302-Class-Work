package atmgame;

import java.util.Scanner;

public class ATMGameTest {
	public static void main(String[] args) {
		// Create and initilize sentinal
		int idNumber = 3;

		// Create Scanner object and array of accounts
		Scanner input = new Scanner(System.in);
		Account[] accounts = new Account[10];

		// Populates array
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
		}

		// Set the idNumber
		idNumber = ATMGame.getIdNumber(input);
		do {
			// Display main menu
			ATMGame.displayMenu(input, idNumber, accounts);
		} while (idNumber != 672);
	}
}
