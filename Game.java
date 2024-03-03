package coffeeshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game  {
	// Create static scanner object (dont think this is good practice but oops)
	static Scanner input = new Scanner(System.in);

	// Rewrites save data
	public void saveFile(Barista user) {
		// Creates savefile.txt in relative path
		File saveFile = new File("src/coffeeshop/savefile.txt");

		// Is the if redundant bc of the exception checking or is this proper practice?
		// Book is confusing me on this
		
			// Files man....
			try (PrintWriter output = new PrintWriter(saveFile);) {
				output.printf("Name: %s\nAge: %d\n", user.getName(), user.getAge());
				output.printf("Level: %d\nFavorite drink: %s", user.getLevel(), user.getFavoriteDrink().getName());
			} catch (FileNotFoundException ex) {
				System.out.println("Error: File not found.\nPlease redownload the game.");
			} catch (Exception ex) {
				ex.printStackTrace();
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
				System.out.println("Error: invalid age.\nPlease enter an integer value");
				input.next(); // Prevents infinite loop
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} while (age == 0); // Does this until the age is populated

		// Creates barista object
		Barista user = new Barista(name, age);
		
		// Saves settings
		saveFile(user);

		return user; // Returns the object
	}

	// Fixed!!!:))
	public void dialog(String path) {

		File file = new File(path);
		String line;

		try (Scanner input = new Scanner(file);) {
			System.out.println();

			while (input.hasNext()) {
				line = input.next();

				if (!line.equals("--")) {
					System.out.print(line + " ");
					Thread.sleep(100); // Makes it look like the message is being typed out
				} else {
					System.out.println();
					Thread.sleep(1500); // Slows each line being printed
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found.\nPlease redownload the game.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
