/*
 *  Actual game
 */
package coffeeshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {
	// Create static scanner object (dont think this is good practice but oops)
	static Scanner input = new Scanner(System.in);

	// Rewrites save data
	public void saveFile(Barista user) {
		// Creates savefile.txt in relative path
		File saveFile = new File("src/coffeeshop/savefile.txt");
		
		// Files man....
		try (PrintWriter output = new PrintWriter(saveFile);) 
		
		{
			output.printf("Name: %s\nAge: %d\n", user.getName(), user.getAge());
			output.printf("Level: %d\nFavorite drink: %s", user.getLevel(), user.getFavoriteDrink().getName());
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found.\nPlease redownload the game.");
		}
	}

	// Sets up the users
	public Barista playerSetUp() {
		// Initialize variable
		int age = 0;
		
		// Prompt user and stores data
		System.out.print("Please enter your name: ");
		String name = input.nextLine();
		
		// Error checking for user 
		name = Utilities.checkString(name);

		do {
			// Makes sure the user enters an integer
			try {
				// Prompts and stores age
				System.out.print("Please enter your age: ");
				age = input.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Error: invalid age");
				input.next(); // Prevents infinite loop
			}
		} while (age == 0); // Does this until the age is populated

		// Creates barista object
		Barista user = new Barista(name, age);

		return user; // Returns the object
	}

	// Fixed!!!:))
	public void welcome() throws IOException {

		File welcomeFile = new File("src/coffeeshop/welcome.txt");
		String line;

		try (Scanner input = new Scanner(welcomeFile);)

		{
			while (input.hasNext()) {
				line = input.next();

				if (!line.equals("--")) {
					System.out.print(line + " ");
				} else {
					System.out.println();
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found.\nPlease redownload the game.");
		}
	}

}
