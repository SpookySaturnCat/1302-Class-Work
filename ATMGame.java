import java.util.Scanner;

public class ATMGame {
	public static void main(String[] args) {
		// Create and initilize sentinal
		int userNumber = 3;

		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Creates an array of accounts
		Account[] accounts = new Account[10];

		// Populates array
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
		}
		// Do while to get user to enter if for program
		do {
			// Prompt user to enter an id
			System.out.print("Please enter an id: ");
			userNumber = input.nextInt();

			// Checks to see if entered value is in range of 0-9
			if (userNumber < 0 || userNumber > 10) {
				System.out.println("Please enter a correct ID");
			}
		} while (userNumber < 0 || userNumber > 10);
	}
}
