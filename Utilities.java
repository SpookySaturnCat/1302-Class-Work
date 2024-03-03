package coffeeshop;

public class Utilities {

	public static String checkString(String word) {
		int choice = 0;
		// If they do not confirm the word do this until they do
		do {
			// Prompt user and get answer
			System.out.printf("Are you sure you meant to enter %s?\n" + "Enter 1 for yes and 2 for no: ", word);
			choice = CoffeeShop.input.nextInt();
			CoffeeShop.input.nextLine();
			
			// Displays error message
			if (choice != 1 && choice != 2) {
				System.out.println("\nError: invalid entry\nTry again!");
			}
			
			if (choice == 2) {
				System.out.print("\nPlease reenter your choice: ");
				word = CoffeeShop.input.nextLine();
			}
		} while (choice != 1);
		// Return the word
		return word;
	}
	
	public int getConstrainedRandomInt(int limit) {
		int randomNumber = (int) ((Math.random() * 100) + 1);	
		if (randomNumber != 0) {
		return randomNumber % limit;
		} else {
			return 0;
		}
	}
}
