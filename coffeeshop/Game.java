package coffeeshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	// Create static scanner object (dont think this is good practice but oops)
	static Scanner input = new Scanner(System.in);

	/*
	 * I either want to expand the below method to force the user to use the 
	 * cash register to input the correct order and give proper change right after
	 * getting the order, I don't see why these methods would need to be broken up
	 */
	// Creates 'randomized' customer drink orders 
	public Drink customerOrder(int limit) {
		// Initialize variable
		int randomNumber = 0;

		// I am not sure if this is good practice
		Utilities util = new Utilities();

		// Picks out random drink for customer
		String drinkName = getRandomDrinkName(limit), path = "src/coffeeshop/CustomerDialog.txt";
		Drink d = new Drink(); // I think this is bad practice maybe?
		Drink drink = d.createDrink(drinkName);
		
		/*
		 * Eventually I want to change the line below to pass through only variables.
		 * The start and end points will be the same values but I'll finish all the
		 * dialog, then create a random number, constrain it and then create a start and
		 * end string variable with that number deciding which part of the file is
		 * outputted
		 */

		// Prints dialog
		dialog(path, "*0*", "^0^");
		System.out.print(drinkName);

		// Random number to decides if they are getting anything extra
		randomNumber = util.getConstrainedRandomInt(3);

		// Increases probability of extra chance with 2 of 3 values triggering
		if (randomNumber == 1 || randomNumber == 2) {
			// String array with the first row being starting values and [1][index] being the ending value
			String[][] options = {
					{ "**WithCreamer**", "**WithSugar**", "**WithExtraSugar**", "**WithCreamAndSugar**" },
					{ "^^WithCreamer^^", "^^WithSugar^^", "^^WithExtraSugar^^", "^^WithCreamAndSugar^^" } };
			
			// Changes the value of the random number to inside the limits of array
			randomNumber = util.getConstrainedRandomInt(options[0].length);

			// Prints added dialog 
			dialog(path, options[0][randomNumber], options[1][randomNumber]);
		}
		
		// Returns the drink
		return drink;
	}

	public String getRandomDrinkName(int limit) {
		ArrayList<String> drinks = new ArrayList<>();
		File file = new File("src/coffeeshop/DrinkList.txt");
		String line = "";

		try (Scanner input = new Scanner(file);) {
			System.out.println();

			line = input.nextLine();

			// Ask Williams about the SupressWarnings
			while (input.hasNext() && !line.equals(limit)) {
				drinks.add(line);
				line = input.nextLine();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found.\nPlease redownload the game.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		int randomNumber = (int) ((Math.random() * 100) + 1);
		randomNumber = randomNumber % drinks.size();

		return drinks.get(randomNumber);
	}

	public void dialog(String path, String startPoint, String endPoint) {

		File file = new File(path);
		String line;

		try (Scanner input = new Scanner(file);) {
			System.out.println();

			while (input.hasNext()) {
				line = input.next();

				if (line.equals(startPoint)) {
					while (!line.equals(endPoint)) {
						line = input.next();
						if (!line.equals("--") && !line.equals(endPoint)) {
							System.out.print(line + " ");
							Thread.sleep(100); // Makes it look like the message is being typed out
						} else if (line.equals(endPoint)) {
							// hmmmmm could i break here
						} else {
							System.out.println();
							Thread.sleep(1500); // Slows each line being printed
						}
					}
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found.\nPlease redownload the game.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Fixed!!!:))
	public void dialogFullFile(String path) {

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

	// Sets up the users object
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

	// Rewrites save data
	public void saveFile(Barista user) {
		// Creates savefile.txt in relative path
		File saveFile = new File("src/coffeeshop/savefile.txt");

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
}
